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

    @Query("SELECT MAX(price), MIN(price), SUM(volume) from Quote q where q.symbol = :symbol and date(q.date) = :date")
    public String aggResults(@Param("symbol") String sym, @Param("date") Date date);

    /*@Query("select * from Quote q where q.symbol = :symbol and q.Date = (select max(Date) " +
            "from Quote x where date(x.Date) = :date and x.symbol = :symbol)")
    public void closing(@Param("symbol") String sym, @Param("date") Date date);*/
}
