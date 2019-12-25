package com.crud.nbpclient.domain.gbp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "GBP")
public class Gbp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "GBP")
    private String name;
    @Column(name = "Date")
    private String date;
    @Column(name = "PLNvalue")
    private double midPLN;
}
