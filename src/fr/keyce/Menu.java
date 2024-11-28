package fr.keyce;

import java.util.Scanner;

import fr.keyce.openit.MaterielInterface;

import fr.keyce.openit.Computer;

import fr.keyce.openit.DefaultComputer ;

public class Menu {

	//private Computer[] computers = new Computer[0];
	private MaterielInterface[] computers = new MaterielInterface[0];

	public void displayMenu() {
		String str;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("********** MON MENU **********");
				System.out.println("1 - Pour ajouter un ordinateur");
				System.out.println("2 - Pour supprimer un ordinateur");
				System.out.println("3 - Pour modifier un ordinateur");
				System.out.println("4 - Pour afficher les ordinateurs");
				System.out.println("0 - Pour quitter l'application");
				System.out.println("Veuillez saisir votre choix : ");
				str = sc.nextLine();
				switch (str.trim()) {
				case "1":
					displayMenuAddComputer(sc);
					break;
				case "2":
					displayMenuRemoveComputer(sc);
					break;
				case "3":
					displayMenuModifyComputer(sc);
					break;
				case "4":
					displayComputers();
					break;
				default:
					System.out.println("Option non disponible");
					break;
				}

				System.out.println("Appuyez sur entrer pour continuer...");
				sc.nextLine();
			} while (!"0".equals(str));
		}
	}

	private void displayComputers() {
		for (int i = 0; i < computers.length; i++) {
			System.out.println(i + " - " + computers[i]);
		}
	}

	private void displayMenuAddComputer(Scanner sc) {
		System.out.println("Entrez le nom de l'ordinateur : ");
		String name = sc.nextLine();
		System.out.println("Entrez le numéro de série de l'ordinateur : ");
		String serialNumber = sc.nextLine();
		MaterielInterface computer = addComputer();
		computer.setName(name);
		computer.setSerialNumber(serialNumber);
		System.out.println("Votre Ordinateur a été ajouté");
	}

	private void displayMenuRemoveComputer(Scanner sc) {
		if(computers.length==0) {
			System.out.println("Il n'y a pas d'ordinateur a supprimer");
			return;
		}
		displayComputers();
		System.out.println("Quel ordinateur souhaitez vous supprimer?");
		String computerId = sc.nextLine();
		removeComputer(Integer.valueOf(computerId));
		System.out.println("Ordinateur supprimé avec succés !!!");
	}

	private void displayMenuModifyComputer(Scanner sc) {
		if(computers.length==0) {
			System.out.println("Il n'y a pas d'ordinateur a modifier");
			return;
		}
		displayComputers();
		System.out.println("Quel ordinateur souhaitez vous modifier?");
		String computerId = sc.nextLine();
		System.out.println("Entrez le nom de l'ordinateur : ");
		String name = sc.nextLine();
		System.out.println("Entrez le numéro de série de l'ordinateur : ");
		String serialNumber = sc.nextLine();
		MaterielInterface computer = computers[Integer.valueOf(computerId)];
		computer.setName(name);
		computer.setSerialNumber(serialNumber);

	}

	private MaterielInterface addComputer() {
		MaterielInterface[] newTab = new MaterielInterface[computers.length + 1];
		for (int i = 0; i < computers.length; i++) {
			newTab[i] = computers[i];
		}
		computers = newTab;
		computers[computers.length - 1] = new DefaultComputer();
		return computers[computers.length - 1];
	}

	private void removeComputer(int position) {
		MaterielInterface[] newTab = new MaterielInterface[computers.length - 1];
		for (int i = 0; i < computers.length; i++) {
			if (i != position) {
				if (i > position) {
					newTab[i - 1] = computers[i];
				} else {
					newTab[i] = computers[i];
				}
			}
		}
		computers = newTab;
	}

}