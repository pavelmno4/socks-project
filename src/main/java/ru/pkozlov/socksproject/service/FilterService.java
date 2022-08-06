package ru.pkozlov.socksproject.service;

import org.springframework.stereotype.Service;
import ru.pkozlov.socksproject.domain.Color;
import ru.pkozlov.socksproject.dto.SocksDto;
import ru.pkozlov.socksproject.filter.ColorFilter;
import ru.pkozlov.socksproject.filter.CottonPartFilter;
import ru.pkozlov.socksproject.filter.Filter;
import ru.pkozlov.socksproject.filter.Operation;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FilterService {

    public Set<Filter> createFilters(
            Color color,
            Operation operation,
            Integer cottonPart
    ) {
        return Stream.of(
                        createColorFilter(color),
                        createCottonPartFilter(operation, cottonPart)
                ).filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public Set<Filter> createFilters(SocksDto socksDto) {
        return Stream.of(
                        createColorFilter(socksDto.getColor()),
                        createCottonPartFilter(Operation.EQUAL, socksDto.getCottonPart())
                ).filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private ColorFilter createColorFilter(Color color) {
        return color == null ? null : new ColorFilter(color);
    }

    private CottonPartFilter createCottonPartFilter(Operation operation, Integer cottonPart) {
        return (operation == null || cottonPart == null) ? null : new CottonPartFilter(operation, cottonPart);
    }
}
