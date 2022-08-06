package ru.pkozlov.socksproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pkozlov.socksproject.domain.Color;
import ru.pkozlov.socksproject.dto.ResponseDto;
import ru.pkozlov.socksproject.filter.Operation;
import ru.pkozlov.socksproject.service.FilterService;
import ru.pkozlov.socksproject.service.SocksService;

@RestController
@RequiredArgsConstructor
public class SocksController {
    private final SocksService socksService;
    private final FilterService filterService;

    @GetMapping("/api/socks")
    public ResponseDto getSocks(
            @RequestParam(required = false) Color color,
            @RequestParam(required = false) Operation operation,
            @RequestParam(required = false) Integer cottonPart
    ) {
        var count = socksService.getSocksCount(filterService.createFilters(color, operation, cottonPart));
        return new ResponseDto(String.valueOf(count));
    }
}
