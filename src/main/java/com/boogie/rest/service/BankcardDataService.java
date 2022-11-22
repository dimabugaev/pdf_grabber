package com.boogie.rest.service;

import com.boogie.rest.entity.BankcardData;

import java.io.IOException;

public interface BankcardDataService {
    BankcardData getBankcardData(byte[] inputData) throws IOException;
    BankcardData getBankcardData(byte[] inputData, String pwd) throws IOException;
}
