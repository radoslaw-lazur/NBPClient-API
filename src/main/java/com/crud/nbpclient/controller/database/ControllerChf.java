package com.crud.nbpclient.controller.database;

import com.crud.nbpclient.domain.chf.DtoChf;
import com.crud.nbpclient.mapper.MapperChf;
import com.crud.nbpclient.service.currency.ServiceChf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/chf")
public class ControllerChf {
    @Autowired
    private MapperChf chfMapper;
    @Autowired
    private ServiceChf chfService;

    @GetMapping(value = "getCHFs")
    public List<DtoChf> getCHFs() {
        return chfMapper.mapToChfdToList(chfService.getAllChf());
    }

    @PostMapping(value = "postCHF")
    public void postCHF(@RequestBody DtoChf chfDto) {
        chfService.saveChf(chfMapper.mapToChf(chfDto));
    }

    @DeleteMapping(value = "deleteCHFs")
    public void deleteCHFs() {
        chfService.deleteAllChf();
    }
}
