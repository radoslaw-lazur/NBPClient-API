package com.crud.nbpclient.controller.database;

import com.crud.nbpclient.domain.eur.DtoEur;
import com.crud.nbpclient.mapper.MapperEur;
import com.crud.nbpclient.service.currency.ServiceEur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/eur")
public class ControllerEur {
    @Autowired
    private MapperEur eurMapper;
    @Autowired
    private ServiceEur eurService;

    @GetMapping(value = "getEURs")
    public List<DtoEur> getEURs() {
        return eurMapper.mapToEurList(eurService.getAllEur());
    }

    @PostMapping(value = "postEUR")
    public void postEUR(@RequestBody DtoEur eurDto) {
        eurService.saveEur(eurMapper.mapToEur(eurDto));
    }

    @DeleteMapping(value = "deleteEURs")
    public void deleteEURs() {
        eurService.deleteAllEur();
    }
}
