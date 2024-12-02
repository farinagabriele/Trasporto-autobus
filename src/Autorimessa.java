import java.util.HashSet;

import javax.management.RuntimeErrorException;

public class Autorimessa {
	private String indirizzo;
	private int posti;
	//HashSet<Autobus> autobus;
	HashSet<LinkPosizione> posizioni;
	
	public Autorimessa(String indirizzo, int posti) {
		super();
		this.indirizzo = indirizzo;
		this.posti = posti;
		this.posizioni = new HashSet<LinkPosizione>();
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	public int getPosti() {
		return posti;
	}
	
	public HashSet<LinkPosizione> getAutobus() {
		return  this.posizioni;
	}

	public void addAutobus(Autobus a, ManagerPosizione gettone){
		if (gettone == null)
			throw new RuntimeErrorException(null, "Tentativa di aggiunta senza gettone");
		this.posizioni.add(new LinkPosizione(a, this, 0));
	}
	
	
	
	public void removeAutobus(Autobus a, ManagerPosizione gettone){
		this.posizioni.remove(new LinkPosizione(a, this, 0));
	}

	@Override
	public String toString() {
		return "Autorimessa [indirizzo=" + indirizzo + ", posti=" + posti + ", autobus=" + posizioni + "]";
	}
	
	// comportamento
	public void entrata(Autobus autobus) {
		
	}
}