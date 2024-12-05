
public abstract class Evento {
	
	private Listener mittente;
	private Listener destinatario;
	
	public Evento(Listener mittente, Listener destinatario) {
		super();
		this.mittente = mittente;
		this.destinatario = destinatario;
	}
	
	public Listener getMittente() {
		return mittente;
	}
	public Listener getDestinatario() {
		return destinatario;
	}
	
}
