package com.crud.nbpclient.domain.chf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoChf {
    private Long id;
    private String name;
    private String date;
    private double midPLN;
}
