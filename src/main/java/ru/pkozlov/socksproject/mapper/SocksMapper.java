package ru.pkozlov.socksproject.mapper;

import ru.pkozlov.socksproject.domain.Socks;
import ru.pkozlov.socksproject.dto.SocksDto;

public class SocksMapper {

    public static Socks mapToEntity(SocksDto dto) {
        Socks socks = new Socks();
        socks.setColor(dto.getColor());
        socks.setCottonPart(dto.getCottonPart());
        return socks;
    }
}
