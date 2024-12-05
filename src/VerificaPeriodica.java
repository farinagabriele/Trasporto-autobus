import java.util.LinkedList;

public class VerificaPeriodica implements Runnable {
	
	private LinkedList <Autobus> autobus;
	private int t;
	
	
	public VerificaPeriodica(LinkedList <Autobus> autobus,int t) {
		this.autobus = autobus;
		this.t = t;
	}
	
	@Override
	public void run() {
		while(!Manutenzione.termina) {
			Periodica p = new Periodica(autobus);
			TaskExecutor.getIstance().perform(p);
			
			try {
				Thread.sleep(t*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}