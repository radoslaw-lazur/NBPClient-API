package com.crud.nbpclient.controller.database;

import com.crud.nbpclient.domain.gbp.DtoGbp;
import com.crud.nbpclient.mapper.MapperGbp;
import com.crud.nbpclient.service.currency.ServiceGbp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/gbp")
public class ControllerGbp {
    @Autowired
    private MapperGbp gbpMapper;
    @Autowired
    private ServiceGbp gbpService;

    @GetMapping(value = "getGBPs")
    public List<DtoGbp> getGBPs() {
        return gbpMapper.mapToGbpList(gbpService.getAllGbp());
    }

    @PostMapping(value = "saveGBP")
    public void postGBP(@RequestBody DtoGbp gbpDto) {
        gbpService.saveGbp(gbpMapper.mapToGbp(gbpDto));
    }

    @DeleteMapping(value = "deleteGBPs")
    public void deleteGBPs() {
        gbpService.deleteAllGbp();
    }
}
