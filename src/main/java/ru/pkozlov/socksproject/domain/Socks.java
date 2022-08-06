package ru.pkozlov.socksproject.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(nullable = false)
    private Integer cottonPart;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = LocalDateTime.now();
    }
}
