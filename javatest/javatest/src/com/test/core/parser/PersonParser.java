package com.test.core.parser;

import com.test.domain.Person;

import java.io.File;

public interface PersonParser {

    Person parsePerson(File file);

}
