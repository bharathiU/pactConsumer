package com.bookshop.service;

import com.bookshop.consumer.service.connector.ProviderConnector;
import com.bookshop.model.entities.Book;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ConsumerService {
@Autowired
     ProviderConnector providerConnector;

    public   Optional<Book> getBook(Long id)   {
    	Optional<Book> bookHolder = Optional.empty();
		try {
			bookHolder = Optional.ofNullable(providerConnector
					.serializeData(providerConnector.getData(String.format("/book/%d", id)).getBody(), Book.class));
		} catch (Exception e) {
			e.printStackTrace();
			return bookHolder;
		}
		return bookHolder;
	}
}

