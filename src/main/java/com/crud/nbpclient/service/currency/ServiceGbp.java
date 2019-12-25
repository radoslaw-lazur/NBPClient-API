package com.crud.nbpclient.service.currency;

import com.crud.nbpclient.domain.gbp.Gbp;
import com.crud.nbpclient.repository.RepositoryGbp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceGbp {
    @Autowired
    private RepositoryGbp repositoryGbp;

    public List<Gbp> getAllGbp() {
        return repositoryGbp.findAll();
    }

    public Gbp saveGbp(final Gbp gbp) {
        return repositoryGbp.save(gbp);
    }

    public void deleteAllGbp() {
        repositoryGbp.deleteAll();
    }
}
