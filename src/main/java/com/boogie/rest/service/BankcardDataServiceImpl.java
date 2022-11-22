package com.boogie.rest.service;

import com.boogie.rest.entity.BankcardData;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BankcardDataServiceImpl implements BankcardDataService{
    @Override
    public BankcardData getBankcardData(byte[] inputData) throws IOException {

        PDDocument document = PDDocument.load(inputData);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String pdfText = pdfStripper.getText(document);

        return fillBankcardDataByText(pdfText);
    }

    @Override
    public BankcardData getBankcardData(byte[] inputData, String pwd) throws IOException {
        PDDocument document = PDDocument.load(inputData, pwd);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String pdfText = pdfStripper.getText(document);

        return fillBankcardDataByText(pdfText);
    }

    private BankcardData fillBankcardDataByText(String pdfText){
        BankcardData bankcardData = new BankcardData();
        Boolean result = true;
        Matcher matcher = null;
        matcher = Pattern.compile("\\d{16}").matcher(pdfText);
        if (matcher.find()) bankcardData.setCard(matcher.group());
        else result = false;

        matcher = Pattern.compile("\\d{2}\\/\\d{2}").matcher(pdfText);
        if (matcher.find()) bankcardData.setPeriod(matcher.group());
        else result = false;

        matcher = Pattern.compile("(?<=CVV2\\/CVC2 )\\d+").matcher(pdfText);
        if (matcher.find()) bankcardData.setCvv(matcher.group());
        else result = false;

        matcher = Pattern.compile("(?<=Имя владельца )\\w+\\ \\w+").matcher(pdfText);
        if (matcher.find()) bankcardData.setHolder(matcher.group());
        else result = false;

        matcher = Pattern.compile("(?<=Бронирование № )\\d+").matcher(pdfText);
        if (matcher.find()) bankcardData.setReserv(matcher.group());
        else result = false;

        if (!result)
            return null;
        else
            return bankcardData;
    }
}
