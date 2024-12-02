/**
 * 
 * @author skype
 * 		Classe factory:
 * Le classi con costruttore privato ed un metodo statico per creare
 * l'oggetto
 * 
 * La classe in questione serve per avere un unico punto di accesso
 * per modificare l'associazione autorimessa <-> autobus
 */
public class ManagerPosizione {
	private ManagerPosizione() {
		
	}
	
	public static void addPosizione( Autobus a, Autorimessa r) {
		ManagerPosizione gettone = new ManagerPosizione();
		a.setAutorimessa(r, gettone);
		r.addAutobus(a, gettone);
	}
	
	public static void rmPosizione(Autobus a, Autorimessa r) {
		
		ManagerPosizione gettone = new ManagerPosizione();
		a.setAutorimessa(null, gettone);
		r.removeAutobus(a, gettone);
	}
	
}
