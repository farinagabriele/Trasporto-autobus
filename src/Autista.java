import java.util.HashSet;


/**
 * 
 * @author skype
 * Ha responsabilità singola sull'associazione autorizzato con vincolo di
 * molteplicità 1..*
 * Implementazione:
 * Concediamo che al momento della creazione abbia molteplicità 0
 * a patto di fare la verifica nella remove e nel get
 */

public class Autista extends Dipendente implements Listener{
	private int rotture;
	private HashSet<Autorimessa> autorizzato;
	

	public Autista(String nome) {
		super(nome);
		this.rotture = 0;
		this.autorizzato = new HashSet<>();
	}

	public int getRotture() {
		return rotture;
	}

	public void setRotture(int rotture) {
		this.rotture = rotture;
	}
	
	public HashSet<Autorimessa> getAutorizzato(){
		if (this.autorizzato.size() < 1)
			throw new RuntimeException("Violazione del vincolo di molteplicita'");
		return this.autorizzato;
	}
	
	public void addAutorizzato(Autorimessa rimessa) {
		this.autorizzato.add(rimessa);
	}
	
	public void removeAutorizzato(Autorimessa rimessa) {
		this.autorizzato.remove(rimessa);
		if (this.autorizzato.size() < 1)
			throw new RuntimeException("Violazione del vincolo di molteplicita'");
	}
	

	@Override
	public String toString() {
		return "Autista [Rotture=" + this.rotture + ", Nome=" + getNome() + ", Rimesse=" + this.autorizzato + "]";
	}
	
	// Comportamento
	@Override
	public void fired(Evento e) {
		// TODO Auto-generated method stub
		
	}
	
	public void entrata(Autobus autobus) {
		
	}
	
}
