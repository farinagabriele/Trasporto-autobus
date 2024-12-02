import javax.management.RuntimeErrorException;

public class Autobus {
	// Dati
	private String targa;
	private String modello;
	private int manutenzione;
	private int timestamp;
	//private Autorimessa autorimessa;
	private LinkPosizione posizione;
	
	

	public Autobus(String targa, String modello, int manutenzione, Autorimessa autorimessa) {
		super();
		this.targa = targa;
		this.modello = modello;
		this.manutenzione = manutenzione;
		this.timestamp = 0;
		this.posizione = new LinkPosizione(this, autorimessa, 0);
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getManutenzione() {
		return manutenzione;
	}

	public void setManutenzione(int manutenzione) {
		this.manutenzione = manutenzione;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public Autorimessa getAutorimessa() {
		return this.posizione.getRimessa();
	}

	public void setAutorimessa(Autorimessa autorimessa, ManagerPosizione gettone) {
		
		if (gettone == null)
			throw new RuntimeErrorException(null, "Tentativa di aggiunta senza gettone");
		this.posizione = new LinkPosizione(this, autorimessa, 0);
	}
	
	
	public void eraseAutorimessa(ManagerPosizione gettone) {
		if (gettone == null)
			throw new RuntimeErrorException(null, "Tentativa di aggiunta senza gettone");
		this.posizione = new LinkPosizione(this, null, 0);
	}

	@Override
	public String toString() {
		return "Autobus [targa=" + targa + ", modello=" + modello + ", manutenzione=" + manutenzione + ", autorimessa="
				+ posizione.getRimessa() + "]";
	}
	
	/* ################################################################
	 * Comportamento
	 * ################################################################
	 */
	static enum Stato {INAUTORIMESSA, INSERVIZIO, ROTTURA, INMANUTENZIONE};
	
	private Stato stato = Stato.INAUTORIMESSA;

	public Stato getStato() {
		return stato;
	}
	
	// Implementazione iniziale
	private Autista at;
	
	public void uscitaAutorimessa(Autista mittente, ManagerPosizione gettone) {
		if (this.stato == Stato.INAUTORIMESSA) {
			if (mittente.getAutorizzato().contains(this.posizione.getRimessa())) {
				this.at = mittente;
				ManagerPosizione.rmPosizione(this, this.posizione.getRimessa());
				this.stato = Stato.INSERVIZIO;
			}
		}
	}
	
	public void entrataAutorimessa(Autista mittente) {
		if (this.stato == Stato.INSERVIZIO) {
			if ( this.at == mittente) {
				this.stato = Stato.INAUTORIMESSA;
				this.at.entrata(this);
				this.posizione.getRimessa().entrata(this);
			}
		}
	}	
	
	public void rottura() {
		if (this.stato == Stato.INSERVIZIO) {
			this.at.setRotture(this.at.getRotture() + 1);
			this.stato = Stato.ROTTURA;
		}
	}
	
	public void trasportoInAutorimessa(Officina rimessa) {
		if (this.stato == Stato.ROTTURA) {
			ManagerPosizione.addPosizione(this, rimessa);
			this.stato = Stato.INMANUTENZIONE;
		}
	}
	
	public void fineManutenzione() {
		if (this.stato == Stato.INMANUTENZIONE) {
			this.stato = Stato.INAUTORIMESSA;
			this.timestamp += 800000;
		}
	}
	
	public void periodica() {
		if (this.stato == Stato.INAUTORIMESSA) {
			if (this.posizione.getRimessa() != null && this.posizione.getRimessa().getClass() == Officina.class) {
				this.stato = Stato.INMANUTENZIONE;
			}
		}
	}
	
	
}