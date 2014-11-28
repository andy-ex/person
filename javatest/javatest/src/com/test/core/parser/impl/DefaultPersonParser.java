package com.test.core.parser.impl;

import com.test.core.exception.ParserException;
import com.test.core.parser.PersonParser;
import com.test.domain.Person;
import com.test.domain.enumeration.ColumnHeader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultPersonParser implements PersonParser {

    @Override
    public List<Person> parsePerson(File file) throws ParserException{
        List<Person> persons = new ArrayList<Person>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            Map<Integer, ColumnHeader> columnHeaderMap = processHeaderLine(line);
            while ((line = bufferedReader.readLine()) != null) {
                Person person = createPerson(columnHeaderMap, line);
                if (persons.contains(person)) {
                    System.out.println("Duplicate person found! Skipped..");
                }
                persons.add(person);
            }
        } catch (IOException e) {
            System.out.println("Can not parse input input file");
            throw new ParserException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Can not close buffered reader. Reason: " + e.getMessage());
                }
            }
        }
        return null;
    }

    private Map<Integer, ColumnHeader> processHeaderLine(String line) {
        Map<Integer, ColumnHeader> headersMap = new HashMap<Integer, ColumnHeader>();

        String[] headers = line.split(",");
        for (int i = 0; i < headers.length; i++) {
            ColumnHeader columnHeader = ColumnHeader.valueOf(headers[i]);
            headersMap.put(i, columnHeader);
        }

        return headersMap;
    }

    private Person createPerson(Map<Integer, ColumnHeader> headers, String line) {
        Person person = new Person();

        String[] columns = line.split(",");
        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
        }

        return person;
    }
}
