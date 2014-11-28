package com.test.core.parser;

import com.test.core.exception.ParserException;
import com.test.domain.Person;

import java.io.File;
import java.util.List;

public interface PersonParser {

    List<Person> parsePerson(File file) throws ParserException;

}
