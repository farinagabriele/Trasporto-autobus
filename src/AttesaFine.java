import java.util.Scanner;

public class AttesaFine implements Runnable {
	
	Thread vt;
	Thread vr;
	
	public AttesaFine(Thread vt, Thread vr) {
		super();
		this.vt = vt;
		this.vr = vr;
	}



	
	
	
	
	@Override
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		sc.close();
			
		this.vt.interrupt();
		this.vr.interrupt();
		Manutenzione.termina = true;

	}

	

}