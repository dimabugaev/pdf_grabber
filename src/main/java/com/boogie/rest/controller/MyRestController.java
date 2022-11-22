package com.boogie.rest.controller;


import com.boogie.rest.entity.BankcardData;
import com.boogie.rest.exeption_handling.BadDataIncomingException;
import com.boogie.rest.service.BankcardDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private BankcardDataService bankcardDataService;

    @PostMapping("/bankcarddata")
    public BankcardData transformAndReturnBankcardData(@RequestBody byte[] binaryDataPDF){


        BankcardData bankcardData = null;
        try {
            bankcardData = bankcardDataService.getBankcardData(binaryDataPDF, "622076");
        } catch (IOException e) {
            throw new BadDataIncomingException("Wrong incoming data!!!");
        }

        if (bankcardData == null){
            throw new BadDataIncomingException("Wrong incoming data!!!");
        }

        return bankcardData;
    }
}
