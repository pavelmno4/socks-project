package ru.pkozlov.socksproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pkozlov.socksproject.filter.Filter;
import ru.pkozlov.socksproject.repository.SocksRepository;

import java.util.Set;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class SocksService {
    private final SocksRepository socksRepository;

    public long getSocksCount(Set<Filter> filters) {
        return socksRepository.findAll().stream()
                .filter(filters.stream()
                        .map(Filter::getPredicate)
                        .reduce(Predicate::and)
                        .orElseGet(() -> socks -> true)
                )
                .count();

    }
}
