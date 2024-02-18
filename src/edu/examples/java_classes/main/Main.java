package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		String request;
		String response;
		
		request = "ALLMEDICINES\n";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "ADD\nnameMedicine=Аспирин\npharmacy=Центральная аптека\ninstructions=от головы\namount=2";
		response = controller.doAction(request);
		System.out.println(response);

		request = "ALLMEDICINES\n";
		response = controller.doAction(request);
		System.out.println(response);

	}

}
