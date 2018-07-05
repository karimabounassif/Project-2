package com.bootcamp.lab.stocks.util;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

}
