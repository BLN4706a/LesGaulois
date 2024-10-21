package personnages;

public class Musee {
	private int nbTrophee = 0;
	private Trophee[] trophees;
	
	public Musee() {
		this.trophees = new Trophee[200];
	}
	
	public void donnerTrophees( Gaulois gaulois,Equipement equipement ) {
		if(nbTrophee < trophees.length) {
			Trophee nvTrophee = new Trophee(gaulois, equipement);
			trophees[nbTrophee] = nvTrophee;
			nbTrophee++;
			System.out.println(gaulois.getNom() + "a fait don d un  "+ equipement+"au musee");
		}else {
			System.out.println("le musee est plein");
		}
	}
	
	public String extraireInstructionOCaml() {
		String message = new String("let musee = [\n");
		for( int i = 0;i<nbTrophee;i++) {
			Trophee trophee = trophees[i];
			String nomGaulois =trophee.getGaulois().getNom();		
			String nomEquipement = trophee.getEquipement().toString();
			message = message + "\"" + nomGaulois + "\", \"" + nomEquipement + "\";\n";
			
		}
		message += "]";
		return message;
	}

}
