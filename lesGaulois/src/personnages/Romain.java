package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	private boolean vainqueur = true;

	public String getNom() {
		return nom;
	}

	public Romain(String nom, int force) {
		assert verifierForce(force);
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];

	}

	public void setForce(int force) {
		assert verifierForce(force);
		this.force = force;
	}

	private boolean verifierForce(int force) {
		return force > 0;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");

	}

	private String prendreParole() {
		return "le romain " + nom + ":";

	}
	



	public boolean isVainqueur() {
		return vainqueur;
	}

	//	public void recevoirCoup(int forceCoup) {
//		int forceinitiale;
//		forceinitiale = force;
//		force -= forceCoup;
//		assert verifierForce(force);
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force >= forceinitiale
//				: "La force après coup ne peut pas être supérieure ou egale à la force initiale !";
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			vainqueur = false;
		}
		// post condition la force a diminuée
		if(oldForce == force) {
			parler("la force n a pas deminue");
		}
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		
		if (equipements[i] != null) {
			equipementEjecte[nbEquipementEjecte] = equipements[i];
			nbEquipementEjecte++;
			equipements[i] = null;
		}
		}
		return equipementEjecte;
		}

//................................//
	public void sEquipier(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);

			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
			}

			break;

		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus);

		Romain romain = new Romain("romain", 7);
		System.out.println(romain);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		minus.sEquipier(Equipement.CASQUE);
		minus.sEquipier(Equipement.CASQUE);
		minus.sEquipier(Equipement.BOUCLIER);
		minus.sEquipier(Equipement.BOUCLIER);
	}

	public int getForce() {
		return force;
	}

}
