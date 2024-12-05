/**
 * 
 * @author skype
 *	Link associazione tra autobus ed autorimessa
 *  ATTENZIONE!! Anche in caso di associazioni con molteplicità 
 *  0.* a 0.* (molti a molti) il link collega sempre 2 oggetti singoli:
 *  un autobus <-> un autorimessa 
 */
public class LinkPosizione {
	private Autobus autobus;
	private Autorimessa rimessa;
	private int tempo;
	
	public LinkPosizione(Autobus autobus, Autorimessa rimessa, int tempo) {
		super();
		this.autobus = autobus;
		this.rimessa = rimessa;
		this.tempo = tempo;
	}
	
	/*
	 * Dato che per ogni variazione della coppia 
	 * (autobus, rimessa) viene creato un nuovo 
	 * oggetto LinkPosizione, non servono i metodi setter.
	 */
	
	public Autobus getAutobus() {
		return autobus;
	}
	
	public Autorimessa getRimessa() {
		return rimessa;
	}
	
	public int getTempo() {
		return tempo;
	}


	@Override
	public String toString() {
		return "LinkPosizione [autobus=" + autobus + ", rimessa=" + rimessa + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		/* Due link sono uguali se e solo se sono non nulli e
		 * sono della stessa classe e fanno riferimento allo stesso
		 * autobus ed alla stessa autorimessa
		 */
		
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		
		LinkPosizione l = (LinkPosizione) obj; 	// Specializzazione (downgrade)
		if (l.autobus != this.autobus)
			return false;
		if (l.rimessa != this.rimessa)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		/* Il link è identificato dalla coppia (autobus, rimessa).
		 * L'HashSet identifica i suoi elementi tramice hashCode.
		 */
		return this.autobus.hashCode() + this.rimessa.hashCode();
	}
}
