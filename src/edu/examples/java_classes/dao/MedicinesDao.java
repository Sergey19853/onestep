package edu.examples.java_classes.dao;

import java.util.List;
import edu.examples.java_classes.entity.Medicines;

public interface MedicinesDao {
	void save(Medicines n) throws DaoException;

	void update(Medicines n) throws DaoException;

	List<Medicines> allMedicines() throws DaoException;

	void clearMedicines() throws DaoException;

	void deleteEntry(int id) throws DaoException;
}
