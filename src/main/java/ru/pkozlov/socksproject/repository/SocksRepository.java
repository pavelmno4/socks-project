package ru.pkozlov.socksproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pkozlov.socksproject.domain.Socks;

import java.util.List;

public interface SocksRepository extends JpaRepository<Socks, Long> {
    List<Socks> findAllByDeletedFalse();
}
