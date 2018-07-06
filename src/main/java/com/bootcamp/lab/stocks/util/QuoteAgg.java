package com.bootcamp.lab.stocks.util;

import javax.persistence.*;

public class QuoteAgg {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String date;
    private String symbol;
    private Double high;
    private Double low;
    private Long volume;
    private Double closing;


    public QuoteAgg(double high, double low, long volume){
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    public void setSymbol(String s) { this.symbol = s; }
    public String getSymbol(){ return this.symbol; }

    public void setDate(String d) { this.date = d; }
    public String getDate(){ return this.date; }

    public void setHigh(double h){ this.high = h; }
    public double getHigh(){ return this.high; }

    public void setLow(double l){ this.low = l; }
    public double getLow(){ return this.low; }

    public void setVolume(long v){ this.volume = v; }
    public long getVolume(){ return this.volume; }

    public void setClosing(double c){ this.closing = c; }
    public double getClosing(){ return this.closing; }


    public String displayAgg(){
        return "Aggregate data for " + getSymbol() + " on " + getDate() + ":\nHigh: " + getHigh() + "\nLow: " + getLow()
                + "\nClosing Price: " + getClosing() + "\nTotal Volume: " + getVolume();
    }

    public String displayMonthly(){
        return "High: " + getHigh() + "\nLow: " + getLow()
                +  "\nTotal Volume: " + getVolume();
    }
}
