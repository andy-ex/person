package test.core;

import test.domain.Person;

import java.io.File;

public interface PersonParser {

    Person parsePerson(File file);

}
