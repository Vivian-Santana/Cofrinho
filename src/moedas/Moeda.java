package moedas;

// CLASSE MÃE ABSTRATA
public abstract class Moeda {

	protected double valor;
	protected int numero; // A VARIÁVEL QUE ARMAZENA O NUMERO DE ÍNDICE DE MOEDAS

	protected Moeda(double valor) {
		super();
		this.valor = valor;
	}

	// MÉTODO ABSTRATO PARA FORNECER INFORMAÇÕES SOBRE A MOEDA
	public abstract void info();

	// MÉTODO ABSTRATO PARA CONVERTER O VALOR DA MOEDA PARA REAL
	public abstract double converter();

	// MÉTODOS GET E SET PARA PEGAR E SETTAR RESPECTIVAMENTE NUMEROS DE ÍNDICES PARA AS POSIÇÕES DAS MOEDAS.
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
