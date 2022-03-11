package sn.uasz.m1.tp1.exercice4;

import java.util.HashMap;

public class GestionParking {

	public static void main(String[] args) {
		Voiture v1 = new Voiture(2008, "TOYOTA", 25.0, "diesel", "noire");
		Voiture v2 = new Voiture(2003, "peugeot", 25.0, "essence", "bleu");
		Voiture v3 = new Voiture(20002, "CITOEN", 1909.0, "gaz oil", "blanche");
		Voiture v4 = new Voiture(2008, "Volvo", 2451.0, "diesel", "gris");
		Voiture v5 = new Voiture(2006, "ford", 2509.0, "essence", "gris");
		Voiture v6 = new Voiture(2009, "Volvo", 2715.0, "diesel", "gris");
		

		HashMap<Integer, Voiture> listeVoiture = new HashMap<Integer, Voiture>();

		Parking p1 = new Parking(5, listeVoiture);
		try {
			p1.garer(v1, 1);
			p1.garer(v2, 2);
			p1.garer(v3, 3);
			p1.garer(v4, 4);
			p1.garer(v5, 5);
		  // p1.garer(v6,5 );
			System.out.println(p1.placeOccupee(2002));
			// p1.retirer(2);
			
			//p1.retirer();
			p1.afficher();
		} catch (PlaceInexistanteException | PlaceOccupeeException e) {
			e.printStackTrace();
		}
	}

}
