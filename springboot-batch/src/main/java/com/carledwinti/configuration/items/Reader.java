package com.carledwinti.configuration.items;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

	private String[] messages = { "carledwinj.wordpress.com", "Welcome to Spring Batch",
			"We use H2 Database for this" };
	private int count = 0;

	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (count < messages.length) {
			return messages[count++];
		} else {
			count = 0;
		}

		return null;
	}

}
