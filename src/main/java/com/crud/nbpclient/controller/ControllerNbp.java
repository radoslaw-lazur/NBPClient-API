package com.crud.nbpclient.controller;

import com.crud.nbpclient.client.ClientNbp;
import com.crud.nbpclient.domain.chf.Chf;
import com.crud.nbpclient.service.JsonReaderChf;
import com.crud.nbpclient.service.ServiceChf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/nbp")
public class ControllerNbp {
    @Autowired
    private ServiceChf serviceChf;
    @Autowired
    private ClientNbp clientNbp;
    private JsonReaderChf jsonReaderChf = new JsonReaderChf();

    @PostMapping(value = "saveCHF")
    public void saveCHF() {
        String json = clientNbp.getStringJson();
        Chf chfToDb = jsonReaderChf.prepareChfToDb(json);
        serviceChf.saveChf(chfToDb);
    }
}
