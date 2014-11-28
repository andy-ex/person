package com.test.core.util;

import java.util.List;

import com.test.core.exception.DataProcessorException;
import com.test.domain.Person;
import com.test.domain.enumeration.Gender;

/**
 * 
 * Class for processing information about persons' list
 * 
 */
public class PersonDataProcessor {

	private static final int SECOND = 1000;
	private static final int MINUTE = 60 * SECOND;
	private static final int HOUR = 60 * MINUTE;
	private static final int DAY = 24 * HOUR;

	/**
	 * Count how much males are in list of persons
	 * 
	 * @param persons
	 *            list of persons
	 * @return
	 * @throws DataProcessorException
	 */
	public static int countMale(final List<Person> persons)
			throws DataProcessorException {
		if (persons == null || persons.size() == 0) {
			throw new DataProcessorException("ERROR: No persons was specified");
		}
		int numberOfMalePersons = 0;
		for (Person person : persons) {
			if (Gender.MALE == person.getGender()) {
				numberOfMalePersons++;
			}
		}
		return numberOfMalePersons;
	}

	/**
	 * Count average age of persons
	 * 
	 * @param persons
	 *            list of persons
	 * @return
	 * @throws DataProcessorException
	 */
	public static double countAverageAge(final List<Person> persons)
			throws DataProcessorException {
		if (persons == null || persons.size() == 0) {
			throw new DataProcessorException("ERROR: No persons was specified");
		}
		int summedAge = 0;
		for (Person person : persons) {
			summedAge += person.getAge();
		}
		try {
			int result = summedAge / persons.size();
			return result;
		} catch (ArithmeticException e) {
			throw new DataProcessorException(e);
		}
	}

	/**
	 * Define how many days one person older than second
	 * 
	 * @param person1
	 * @param person2
	 * @return
	 * @throws DataProcessorException
	 */
	public static double countDaysOlder(final Person person1,
			final Person person2) throws DataProcessorException {
		double person1TotalDays;
		double person2TotalDays;
		try {
			person1TotalDays = person1.getDateOfBirth().getTime() / DAY;
			person2TotalDays = person2.getDateOfBirth().getTime() / DAY;
		} catch (NullPointerException e) {
			throw new DataProcessorException(
					"Can't calculate the difference, beacuse parameters are not correct",
					e);
		}
		return person2TotalDays - person1TotalDays;
	}

	/**
	 * return person from list by name
	 * 
	 * @param name
	 * @return
	 * @throws DataProcessorException
	 */
	public static Person findPersonByName(final List<Person> persons,
			final String name) throws DataProcessorException {
		if (persons == null || persons.size() == 0) {
			throw new DataProcessorException("ERROR: No persons was specified");
		}
		if (name == null) {
			throw new DataProcessorException("ERROR: No name was specified");
		}
		for (Person person : persons) {
			if (name.equals(person.getFullName())) {
				return person;
			}
		}
		throw new DataProcessorException(
				"ERROR: No person with such name was found");

	}
}
