package main;

import java.util.Scanner;
import cofrinhoDeMoedas.Cofrinho;
import moedas.Dolar;
import moedas.Euro;
import moedas.Moeda;
import moedas.Real;

public class Principal {

	// MÉTODO PRINCIPAL PARA EXECUTAR O SISTEMA
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // FAZ A LEITURA DOS DADOS DE ENTRADA
		Cofrinho cofrinho = new Cofrinho(); // CRIA UMA INSTÂNCIA DA CLASSE COFRINHO E A ASSOCIA À VARIÁVEL COFRINHO

		System.out.println("Cofrinho de Moedas 💵🐖");
		// MENU DE OPÇÕES EM LOOP PARA O USUÁRIO ESCOLLHER A CADA INTERAÇÃO
		while (true) {
			System.out.println("\n ***** Menu *****" + "\n " 
					+ "1. Adicionar moeda" + "\n " 
					+ "2. Remover moeda" + "\n "
					+ "3. Listar moedas" + "\n " 
					+ "4. Calcular total convertido para Real" + "\n " 
					+ "5. Sair" + "\n "
					+ "Escolha uma opção: ");
			int opcao = scanner.nextInt(); // LÊ A OPÇÃO ESCOLHIDA PELO USUÁRIO E GUARDA NA VARIÁVEL OPCAO

			// USANDO PRIMEIRO SWITCH CASE PARA VERIFICAR A OPÇÃO QUE O USUÁRIO ESCOLHEU NO
			// MENU
			switch (opcao) {
			case 1: // ADICIONAR UMA MOEDA AO COFRINHO.
				System.out.println("Escolha a moeda (1. Dólar, 2. Euro, 3. Real): "); // DÁ AS OPÇÕES DOS TIPOS DE MOEDA
																						// PARA ADICIONAR
				int escolhaMoeda = scanner.nextInt();
				System.out.print("Informe o valor da moeda: "); // E SOLICITA O VALOR DA MOEDA.
				double valorMoeda = scanner.nextDouble();
				Moeda novaMoeda = null; // A VARIÁVEL NOVAMOEDA INICIALIZADA COM NULL SERÁ USADA PARA ARMAZENAR A NOVA
										// MOEDA A SER CRIADA.
				/*
				 * O SWITCH INTERNO VERIFICA QUAL OPÇÃO DE MOEDA O USUÁRIO ESCOLHEU E CRIA UMA
				 * INSTÂNCIA DA CLASSE CORRESPONDENTE (DOLAR, EURO OU REAL) COM O VALOR
				 * FORNECIDO PELO USUÁRIO. SE O USUÁRIO ESCOLHER UMA OPÇÃO VÁLIDA, ENTÃO
				 * NOVAMOEDA SERÁ DIFERENTE DE NULL E UMA NOVA INSTÂNCIA DE MOEDA SERÁ CRIADA.
				 */
				switch (escolhaMoeda) {
				case 1:
					novaMoeda = new Dolar(valorMoeda);
					break;
				case 2:
					novaMoeda = new Euro(valorMoeda);
					break;
				case 3:
					novaMoeda = new Real(valorMoeda);
					break;
				default: // TRATAMENTO DE ERRO
					System.out.println("Opção inválida! Por favor, escolha uma opção válida (1, 2 ou 3)");
				}
				if (novaMoeda != null) { // SE NOVAMOEDA NÃO FOR NULL, ENTÃO ADICIONA ESSA MOEDA AO COFRINHO USANDO O
											// MÉTODO ADICIONAR DA CLASSE COFRINHO.
					cofrinho.adicionar(novaMoeda);
					System.out.println("Moeda adicionada com sucesso!💲");
				}
				break;
			case 2: // REMOVENDO MOEDA
				// SOLICITA AO USUÁRIO O ÍNDICE DA MOEDA A SER REMOVIDA E VERIFICA SE O ÍNDICE É
				// VÁLIDO ANTES DE REMOVER
				System.out.println("Digite o índice da moeda que deseja remover: ");
				cofrinho.listagemMoedas(); // EXIBE O ÍNDICE DE MOEDAS PRESENTES NO COFRINHO
				int indiceMoeda = scanner.nextInt();

				if (indiceMoeda >= 0 && indiceMoeda < cofrinho.getListaMoedas().size()) {
					Moeda moedaRemover = cofrinho.getListaMoedas().get(indiceMoeda);
					cofrinho.remover(moedaRemover);
					System.out.println("Moeda removida com sucesso!");
				} else {
					System.out.println("Índice inválido! ⚠️"); // SE A OPÇÃO ESCOLHIDA NÃO FOR VÁLIDA (FOR DIFERENTE DE
																// 1, 2 OU 3), ESSA MENSAGEM DE ERRO SERÁ EXIBIDA.
				}
				break;
			case 3:
				cofrinho.listagemMoedas();
				break;
			/*
			 * CHAMA O MÉTODO TOTALCONVETIDO NA CLASSE COFRINHO QUE TRAZ O MONTANTE TOTAL EM
			 * REAIS, O MÉTODO STRING FORMAT FORMATA A SAÍDA COM 2 CASAS DECIMAIS APÓS A
			 * VIRGULA.
			 */
			case 4:
				System.out
						.println("Total convertido para Real: R$ " + String.format("%.2f", cofrinho.totalConvertido()));
				break;
			case 5: // TRAZ A OPÇÃO DE ENCERRAR O PROGRAMA
				System.out.println("Encerrando o programa...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opção inválida! ❌"); // MOSTRA ESSA MENSAGEM SE O USUÁRIO DIGITAR UMA OPÇÃO INVÁLIDA
			}
		}
	}
}
