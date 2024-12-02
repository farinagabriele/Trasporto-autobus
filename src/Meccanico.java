/**
 * 
 * @author skype
 *Ha responsabilità singola sull'associazione lavora con vincolo di
 * molteplicità 1..1
 * 
 */
public class Meccanico extends Dipendente{
	private Officina officina;

	public Meccanico(String nome, Officina officina) {
		super(nome);
		setOfficina(officina);
	}

	public Officina getOfficina() {
		return officina;
	}

	public void setOfficina(Officina officina) {
		if (officina == null)
			throw new RuntimeException("Violazione del vincolo di responsabilita'");
		this.officina = officina;
	}

	@Override
	public String toString() {
		return "Meccanico [officina=" + officina + ", nome=" + super.getNome() + "]";
	}
	
}
