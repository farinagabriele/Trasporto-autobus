import java.util.LinkedList;

public class Main {
	


	public static void main(String[] args) throws InterruptedException {
		Autobus a34 = new Autobus("AA333AA", "LAMBORGINI", 43, null);
		Autobus a89 = new Autobus("ZZ999AA", "WOZFAGEN", 32, null);

		Officina r = new Officina("Via dalle palle 8", 32,2);
		Officina r1 = new Officina("Via Vai 32 12", 89,2);
		
		LinkedList<Officina> officine = new LinkedList<Officina>();
		LinkedList<Autobus> autobuses = new LinkedList<Autobus>();
		
		officine.add(r);
		officine.add(r1);
		
		autobuses.add(a89);
		autobuses.add(a34);
		
		
		Manutenzione m = new Manutenzione(autobuses, officine);
		m.run();
		
		
	}

	
}