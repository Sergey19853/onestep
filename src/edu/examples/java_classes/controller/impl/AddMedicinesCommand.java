package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Medicines;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.MedicinesLogic;

public class AddMedicinesCommand implements Command {
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final MedicinesLogic logic = logicProvider.getMedicinesLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Medicines newNote;

		params = request.split("\n");
		newNote = new Medicines();
		newNote.setNameMedicine(params[1].split("=")[1]);
		newNote.setPharmacy(params[2].split("=")[1]);
		newNote.setInstructions(params[3].split("=")[1]);
		newNote.setAmount(Integer.parseInt(params[4].split("=")[1]));
		
		try {
			logic.add(newNote);
			response = "Запись сохранена успешно.";
		} catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		
		return response;
	}

}
