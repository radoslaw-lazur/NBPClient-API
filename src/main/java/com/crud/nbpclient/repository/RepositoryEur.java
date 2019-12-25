package com.crud.nbpclient.repository;

import com.crud.nbpclient.domain.eur.Eur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryEur extends CrudRepository<Eur, Long> {
    @Override
    List<Eur> findAll();
    @Override
    Eur save(Eur eur);
    @Override
    void deleteAll();
    @Override
    long count();
}
