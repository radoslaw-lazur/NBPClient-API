package com.crud.nbpclient.mapper;

import com.crud.nbpclient.domain.eur.DtoEur;
import com.crud.nbpclient.domain.eur.Eur;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperEur {

    public Eur mapToEur(final DtoEur dtoEur) {
        return new Eur(
                dtoEur.getId(),
                dtoEur.getName(),
                dtoEur.getDate(),
                dtoEur.getMidPLN()
        );
    }

    public List<DtoEur> mapToEurList(final List<Eur> eurList) {
        return eurList.stream()
                .map(t -> new DtoEur(t.getId(), t.getName(), t.getDate(), t.getMidPLN()))
                .collect(Collectors.toList());
    }
}
