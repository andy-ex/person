package com.test.core.util;

import java.util.List;

import com.test.domain.Person;
import com.test.domain.enumeration.Gender;

/**
 * 
 * Class for processing information about persons' list
 * 
 */
public class PersonDataProcessor {

	/**
	 * Count how much males are in list of persons
	 * 
	 * @param persons
	 *            list of persons
	 * @return
	 */
	public static int countMale(final List<Person> persons) {
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
	 */
	public static double countAverageAge(final List<Person> persons) {
		int summedAge = 0;
		for (Person person : persons) {
			summedAge = person.getAge();
		}
		int result;
		if (summedAge > 0) {
			result = summedAge / persons.size();
		} else {
			result = 0;
		}
		return result;
	}

	/**
	 * Define how many days one person older than second
	 * 
	 * @param person1
	 * @param person2
	 * @return
	 */
	public static int countDaysOlder(final Person person1, final Person person2) {
		return 0;
	}

}
