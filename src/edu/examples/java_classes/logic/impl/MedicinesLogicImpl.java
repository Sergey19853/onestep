package edu.examples.java_classes.logic.impl;

import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.MedicinesDao;
import edu.examples.java_classes.entity.Medicines;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.MedicinesLogic;

public class MedicinesLogicImpl implements MedicinesLogic {
	private final DaoProvider provider = DaoProvider.getInstance();
	private final MedicinesDao dao = provider.getMedicinesDao();
	
	public void add(Medicines medicines) throws LogicException{
		try {
			dao.save(medicines);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	public void add(String nameMedicine, String pharmacy, String instructions, Integer amount) throws LogicException{
		Medicines medicines = new Medicines(nameMedicine, pharmacy, instructions, amount);
		try {
			dao.save(medicines);
		} catch (DaoException e) {
			throw new LogicException(e);
		}	
	}

	@Override
	public void clear() throws LogicException {
		try {
			dao.clearMedicines();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void updateEntry(Medicines medicines) throws LogicException {
		try {
			dao.update(medicines);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void deleteEntry(int id) throws LogicException{
		try {
			dao.deleteEntry(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	public List<Medicines> find(String text) throws LogicException{
		
		List<Medicines> result = new ArrayList<Medicines>();
		
		List<Medicines> myMedicines;
		try {
			myMedicines = dao.allMedicines();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
		for(Medicines n : myMedicines) {
			if(isTextInNote(n, text)) {
				result.add(n);
			}
		}
		
		return result;

	}
	
	private boolean isTextInNote(Medicines medicines, String text) throws LogicException{
		return medicines.getNameMedicine().contains(text) || medicines.getPharmacy().contains(text);
	}
	
	@Override
	public List<Medicines> allMedicines() throws LogicException{
		try {
			return dao.allMedicines();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

}
