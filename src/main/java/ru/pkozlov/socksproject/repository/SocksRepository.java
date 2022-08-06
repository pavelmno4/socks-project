package ru.pkozlov.socksproject.repository;

import org.springframework.stereotype.Component;
import ru.pkozlov.socksproject.domain.Color;
import ru.pkozlov.socksproject.domain.Socks;

import java.util.List;

@Component
public class SocksRepository {
    public List<Socks> findAll() {
        return List.of(
                new Socks(1L, Color.BLACK, 95),
                new Socks(1L, Color.WHITE, 80),
                new Socks(1L, Color.BLACK, 75),
                new Socks(1L, Color.RED, 85)
        );
    }
}
