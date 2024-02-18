package edu.examples.java_classes.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.MedicinesDao;
import edu.examples.java_classes.entity.Medicines;
import edu.examples.java_classes.util.MedicinesMapper;
import edu.examples.java_classes.util.ReaderWriterFilesUtil;

public class FileMedicinesDao implements MedicinesDao{

	private List<Medicines> medicinesList;

	@Override
	public void save(Medicines medicines) throws DaoException {

		medicinesList.add(medicines);

		try {
			ReaderWriterFilesUtil.export(MedicinesMapper.medicinesToString(medicinesList, ";"));
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(Medicines medicines) throws DaoException {

//		medicinesList.set(Medicines.getId(),Medicines);

//		try {
//			ReaderWriterFilesUtil.export(MedicinesMapper.medicinesToString(medicinesList, ";"));
//		} catch (IOException e) {
//			throw new DaoException(e);
//		}
	}

	@Override
	public List<Medicines> allMedicines() throws DaoException{
		List<Medicines> medicines = new ArrayList<>();
		List<String> strNotes = null;
		try {
			strNotes = ReaderWriterFilesUtil.importMedicines();
		} catch (IOException e) {
			throw new DaoException(e);
		}
		medicines = strNotes.stream().map(MedicinesMapper::toNote).collect(Collectors.toList());
		medicinesList =  medicines;
		return medicinesList;
	}

	public void clearMedicines() throws DaoException{
		medicinesList.clear();
		try {
			ReaderWriterFilesUtil.export(MedicinesMapper.medicinesToString(medicinesList, ";"));
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	public void deleteEntry(int id) throws DaoException{
//		int count = 0;

//		for(Medicines medicines : medicinesList) {
//			if(medicines.getId() == id) {
//				medicinesList.remove(count);
//				break;
//			}
//			count++;
//		}

//		try {
//			ReaderWriterFilesUtil.export(MedicinesMapper.medicinesToString(medicinesList, ";"));
//		} catch (IOException e) {
//			throw new DaoException(e);
//		}
	}

}
