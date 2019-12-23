package com.crud.nbpclient.domain.chf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoChf {
    private Long id;
    private String name;
    private String date;
    private double midPLN;
}
