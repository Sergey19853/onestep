package edu.examples.java_classes.util;

import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.entity.Medicines;

public class MedicinesMapper {
	
	public static Medicines toNote(String data) {
		Medicines medicine = new Medicines();

		String[] arrayMedicines = data.split(";");
		medicine.setNameMedicine(arrayMedicines[0]);
		medicine.setPharmacy(arrayMedicines[1]);
		medicine.setInstructions(arrayMedicines[2]);
		medicine.setAmount(Integer.parseInt(arrayMedicines[3]));
		
		return medicine;
	}

	public static List<String> medicinesToString(List<Medicines> data, String delimiter) {
		List<String> strNotes = new ArrayList<>();

		for (Medicines medicine: data){
			String strNote = medicine.getNameMedicine() + delimiter + medicine.getPharmacy() + delimiter
					+ medicine.getInstructions() + delimiter + medicine.getAmount() + delimiter + "\n";
			strNotes.add(strNote);
		}
		return strNotes;
	}
}
