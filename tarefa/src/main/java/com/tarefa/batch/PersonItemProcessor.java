package com.tarefa.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.tarefa.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

	@Override
	public Person process(final Person person) throws Exception {
		
		final String name = person.getName().toUpperCase();
		final String surname = person.getSurname().toUpperCase();
		
		final Person personTransformed = new Person(name, surname);
		
		log.info("Convert(" + person + ") into (" + personTransformed +")");
		
		return personTransformed;
	}

}
