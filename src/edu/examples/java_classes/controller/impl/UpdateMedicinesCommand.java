package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Medicines;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.MedicinesLogic;

public class UpdateMedicinesCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final MedicinesLogic logic = logicProvider.getMedicinesLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Medicines newMedicines;

		params = request.split("\n");
		newMedicines = new Medicines();

		newMedicines.setNameMedicine(params[1].split("=")[1]);
		newMedicines.setPharmacy(params[2].split("=")[1]);
		newMedicines.setInstructions(params[3].split("=")[1]);
		newMedicines.setAmount(Integer.parseInt(params[4].split("=")[1]));
		
		try {
			logic.add(newMedicines);
			response = "Запись обновлена успешно.";
		} catch(LogicException e) {
			response = "Ошибка обновления записи.";
		}
		
		return response;
	}

}
