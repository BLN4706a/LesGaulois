package personnages;



import java.util.Random;


public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	Random random = new Random();


	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}
	


	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");

	}

	public String prendreParole() {
		return "le druide" + nom + ":";
	}

	public void preparationPotion() {
		
		forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;

		if (forcePotion > 7) {
			parler("j ai prepare une super potion de force" + forcePotion);
		} else {
			parler("e n'ai pas trouvé tous les ingrédients, ma potion est eulement de force " + forcePotion);
		}
	}
	public void booster(Gaulois gaulois) {
		String nomGaulois = gaulois.getNom();
		if(nomGaulois.contentEquals("obelix")) {
			parler("Non, Obélix !... Tu n’auras pas de potion magique ! ");
		}else {
			gaulois.boirePotion(forcePotion);
		}
	}
	public static void main(String[] args) {
		Druide panoramix = new Druide("panoramix",5,10);
		panoramix.preparationPotion();
	}

}



