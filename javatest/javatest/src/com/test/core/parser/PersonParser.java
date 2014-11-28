package com.test.core.parser;

import com.test.core.exception.ParserException;
import com.test.domain.Person;

import java.io.File;
import java.util.List;

/**
 * Base interface for person parser
 */
public interface PersonParser {

    /**
     * Parses input file and builds list of people
     * @param file input file to parse
     * @return built people list
     * @throws ParserException throws if incorrect data found in input file
     */
    List<Person> parsePerson(File file) throws ParserException;

}
