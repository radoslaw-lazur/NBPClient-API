package com.crud.nbpclient.service.currency;

import com.crud.nbpclient.domain.eur.Eur;
import com.crud.nbpclient.repository.RepositoryEur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEur {
    @Autowired
    private RepositoryEur repositoryEur;

    public List<Eur> getAllEur() {
        return repositoryEur.findAll();
    }

    public Eur saveEur(final Eur eur) {
        return repositoryEur.save(eur);
    }

    public void deleteAllEur() {
        repositoryEur.deleteAll();
    }
}
