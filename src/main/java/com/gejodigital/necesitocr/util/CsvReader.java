package com.gejodigital.necesitocr.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader {
	private static final String SEPARATOR = ",";
	 
    private final Reader source;
 
//    private CSVReader csvReader;
    
    public CsvReader(Reader source) {
        this.source = source;
    }
    public List<String> readHeader() {
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
                    .findFirst()
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
                    .get();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    
    public List<List<String>> readRecords() {
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
            		.skip(0)
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))                    
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    } 
    
//    public void createReader(String input) throws Exception{		
//		try {							
//			csvReader = new CSVReader(new StringReader(input), this.seprator);
//		} catch (Exception e) {			
//			e.printStackTrace();
//			throw new Exception("Error occured while executing file. "
//					+ e.getMessage());			
//		}		
//	}
//	
//	public void closeReader(){
//		try {
//			csvReader.close();
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}
//	}
    
}
