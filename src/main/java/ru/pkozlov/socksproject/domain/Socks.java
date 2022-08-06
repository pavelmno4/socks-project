package ru.pkozlov.socksproject.domain;

import lombok.Data;

@Data
public class Socks {
    private final Long id;
    private final Color color;
    private final Integer cottonPart;
}
