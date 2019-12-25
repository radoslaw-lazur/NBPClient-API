package com.crud.nbpclient.repository;

import com.crud.nbpclient.domain.gbp.Gbp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryGbp extends CrudRepository<Gbp, Long> {
    @Override
    List<Gbp> findAll();
    @Override
    Gbp save(Gbp gbp);
    @Override
    void deleteAll();
    @Override
    long count();
}
