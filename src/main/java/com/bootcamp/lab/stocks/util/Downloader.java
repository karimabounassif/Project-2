package com.bootcamp.lab.stocks.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Downloader {

    public static List<Quote> download(File url) throws IOException {
        List<Quote> quotes;
        ObjectMapper map = new ObjectMapper();
        quotes = (map.readValue(url, new TypeReference<List<Quote>>(){}));
        return quotes;
    }

}
