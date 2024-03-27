package moedas;

// CLASSE DOLAR - FILHA DE MOEDA
public class Dolar extends Moeda {

	public Dolar(double valor) {
		super(valor);
	}

	/*
	 * ESSE MÉTODO SOBRESCREVE A IMPLEMENTAÇÃO DO MÉTODO INFO NA CLASSE MÃE - MOEDA,
	 * DENTRO DO MÉTODO IMPRIME NOME E VALOR DA MOEDA, QUE APARECE AO USUÁRIO QUANDO SOLICITADO.
	 */
	@Override
	public void info() {
		System.out.println("Moeda: Dólar - Valor: " + valor);
	}

	@Override
	public double converter() {
		// IMPLEMENTAÇÃO DA CONVERSÃO DE DÓLAR PARA REAL (1 DÓLAR = 4,98 REAIS)
		return valor * 4.98;
	}

}
