
public class Trasporto extends Evento {
	private Officina officina;

	public Trasporto(Listener mittente, Listener destinatario, Officina officina) {
		super(mittente, destinatario);
		this.officina = officina;
	}

	public Officina getOfficina() {
		return officina;
	}
	
}
