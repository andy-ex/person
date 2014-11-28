package com.test.core.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.test.domain.Person;
import com.test.domain.enumeration.Gender;

public class PersonDataProcessorTest {

	private PersonDataProcessor dataProcessor;

	private List<Person> persons;
	Person person1;
	Person person2;

	@Before
	public void setUp() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = sdf.parse("16/03/1977");
		Date d2 = sdf.parse("15/04/1977");
		persons = new ArrayList<Person>();
		person1 = createPerson(30, "name1", Gender.MALE, d1);
		person2 = createPerson(20, "name2", Gender.FEMALE, d2);
		persons.add(person1);
		persons.add(person2);

	}

	@Test
	public void countMaleWithCorrectData() throws Exception {
		int expectedSize = persons.size();
		int actualSize = dataProcessor.countMale(persons);
	}
	
	private Person createPerson(int age, String fullName, Gender gender, Date date){
		Person person = new Person();
		person.setAge(age);
		person.setFullName(fullName);
		person.setGender(gender);
		person.setDateOfBirth(date);
		return person;
	}

}