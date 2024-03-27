package moedas;

// CLASSE DOLAR - FILHA DE MOEDA
public class Dolar extends Moeda {

	public Dolar(double valor) {
		super(valor);
	}

	/*
	 * ESSE MÉTODO SOBRESCREVE A IMPLEMENTACÇÃO DO MÉTODO INFO NA CLASSE MÃE
	 * IMPRIMIR INFORMAÇÕES SOBRE A MOEDA DO TIPO REAL, COMO SEU NOME E VALOR.
	 * DENTRO DO MÉTODO, UMA MENSAGEM É IMPRESSA NO CONSOLE USANDO
	 * SYSTEM.OUT.PRINTLN(), EXIBINDO O NOME DA MOEDA COMO "DÓLAR" E SEU VALOR.
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
