package com.crud.nbpclient.service;

import com.crud.nbpclient.domain.chf.Chf;
import com.crud.nbpclient.repository.RepositoryChf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceChf {
    @Autowired
    private RepositoryChf repositoryChf;

    public List<Chf> getAllChf() {
        return repositoryChf.findAll();
    }

    public Chf saveChf(final Chf chf) {
        return repositoryChf.save(chf);
    }

    public void deleteAllChf() {
        repositoryChf.deleteAll();
    }
}
