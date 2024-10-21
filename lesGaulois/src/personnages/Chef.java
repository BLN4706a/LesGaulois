package personnages;

public class Chef {
	private String nom;
	private int force;
	private Village village;
	public Chef(String nom, int force, Village village) {
		super();
		this.nom = nom;
		this.force = force;
		this.village = village;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreparole() + "<<" + texte +">>");	
	}
	private String prendreparole() {
		return "Le chef " + nom + " du village " + village.getNom()+ " : ";
	}
	public void frapper(Romain romain) {
		System.out.println(nom + "envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force/3);
	}
}
