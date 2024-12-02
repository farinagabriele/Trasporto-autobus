
public abstract class Dipendente {
	private String nome;

	public Dipendente(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Dipendente [nome=" + nome + "]";
	}
	
	
}
