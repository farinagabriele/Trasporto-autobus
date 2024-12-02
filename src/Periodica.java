import java.util.LinkedList;

public class Periodica implements Task{
	
	private LinkedList <Autobus> autobus;
	private boolean eseguito;
	private int risultato;
	
	
	public Periodica(LinkedList<Autobus> autobus) {
		super();
		this.autobus = autobus;
		this.eseguito = false;
	}

	

	public synchronized int getRisultato() {
		if (!this.eseguito)
			throw new RuntimeException("Oggetto periodica non terminato");
		return risultato;
	}



	



	@Override
	public synchronized void esegui() {
		// TODO Auto-generated method stub
		if (this.eseguito)
			return;
		System.out.println(autobus);	
		this.risultato = 42;
		eseguito = true;
		// Accesso alle classi dati
	}
	
	
	
	
}
