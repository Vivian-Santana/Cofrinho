package main;

import java.util.Scanner;
import cofrinhoDeMoedas.Cofrinho;
import moedas.Dolar;
import moedas.Euro;
import moedas.Moeda;
import moedas.Real;

public class Principal {

	// MÉTODO PRINCIPAL PARA EXECUTAR O SISTEMA.
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Cofrinho cofrinho = new Cofrinho(); // CRIA UMA INSTÂNCIA DA CLASSE COFRINHO E A ASSOCIA À VARIÁVEL COFRINHO.

		System.out.println("💵 Cofrinho de Moedas 🐖");
		// MENU DE OPÇÕES EM LOOP PARA O USUÁRIO ESCOLLHER A CADA INTERAÇÃO.
		while (true) {
			System.out.println("\n ***** Menu *****" + "\n " 
					+ "1. Adicionar moeda" + "\n " 
					+ "2. Remover moeda" + "\n "
					+ "3. Listar moedas" + "\n " 
					+ "4. Calcular total convertido para Real" + "\n " 
					+ "5. Sair" + "\n "
					+ "Escolha uma opção: ");
			int opcao = scanner.nextInt(); // LÊ A OPÇÃO ESCOLHIDA PELO USUÁRIO E GUARDA NA VARIÁVEL OPCAO.

			// O SWITCH CASE EXTERNO VERIFICA A OPÇÃO QUE O USUÁRIO ESCOLHEU NO MENU.
			switch (opcao) {
			/*
			 * ADICIONA UMA MOEDA AO COFRINHO: DO WHILE FAZ UM TRATAMENTO DE ERRO,
			 * IMPOSSIBILITANDO O USUÁRIO DE PROSSEGUIR SE FOR DIGITADO UM VALOR DIFERENTE
			 * DE 1,2 OU 3, REPETINDO ATÉ QUE UMA OPÇÃO VÁLIDA DE MOEDA SEJA ESCOLHIDA.
			 */
			case 1:
				int escolhaMoeda;
				double valorMoeda;
				Moeda novaMoeda = null;

				do {
					System.out.println("Escolha a moeda (1. Dólar, 2. Euro, 3. Real): "); // DÁ AS OPÇÕES DOS TIPOS DE PARA ADICIONAR.																							 
					escolhaMoeda = scanner.nextInt();
					if (escolhaMoeda < 1 || escolhaMoeda > 3) {
						System.out.println("Por favor, escolha uma opção válida (1, 2 ou 3).");
					}
				} while (escolhaMoeda < 1 || escolhaMoeda > 3);

				// E SOLICITA O VALOR DA MOEDA E IMPEDE O USUÁRIO DE ENTRAR COM ZERO OU COM UM VALOR NEGATIVO.
				do {
					System.out.print("Informe o valor da moeda: ");
					valorMoeda = scanner.nextDouble();

					if (valorMoeda <= 0) {
						System.out.println("Valor inválido! Coloque um valor positivo maior que Zero.\n");
					} else {
						novaMoeda = null; // A VARIÁVEL NOVAMOEDA INICIALIZADA COM NULL É USADA 
											// PARA ARMAZENAR A NOVA MOEDA.
					}
				} while (valorMoeda <= 0);

				/*
				 * O SWITCH CASE INTERNO VERIFICA QUAL OPÇÃO DE MOEDA O USUÁRIO ESCOLHEU E CRIA
				 * UMA INSTÂNCIA DA CLASSE CORRESPONDENTE (DOLAR, EURO OU REAL) COM O VALOR
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
				default:
					System.out.println("Opção inválida!");
				}
				if (novaMoeda != null) { // SE NOVAMOEDA NÃO FOR NULL, ENTÃO ADICIONA ESSA MOEDA AO COFRINHO
											// USANDO O MÉTODO ADICIONAR NA CLASSE COFRINHO.
					cofrinho.adicionar(novaMoeda);
					System.out.println("💲Moeda adicionada com sucesso!");
				}
				break;
			/*
			 * REMOVENDO MOEDA: SOLICITA AO USUÁRIO O ÍNDICE DA MOEDA A SER REMOVIDA E
			 * VERIFICA SE O ÍNDICE É VÁLIDO ANTES DE REMOVER
			 */
			case 2:
				int indiceMoeda = 0;
				do {
					System.out.println("Digite o índice da moeda que deseja remover: ");
					cofrinho.listagemMoedas(); // EXIBE O ÍNDICE DE MOEDAS PRESENTES NO COFRINHO
					indiceMoeda = scanner.nextInt();
					if (indiceMoeda < 0 || indiceMoeda >= cofrinho.getListaMoedas().size()) {
						System.out.println("⚠️ Índice inválido!  Escolha um índice existente.");
					}
				} while (indiceMoeda < 0 || indiceMoeda >= cofrinho.getListaMoedas().size());

				// QUANDO O NÚMERO DO ÍNDICE É VÁLIDO REMOVE A MOEDA.
				cofrinho.remover(indiceMoeda);
				System.out.println("Moeda removida com sucesso!");
				break;
			case 3:
				cofrinho.listagemMoedas();
				break;
			/*
			 * MOSTRA O TOTAL DE DINHEIRO DO COFRINHO: CHAMA O MÉTODO TOTALCONVETIDO NA
			 * CLASSE COFRINHO QUE TRAZ O MONTANTE TOTAL JÁ CONVERTIDO EM REAIS, O MÉTODO
			 * STRING FORMAT FORMATA A SAÍDA COM 2 CASAS DECIMAIS APÓS A VIRGULA.
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
				System.out.println("❌ Opção inválida! Escolha uma das opções do menu"); // MOSTRA ESSA MENSAGEM SE O
																						// USUÁRIO DIGITAR UMA OPÇÃO
																						// INVÁLIDA
			}
		}
	}
}
