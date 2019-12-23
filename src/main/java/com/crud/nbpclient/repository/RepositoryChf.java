package com.crud.nbpclient.repository;

import com.crud.nbpclient.domain.chf.Chf;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryChf extends CrudRepository<Chf, Long> {
    @Override
    List<Chf> findAll();
    @Override
    Chf save(Chf chf);
    @Override
    void deleteAll();
}
