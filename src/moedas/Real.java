package moedas;
// CLASSE REAL - FILHA DE MOEDA

public class Real extends Moeda {

	public Real(double valor) {
		super(valor);
	}

	/*
	 * ESSE MÉTODO SOBRESCREVE A IMPLEMENTACÇÃO DO MÉTODO INFO NA CLASSE MÃE
	 * IMPRIMIR INFORMAÇÕES SOBRE A MOEDA DO TIPO REAL, COMO SEU NOME E VALOR.
	 * DENTRO DO MÉTODO, UMA MENSAGEM É IMPRESSA NO CONSOLE USANDO
	 * SYSTEM.OUT.PRINTLN(), EXIBINDO O NOME DA MOEDA COMO "REAL" E SEU VALOR.
	 */
	@Override
	public void info() {
		System.out.println("Moeda: Real - Valor: " + valor);
	}

	@Override
	public double converter() {
		// VALOR DA MOEDA REAL JÁ É EM REAL, ENTÃO NÃO PRECISA DE CONVERSÃO
		return valor;
	}

}
