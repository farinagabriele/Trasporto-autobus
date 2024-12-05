/**
 * 
 * @author skype
 * {@summary La classe in questione serve per avere un unico punto di accesso per modificare l'associazione <br> autorimessa <-> autobus}
 */
public class ManagerPosizione {
	private ManagerPosizione() {}
	
	public static void addPosizione( Autobus a, Autorimessa r) {
		ManagerPosizione gettone = new ManagerPosizione();
		a.setAutorimessa(r, gettone);
		r.addAutobus(a, gettone);
	}
	
	public static void rmPosizione(Autobus a, Autorimessa r) {
		
		ManagerPosizione gettone = new ManagerPosizione();
		a.eraseAutorimessa(gettone);
		r.removeAutobus(a, gettone);
	}
	
}
