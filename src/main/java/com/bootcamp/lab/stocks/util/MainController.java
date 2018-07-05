package com.bootcamp.lab.stocks.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/quotes")
public class MainController {

    @Autowired
    private QuoteRepository qr;

    @GetMapping("/pop")
    public @ResponseBody String populate() throws IOException {
        qr.saveAll(Downloader.download(new File("/Users/karimabounassif/BootCamp/stocks/src/main/resources/dataset.json")));
        return "Saved.";
    }
}
