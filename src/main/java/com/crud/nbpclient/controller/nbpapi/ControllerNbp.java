package com.crud.nbpclient.controller.nbpapi;

import com.crud.nbpclient.client.ClientNbp;
import com.crud.nbpclient.domain.chf.DtoChf;
import com.crud.nbpclient.domain.eur.DtoEur;
import com.crud.nbpclient.domain.gbp.DtoGbp;
import com.crud.nbpclient.mapper.MapperChf;
import com.crud.nbpclient.mapper.MapperEur;
import com.crud.nbpclient.mapper.MapperGbp;
import com.crud.nbpclient.service.currency.ServiceChf;
import com.crud.nbpclient.service.currency.ServiceEur;
import com.crud.nbpclient.service.currency.ServiceGbp;
import com.crud.nbpclient.service.jsonreader.JsonReaderChf;
import com.crud.nbpclient.service.jsonreader.JsonReaderEur;
import com.crud.nbpclient.service.jsonreader.JsonReaderGbp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@Component
@RequestMapping("/v1/nbp")
public class ControllerNbp {
    @Autowired
    private ServiceChf serviceChf;
    @Autowired
    private ServiceEur serviceEur;
    @Autowired
    private ServiceGbp serviceGbp;
    @Autowired
    private ClientNbp clientNbp;
    @Autowired
    private MapperChf chfMapper;
    @Autowired
    private MapperEur eurMapper;
    @Autowired
    private MapperGbp gbpMapper;
    private JsonReaderChf jsonReaderChf = new JsonReaderChf();
    private JsonReaderEur jsonReaderEur = new JsonReaderEur();
    private JsonReaderGbp jsonReaderGbp = new JsonReaderGbp();

    @PostMapping(value = "saveCHF")
    public void saveCHF() {
        log.info("Starting saving CHF...");
        String json = clientNbp.getStringJsonChf();
        DtoChf chfToDb = jsonReaderChf.prepareChfToDb(json);
        serviceChf.saveChf(chfMapper.mapToChf(chfToDb));
        log.info("CHF has been saved");
    }

    @PostMapping(value = "saveEUR")
    public void saveEUR() {
        log.info("Starting saving EUR...");
        String json = clientNbp.getStringJsonEur();
        DtoEur eurToDb = jsonReaderEur.prepareEurToDb(json);
        serviceEur.saveEur(eurMapper.mapToEur(eurToDb));
        log.info("EUR has been saved");
    }

    @PostMapping(value = "saveGBP")
    public void saveGBP() {
        log.info("Starting saving GBP...");
        String json = clientNbp.getStringJsonGbp();
        DtoGbp gbpToDb = jsonReaderGbp.prepareGbpToDb(json);
        serviceGbp.saveGbp(gbpMapper.mapToGbp(gbpToDb));
        log.info("GBP has been saved");
    }
}
