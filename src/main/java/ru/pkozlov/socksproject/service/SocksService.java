package ru.pkozlov.socksproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pkozlov.socksproject.domain.Socks;
import ru.pkozlov.socksproject.dto.SocksDto;
import ru.pkozlov.socksproject.filter.Filter;
import ru.pkozlov.socksproject.mapper.SocksMapper;
import ru.pkozlov.socksproject.repository.SocksRepository;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class SocksService {
    private final SocksRepository socksRepository;
    private final FilterService filterService;

    public void income(SocksDto socksDto) {
        List<Socks> socksList = IntStream.range(0, socksDto.getQuantity())
                .mapToObj(i -> SocksMapper.mapToEntity(socksDto))
                .toList();
        socksRepository.saveAll(socksList);
    }

    public void outcome(SocksDto socksDto) {
        List<Socks> socksList = findSocks(filterService.createFilters(socksDto))
                .peek(socks -> socks.setDeleted(true))
                .limit(socksDto.getQuantity())
                .toList();
        socksRepository.saveAll(socksList);
    }

    public long getSocksCount(Set<Filter> filters) {
        return findSocks(filters).count();
    }

    private Stream<Socks> findSocks(Set<Filter> filters) {
        return socksRepository.findAllByDeletedFalse().stream()
                .filter(filters.stream()
                        .map(Filter::getPredicate)
                        .reduce(Predicate::and)
                        .orElseGet(() -> socks -> true)
                );
    }
}
