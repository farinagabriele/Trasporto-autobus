import java.util.*;

public class Manutenzione implements Runnable{
	
	private LinkedList<Autobus> autobus;
	private LinkedList<Officina> officina;
	public static boolean termina;
	
	
	public Manutenzione(LinkedList<Autobus> autobus, LinkedList<Officina> officina) {
		super();
		this.autobus = autobus;
		this.officina = officina;
	}



	@Override
	public void run() {
		
		Scanner in = new Scanner(System.in);
		//t1 t2
		int t1 = 2;
		int t2 = 4;
		// Input dei tempi
		System.out.println("Inserisci i valori temporali t1 e t2:");
		t1 = in.nextInt();
		t2 = in.nextInt();
		in.close();
		Manutenzione.termina = false;
		
		// tre flussi
		VerificaPeriodica v = new VerificaPeriodica(autobus, t1);
		Thread vt = new Thread(v);
		vt.start();
				
		VerificaRotture r = new VerificaRotture(autobus, officina, t2);
		Thread vr = new Thread(r);
		vr.start();
				
		AttesaFine f = new AttesaFine(vr, vt);
		Thread af = new Thread(f);
		af.start();
		
		/*
		 * Non ha importanza l'ordine delle join:
		 * ogni thread viaggia per conto suo
		 */
				
		//attesa terminazione
		try {
			af.join();	// Attendo che af termini
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			vt.join();
			vr.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
	}

}
