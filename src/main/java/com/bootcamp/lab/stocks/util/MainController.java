package com.bootcamp.lab.stocks.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.io.File;
import java.io.IOException;
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
        qr.saveAll(Downloader.download(new File("/Users/karimabounassif/BootCamp/stocks/src/main/resources/dataset.json")));
        return "Saved.";
    }

    @GetMapping("/pop")
    public @ResponseBody String getPopulate() throws IOException {
        qr.saveAll(Downloader.download(new File("/Users/karimabounassif/BootCamp/stocks/src/main/resources/dataset.json")));
        return "Saved.";
    }

    @GetMapping("/{symbol}/{date}")
    public @ResponseBody String agg(@PathVariable(value = "symbol") String symbol, @PathVariable(value = "date") String date) throws ParseException {
        Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        QuoteAgg results;
        results = qr.aggResults(symbol, toDate);
        results.setClosing(qr.closing(symbol, toDate));
        results.setSymbol(symbol);
        results.setDate(toDate.toString());
        return results.displayAgg();
    }
}
