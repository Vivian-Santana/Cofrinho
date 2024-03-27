package moedas;

// CLASSE EURO - FILHA DE MOEDA
public class Euro extends Moeda {

	public Euro(double valor) {
		super(valor);
	}

	/*
	 * ESSE MÉTODO SOBRESCREVE A IMPLEMENTAÇÃO DO MÉTODO INFO NA CLASSE MÃE - MOEDA,
	 * DENTRO DO MÉTODO IMPRIME NOME E VALOR DA MOEDA, QUE APARECE AO USUÁRIO QUANDO SOLICITADO.
	 */
	@Override
	public void info() {
		System.out.println("Moeda: Euro - Valor: " + valor);
	}

	@Override
	public double converter() {
		// IMPLEMENTAÇÃO DA CONVERSÃO DE EURO PARA REAL (1 EURO = 5,40 REAIS)
		return valor * 5.40;
	}

}
