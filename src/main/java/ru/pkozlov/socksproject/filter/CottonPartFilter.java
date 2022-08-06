package ru.pkozlov.socksproject.filter;

import lombok.RequiredArgsConstructor;
import ru.pkozlov.socksproject.domain.Socks;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class CottonPartFilter implements Filter {
    private final Operation operation;
    private final Integer cottonPart;

    @Override
    public Predicate<Socks> getPredicate() {
        return socks -> switch (operation) {
            case MORE_THAN -> socks.getCottonPart().compareTo(cottonPart) >= 1;
            case LESS_THAN -> socks.getCottonPart().compareTo(cottonPart) <= -1;
            case EQUAL -> socks.getCottonPart().compareTo(cottonPart) == 0;
        };
    }
}
