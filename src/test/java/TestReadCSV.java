package test.java;

import static org.junit.Assert.*;
import main.java.ReadCSV;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestReadCSV {
	
private ReadCSV readCSV;
	
	@Before
	public void setUp() throws Exception {
		readCSV = new ReadCSV();
	}

	@After
	public void tearDown() throws Exception {
		readCSV = null;
	}
	
	@Test
	public void CSVtoArrayList() {
		assertNotNull(readCSV);
		assertNotNull(readCSV.CSVtoArrayList(null));
	}
	@Test
	public void dataset() {
		assertNotNull(readCSV);
		readCSV.dataset();
	}
}
