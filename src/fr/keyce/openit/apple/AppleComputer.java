package fr.keyce.openit.apple;

import fr.keyce.openit.Computer;
import fr.keyce.openit.Keyboard;
import fr.keyce.openit.Mouse;

public class AppleComputer extends Computer {

	@Override
	public String toString() {
		return "Apple :" + super.toString() ;
	}
	
	// Un méthode implémentée est une méthode qui a un corps
	
	// Une méthode abstraite est une méthode qui n'a pas de corps
	
	
	public String instructionGame() {
		return "ARM" ;
	}

}