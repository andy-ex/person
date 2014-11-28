package com.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.test.core.exception.DataProcessorException;
import com.test.core.exception.ParserException;
import com.test.core.parser.PersonParser;
import com.test.core.parser.impl.DefaultPersonParser;
import com.test.core.util.PersonDataProcessor;
import com.test.domain.Person;

public class ManipulateDataApplication {

	public static void main(String[] args) throws IOException {
		File file = new File("manipulate-data.txt");
		System.out.println(file.getName() + " file exists = " + file.exists());

		PersonParser parser = new DefaultPersonParser();
		try {
			List<Person> persons = parser.parsePerson(file);
			int numberOfMalePersons = PersonDataProcessor.countMale(persons);
			System.out.println("");
		} catch (ParserException | DataProcessorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}