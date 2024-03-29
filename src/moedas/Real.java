package moedas;

import java.text.DecimalFormat;

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
		DecimalFormat df = new DecimalFormat("#.00"); //FORMATA O VALOR PARA 2 CASAS DECIMAIS APÓS A VÍRGULA.
	    String valorFormatado = df.format(valor);
		System.out.println("Moeda: Real - Valor: " + valorFormatado);
	}

	@Override
	public double converter() {
		// VALOR DA MOEDA REAL JÁ É EM REAL, ENTÃO NÃO PRECISA DE CONVERSÃO.
		return valor;
	}

}
