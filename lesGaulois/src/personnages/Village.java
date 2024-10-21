package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom,int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Le village est plein, impossible d'ajouter plus de villageois.");
		}
	}

	public void  setChef(Chef chef) {
		this.chef=chef;
	}

	private Gaulois trouverHabitant(int nbrVillageois) {
		
		return villageois[nbrVillageois];
		
	}
	public void afficheillageois() {
		System.out.println("dans village du chef " + chef.getNom() + " vivent le legendaires gaulois:");
		int i = 0;
		do {
			System.out.println(villageois[i].getNom());
			i++;
		} while (i<nbVillageois);
	}
	public static void main(String[] args) {
		Village village = new Village("Village des irreductibes", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		Chef abraracourcix = new Chef("abrarccourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("asterix", 8);
		village.ajouterHabitant(asterix);
		//Gaulois gaulois = village.trouverHabitant(1); ce qui ce passe :il affiche null parceque y a rien dans la case de l indice 1
		//System.out.println(gaulois);
		village.afficheillageois();
		Gaulois obelix = new Gaulois("obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficheillageois();
		
		

		
	}
}
