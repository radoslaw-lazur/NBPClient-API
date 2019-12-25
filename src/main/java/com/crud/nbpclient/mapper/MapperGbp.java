package com.crud.nbpclient.mapper;

import com.crud.nbpclient.domain.gbp.DtoGbp;
import com.crud.nbpclient.domain.gbp.Gbp;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperGbp {

    public Gbp mapToGbp(final DtoGbp dtoGbp) {
        return new Gbp(
                dtoGbp.getId(),
                dtoGbp.getName(),
                dtoGbp.getDate(),
                dtoGbp.getMidPLN()
        );
    }

    public List<DtoGbp> mapToGbpList(final List<Gbp> gbpList) {
        return gbpList.stream()
                .map(t -> new DtoGbp(t.getId(), t.getName(), t.getDate(), t.getMidPLN()))
                .collect(Collectors.toList());
    }
}
