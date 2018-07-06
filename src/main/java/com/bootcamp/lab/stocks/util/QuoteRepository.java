package com.bootcamp.lab.stocks.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("select new com.bootcamp.lab.stocks.util.QuoteAgg(MAX(q.price), MIN(q.price), SUM(q.volume)) from Quote q where q.symbol = :symbol and date(q.date) = :date")
    public QuoteAgg aggResults(@Param("symbol") String sym, @Param("date") Date date);

    @Query("select q.price from Quote q where q.symbol = :symbol and q.date = (select max(x.date) " +
            "from Quote x where date(x.date) = :date and x.symbol = :symbol)")
    public Double closing(@Param("symbol") String sym, @Param("date") Date date);
}
