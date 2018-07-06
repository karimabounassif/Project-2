package com.bootcamp.lab.stocks.util;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "price")
    private double price;
    @Column(name = "volume")
    private int volume;
    @Column(name = "Date")
    private Date date;

    public String getSymbol(){
        return this.symbol;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public int getVolume(){ return this.volume; }
    public void setVolume(int volume){
        this.volume = volume;
    }

    public Date getDate(){ return this.date; }
    public void setDate(Date date){ this.date = date; }
}
