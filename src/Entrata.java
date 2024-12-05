
public class Entrata extends Evento {
	private Autorimessa rimessa;

	public Entrata(Listener mittente, Listener destinatario, Autorimessa rimessa) {
		super(mittente, destinatario);
		this.rimessa = rimessa;
	}

	public Autorimessa getAutorimessa() {
		return rimessa;
	}
	
}
