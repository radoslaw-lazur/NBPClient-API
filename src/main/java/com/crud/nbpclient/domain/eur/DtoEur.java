package com.crud.nbpclient.domain.eur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoEur {
    private Long id;
    private String name;
    private String date;
    private double midPLN;
}
