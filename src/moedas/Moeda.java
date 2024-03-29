package moedas;

// CLASSE MÃE ABSTRATA
public abstract class Moeda {

	protected double valor;

	// CONSTRUTOR
	protected Moeda(double valor) {
		super();
		this.valor = valor;
	}

	// MÉTODO ABSTRATO PARA FORNECER INFORMAÇÕES SOBRE A MOEDA.
	public abstract void info();

	// MÉTODO ABSTRATO PARA CONVERTER O VALOR DAS MOEDA PARA REAIS.
	public abstract double converter();

}
