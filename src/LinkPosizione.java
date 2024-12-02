/**
 * 
 * @author skype
 *	Link associazione tra autobus ed autorimessa
 *  ATTENZIONE!! Anche in caso di associazioni con molteplicità 
 *  molti a molti il link collega sempre 2 oggetti singoli:
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
	
	
	public Autobus getAutobus() {
		return autobus;
	}
	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
	}
	
	public Autorimessa getRimessa() {
		return rimessa;
	}
	
	public void setRimessa(Autorimessa rimessa) {
		this.rimessa = rimessa;
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
		// TODO Auto-generated method stub
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		LinkPosizione l = (LinkPosizione) obj;
		if (l.autobus != this.autobus)
			return false;
		if (l.rimessa != this.rimessa)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.autobus.hashCode() + this.rimessa.hashCode();
	}
}
