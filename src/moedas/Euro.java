package moedas;

// CLASSE EURO - FILHA DE MOEDA
public class Euro extends Moeda {

	public Euro(double valor) {
		super(valor);
	}

	/*
	 * ESSE MÉTODO SOBRESCREVE A IMPLEMENTACÇÃO DO MÉTODO INFO NA CLASSE MÃE
	 * IMPRIMIR INFORMAÇÕES SOBRE A MOEDA DO TIPO REAL, COMO SEU NOME E VALOR.
	 * DENTRO DO MÉTODO, UMA MENSAGEM É IMPRESSA NO CONSOLE USANDO
	 * SYSTEM.OUT.PRINTLN(), EXIBINDO O NOME DA MOEDA COMO "EURO" E SEU VALOR.
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
