package moedas;
// CLASSE REAL - FILHA DE MOEDA

public class Real extends Moeda {

	public Real(double valor) {
		super(valor);
	}

	/*
	 * ESSE MÉTODO SOBRESCREVE A IMPLEMENTAÇÃO DO MÉTODO INFO NA CLASSE MÃE - MOEDA,
	 * DENTRO DO MÉTODO IMPRIME NOME E VALOR DA MOEDA, QUE APARECE AO USUÁRIO QUANDO SOLICITADO.
	 */
	@Override
	public void info() {
		System.out.println("Moeda: Real - Valor: " + valor);
	}

	@Override
	public double converter() {
		// VALOR DA MOEDA REAL JÁ É EM REAL, ENTÃO NÃO PRECISA DE CONVERSÃO.
		return valor;
	}

}
