import javax.management.RuntimeErrorException;

public class Autobus implements Listener{
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
	
	/*
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
				return false;
		Autobus a = (Autobus) obj;
		if (a.getTarga() != this.targa)
			return false;
		return true;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.targa.hashCode();
	}
	*/
	
	/* ################################################################
	 * Comportamento
	 * ################################################################
	 */
	static enum Stato {INAUTORIMESSA, INSERVIZIO, ROTTURA, INMANUTENZIONE};
	
	public Stato stato = Stato.INAUTORIMESSA;

	public Autista at;
		
	@Override
	public void fired(Evento e) {
		TaskExecutor.getIstance().perform(new AutobusFired(this, e));
	}
	
	
	
}