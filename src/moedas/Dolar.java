package moedas;

import java.text.DecimalFormat;

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
		DecimalFormat df = new DecimalFormat("#.00"); //FORMATA O VALOR PARA 2 CASAS DECIMAIS APÓS A VÍRGULA.
	    String valorFormatado = df.format(valor);
		System.out.println("Moeda: Dólar - Valor: " + valorFormatado);
	}

	@Override
	public double converter() {
		// IMPLEMENTAÇÃO DA CONVERSÃO DE DÓLAR PARA REAL (1 DÓLAR = 4,98 REAIS)
		return valor * 4.98;
	}

}
