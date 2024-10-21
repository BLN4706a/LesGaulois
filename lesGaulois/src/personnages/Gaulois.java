package personnages;

	public class Gaulois {
		
		private String nom;
		private int force;
		private int nbTrophees;
		private int effetpotion = 1;
		private Equipement[] trophees = new Equipement[100];

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	@Override
	public String toString() {
		return "gaulois [nom=" + nom + ", force=" + force + ", effetpotion=" + effetpotion + "]";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");

	}

//	public String prendreParole() {
//		return "le gaulois " + nom + ":";
//
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetpotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] newTrophees = romain.recevoirCoup((force / 3) *effetpotion);
		for (int i = 0; newTrophees != null && i < newTrophees.length; i++,nbTrophees++) {
		this.trophees[nbTrophees] = newTrophees[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetpotion = forcePotion;
		parler("Merci Druide, je sens que ma force est" + effetpotion + " fois décuplée.");
	}
	public void faireUneDonation(Musee musee) {
		if(nbTrophees > 0) {
			System.out.println("je donne tous mes trophees au musee");
			for(int i = 0;i <nbTrophees;i++) {
				musee.donnerTrophees(this,trophees[i] );
				trophees[i]= null ;
			}
		}else {
			System.out.println("je n ai aucun trophee a donner");
		}
	}

	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("asterix", 8);
//		System.out.println(asterix);
//		asterix.parler("bonjour je suis asterix");
//		Romain romain = new Romain("romain", 6);
//		asterix.frapper(romain);
//		asterix.boirePotion(6);
		Gaulois asterix = new Gaulois("Astérix", 8);
        Musee musee = new Musee();
        
        // Simuler l'ajout de trophées
        Equipement casque = Equipement.CASQUE;
        Equipement bouclier = Equipement.BOUCLIER;
        
        asterix.trophees[0] = casque;
        asterix.trophees[1] = bouclier;
        asterix.nbTrophees = 2;

        // Faire la donation des trophées
        asterix.faireUneDonation(musee);
        System.out.println(musee.extraireInstructionOCaml());
		
	}
}