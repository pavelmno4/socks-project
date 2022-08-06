package ru.pkozlov.socksproject.dto;

import lombok.Data;
import ru.pkozlov.socksproject.domain.Color;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SocksDto {
    @NotNull
    private final Color color;
    @NotNull @Min(0) @Max(100)
    private final Integer cottonPart;
    @NotNull @Min(1)
    private final Integer quantity;
}
