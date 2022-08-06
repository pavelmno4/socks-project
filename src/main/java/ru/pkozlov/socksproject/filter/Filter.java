package ru.pkozlov.socksproject.filter;

import ru.pkozlov.socksproject.domain.Socks;

import java.util.function.Predicate;

public interface Filter {
    Predicate<Socks> getPredicate();
}
