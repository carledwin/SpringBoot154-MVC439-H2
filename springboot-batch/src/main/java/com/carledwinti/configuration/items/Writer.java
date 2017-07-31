package com.carledwinti.configuration.items;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String>{

	public void write(List<? extends String> messages) throws Exception {
		for (String message : messages) {
			System.out.println("Writing the data: " + message);
		}
	}

}
