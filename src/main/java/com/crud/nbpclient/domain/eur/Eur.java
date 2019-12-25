package com.crud.nbpclient.domain.eur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "EUR")
public class Eur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "EUR")
    private String name;
    @Column(name = "Date")
    private String date;
    @Column(name = "PLNvalue")
    private double midPLN;
}
