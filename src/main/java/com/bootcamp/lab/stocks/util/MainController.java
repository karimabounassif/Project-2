package com.bootcamp.lab.stocks.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/quotes")
public class MainController {

    @Autowired
    private QuoteRepository qr;

    @PostMapping("/pop")
    public @ResponseBody String populate() throws IOException {
        qr.saveAll(Downloader.download(new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json")));
        return "Saved.";
    }

    @GetMapping("/pop")
    public @ResponseBody String getPopulate() throws IOException {
        qr.saveAll(Downloader.download(new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json")));
        return "Saved.";
    }

    @GetMapping("/{symbol}/{date}")
    public @ResponseBody QuoteAgg agg(@PathVariable(value = "symbol") String symbol, @PathVariable(value = "date") String date) throws ParseException {
        Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        QuoteAgg results;
        results = qr.aggResults(symbol, toDate);
        results.setClosing(qr.closing(symbol, toDate));
        results.setSymbol(symbol);
        results.setDate(toDate.toString());
        return results;
    }

    @GetMapping("/monthly/{symbol}/{date}")
    public @ResponseBody QuoteAgg monthlyAgg(@PathVariable(value = "symbol") String symbol, @PathVariable(value = "date") String date) throws ParseException {
        String year = date.split("-")[0];
        String month = date.split("-")[1];
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(year+"-"+month+"-01");
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(year+"-"+String.valueOf(Integer.parseInt(month)+1)+"-01");
        QuoteAgg mAgg;
        mAgg = qr.monthlyAgg(start, end, symbol);
        mAgg.setSymbol(symbol);
        mAgg.setDate(start.toString());
        mAgg.setClosing(0);
        return mAgg;
    }
}
