package com.crud.nbpclient.mapper;

import com.crud.nbpclient.domain.chf.Chf;
import com.crud.nbpclient.domain.chf.DtoChf;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperChf {

    public Chf mapToChf(final DtoChf chfDto) {
        return new Chf(
                chfDto.getId(),
                chfDto.getName(),
                chfDto.getDate(),
                chfDto.getMidPLN()
        );
    }

    public List<DtoChf> mapToChfdToList(final List<Chf> chfList) {
        return chfList.stream()
                .map(t -> new DtoChf(t.getId(), t.getName(), t.getDate(), t.getMidPLN()))
                .collect(Collectors.toList());
    }
}
