package edu.examples.java_classes.logic;

import java.util.List;

import edu.examples.java_classes.entity.Medicines;

public interface MedicinesLogic {

	public void add(Medicines medicines) throws LogicException;

	public void add(String nameMedicine, String pharmacy, String instructions, Integer amount) throws LogicException;

	public void clear() throws LogicException;

	public void updateEntry(Medicines medicines) throws LogicException;

	public void deleteEntry(int id) throws LogicException;
	
	public List<Medicines> find(String text) throws LogicException;

	public List<Medicines> allMedicines() throws LogicException;
}
