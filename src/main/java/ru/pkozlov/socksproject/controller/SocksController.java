package ru.pkozlov.socksproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.pkozlov.socksproject.domain.Color;
import ru.pkozlov.socksproject.dto.CountDto;
import ru.pkozlov.socksproject.dto.SocksDto;
import ru.pkozlov.socksproject.filter.Operation;
import ru.pkozlov.socksproject.service.FilterService;
import ru.pkozlov.socksproject.service.SocksService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SocksController {
    private final SocksService socksService;
    private final FilterService filterService;

    @PostMapping("/api/socks/income")
    public void income(@RequestBody @Valid SocksDto socksDto) {
        socksService.income(socksDto);
    }

    @PostMapping("/api/socks/outcome")
    public void outcome(@RequestBody @Valid SocksDto socksDto) {
        socksService.outcome(socksDto);
    }

    @GetMapping("/api/socks")
    public CountDto getSocks(
            @RequestParam(required = false) Color color,
            @RequestParam(required = false) Operation operation,
            @RequestParam(required = false) Integer cottonPart
    ) {
        var count = socksService.getSocksCount(filterService.createFilters(color, operation, cottonPart));
        return new CountDto(String.valueOf(count));
    }
}
