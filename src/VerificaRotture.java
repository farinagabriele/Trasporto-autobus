import java.util.LinkedList;

public class VerificaRotture implements Runnable {
	private LinkedList<Autobus> autobus;
	private LinkedList<Officina> officina;
	private int t;
	
	
	public VerificaRotture(LinkedList<Autobus> autobus, LinkedList<Officina> officina, int t) {
		super();
		this.autobus = autobus;
		this.officina = officina;
		this.t = t;
	}

	
	
	@Override
	public void run() {
		while(!Manutenzione.termina) {
			Rotture r = new Rotture(autobus, officina);
			TaskExecutor.getIstance().perform(r);
			
			try {
				Thread.sleep(t*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}