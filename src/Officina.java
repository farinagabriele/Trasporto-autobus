
public class Officina extends Autorimessa{
	private int capannoni;

	public Officina(String indirizzo, int posti, int capannoni) {
		super(indirizzo, posti);
		this.capannoni = capannoni;
	}

	public int getCapannoni() {
		return capannoni;
	}

	public void setCapannoni(int capannoni) {
		this.capannoni = capannoni;
	}

	@Override
	public String toString() {
		return "AutorimessaConManutenzione [capannoni=" + capannoni + ", indirizzo" + getIndirizzo()
				+ ", posti=" + getPosti() + ", autobus=" + getAutobus() + "]";
	}
	
	
	
	
}
