package ru.pkozlov.socksproject.filter;

import lombok.RequiredArgsConstructor;
import ru.pkozlov.socksproject.domain.Color;
import ru.pkozlov.socksproject.domain.Socks;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class ColorFilter implements Filter {
    private final Color color;

    @Override
    public Predicate<Socks> getPredicate() {
        return socks -> socks.getColor().equals(color);
    }
}
