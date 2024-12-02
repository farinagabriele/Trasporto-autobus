import java.util.LinkedList;

public class Rotture implements Task{
	private LinkedList<Autobus> autobus;
	private LinkedList<Officina> officina;
	
	public Rotture(LinkedList<Autobus> autobus, LinkedList<Officina> officina) {
		super();
		this.autobus = autobus;
		this.officina = officina;
	}

	@Override
	public void esegui() {
		System.out.println(autobus);
		System.out.println(officina);
		// Accesso alle classi dati
	}
}
