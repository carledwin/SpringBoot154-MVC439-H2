package com.carledwinti.springbatchcsv.configuration;

import org.springframework.batch.item.ItemProcessor;

import com.carledwinti.springbatchcsv.model.User;

public class UserItemProcessor implements ItemProcessor<User, User>{

	public User process(User user) throws Exception {
		return user;
	};
}
