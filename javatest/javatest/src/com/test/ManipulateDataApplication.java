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
	public static final String FIRST_PERSON_NAME = "Jeff Briton";
	public static final String SECOND_PERSON_NAME = "Tom Soyer";

	public static void main(String[] args) throws IOException {
		File file = new File("manipulate-data.txt");
		System.out.println(file.getName() + " file exists = " + file.exists());

		PersonParser parser = new DefaultPersonParser();
		try {
			List<Person> persons = parser.parsePerson(file);
			int numberOfMalePersons = PersonDataProcessor.countMale(persons);
			System.out.println("Question 1. How many people in the list are male?");
			System.out.println("Answer: " + numberOfMalePersons);
			double averageAge = PersonDataProcessor.countAverageAge(persons);
			System.out.println("Question 2. In years what is the average age of the people in the list?");
			System.out.println("Answer: " + averageAge);
			Person person1 = PersonDataProcessor.findPersonByName(persons,
					FIRST_PERSON_NAME);
			Person person2 = PersonDataProcessor.findPersonByName(persons, SECOND_PERSON_NAME);
			double daysOlder = PersonDataProcessor.countDaysOlder(person1,
					person2);
			System.out
					.println("Question 3. How many days older is Jeff Briton than Tom Soyer?");
			 System.out.println("Answer: " + daysOlder);
		} catch (ParserException | DataProcessorException e) {
			System.out.println("ERROR occured while processing: ");
			e.printStackTrace();
		}

	}
}