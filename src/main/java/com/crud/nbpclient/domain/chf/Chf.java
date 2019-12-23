package com.crud.nbpclient.domain.chf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "CHF")
public class Chf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CHF")
    private String name;
    @Column(name = "Date")
    private String date;
    @Column(name = "PLNvalue")
    private double midPLN;
}
