package edu.examples.java_classes.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.entity.Medicines;

public class MockSource {
	private static List<Medicines> medicine = new ArrayList<>();
	
	public static void add(Medicines medicines) {
		medicine.add(medicines);
	}
	
	public static List<Medicines> get(){
		return medicine;
	}
	
	public static int countOfNotes() {
		return medicine.size();
	}
}
