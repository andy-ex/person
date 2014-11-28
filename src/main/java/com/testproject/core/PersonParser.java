package com.testproject.core;

import java.io.File;

import com.testproject.domain.Person;

public interface PersonParser {

    Person parsePerson(File file);

}
