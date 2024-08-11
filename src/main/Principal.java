package main;

import java.util.Scanner;
import cofrinhoDeMoedas.Cofrinho;
import moedas.Dolar;
import moedas.Euro;
import moedas.Moeda;
import moedas.Real;
import java.util.InputMismatchException;


public class Principal {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Cofrinho cofrinho = new Cofrinho(); // CRIA UMA INSTÂNCIA DA CLASSE COFRINHO E A ASSOCIA À VARIÁVEL COFRINHO.

		System.out.println("💵 Cofrinho de Moedas 🐖");
		// MENU DE OPÇÕES EM LOOP PARA O USUÁRIO ESCOLHER A CADA INTERAÇÃO.
		while (true) {
			int opcao = 0;

			// TRATA A ENTRADA INVÁLIDA AO ESCOLHER UMA OPÇÃO DO MENU
			while (true) {
				try {
					System.out.println("\n ***** Menu *****" + "\n " 
							+ "1. Adicionar moeda" + "\n " 
							+ "2. Remover moeda"+ "\n " 
							+ "3. Listar moedas" + "\n " 
							+ "4. Calcular total convertido para Real" + "\n "
							+ "5. Sair" + "\n " + "Escolha uma opção: ");
					opcao = scanner.nextInt(); // LÊ A OPÇÃO ESCOLHIDA PELO USUÁRIO E GUARDA NA VARIÁVEL OPCAO.
					break; // SAI DO LOOP SE A ENTRADA FOR VÁLIDA
				} catch (InputMismatchException e) {
					System.out.println("❌ Entrada inválida! Escolha uma das opções do menu.");
					scanner.next(); // LIMPA A ENTRADA INVÁLIDA
				}
			}

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

				while (true) {
					try {
						System.out.println("Escolha a moeda (1. Dólar, 2. Euro, 3. Real): ");
						escolhaMoeda = scanner.nextInt();

						if (escolhaMoeda < 1 || escolhaMoeda > 3) {
							System.out.println("Por favor, escolha uma opção válida (1, 2 ou 3).");
						} else {
							break; // SAIA DO LOOP SE A ESCOLHA FOR VÁLIDA
						}
					} catch (InputMismatchException e) { // InputMismatchException TRATA A EXCECÃO QUANDO O USUARIO
															// DIGITA UM CARACTER NÃO NUMÉRICO.
						System.out.println("❌ Entrada inválida! Por favor, escolha uma das opções de moedas.");
						scanner.next(); // LIMPA A ENTRADA INVÁLIDA EVITANDO UM LOOP INFINITO DE EXCEÇÕES.
					}
				}

				// LÊ O VALOR DA MOEDA, GARANTINDO QUE SEJA UM NÚMERO POSITIVO
				while (true) {
					try {
						System.out.print("Informe o valor da moeda: ");
						valorMoeda = scanner.nextDouble();

						if (valorMoeda <= 0) {
							System.out.println("❌ Valor inválido! Coloque um valor positivo maior que zero.\n");
						} else {
							// CRIA UMA INSTÂNCIA DA MOEDA ESCOLHIDA
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
								System.out.println("❌ Opção inválida!");
							}

							if (novaMoeda != null) { // SE NOVAMOEDA NÃO FOR NULL, ENTÃO ADICIONA ESSA MOEDA AO COFRINHO
														// USANDO O MÉTODO ADICIONAR NA CLASSE COFRINHO.
								cofrinho.adicionar(novaMoeda);
								System.out.println("💲Moeda adicionada com sucesso!");
							}
							break; // SAI DO LOOP SE O VALOR FOR VÁLIDO
						}
					} catch (InputMismatchException e) {
						System.out.println("❌ Opção inválida!");
						scanner.next(); // LIMPA A ENTRADA INVÁLIDA
					}
				}

				break; // ENCERRA O CASE 1 E RETORNA AO MENU PRINCIPAL

			/*
			 * REMOVENDO MOEDA: SOLICITA AO USUÁRIO O ÍNDICE DA MOEDA A SER REMOVIDA E
			 * VERIFICA SE O ÍNDICE É VÁLIDO ANTES DE REMOVER
			 */
			case 2:
				if (cofrinho.getListaMoedas().isEmpty()) {
					System.out.println("💸 O cofrinho está vazio!");
				} else {
					int indiceMoeda = 0;
					while (true) {
						try {
							System.out.println("Digite o índice da moeda que deseja remover: ");
							cofrinho.listagemMoedas(); // EXIBE O ÍNDICE DE MOEDAS PRESENTES NO COFRINHO
							indiceMoeda = scanner.nextInt();
							if (indiceMoeda < 0 || indiceMoeda >= cofrinho.getListaMoedas().size()) {
								System.out.println("⚠️ Índice inválido! Escolha um índice existente.");
							} else {
								// QUANDO O NÚMERO DO ÍNDICE É VÁLIDO REMOVE A MOEDA.
								cofrinho.remover(indiceMoeda);
								System.out.println("Moeda removida com sucesso!");
								break; // SAIA DO LOOP APÓS REMOVER
							}
						} catch (InputMismatchException e) {
							System.out.println("❌ Opção inválida! Escolha uma das opções do Menu.");
							scanner.next(); // LIMPA A ENTRADA INVÁLIDA
						}
					}
				}

				break; // ENCERRA O CASE 2 E RETORNA AO MENU PRINCIPAL

			case 3:
				cofrinho.listagemMoedas();
				break; // ENCERRA O CASE 3 E RETORNA AO MENU PRINCIPAL

			/*
			 * MOSTRA O TOTAL DE DINHEIRO DO COFRINHO: CHAMA O MÉTODO TOTALCONVERTIDO NA
			 * CLASSE COFRINHO QUE TRAZ O MONTANTE TOTAL JÁ CONVERTIDO EM REAIS, O MÉTODO
			 * STRING FORMAT FORMATA A SAÍDA COM 2 CASAS DECIMAIS APÓS A VIRGULA.
			 */
			case 4:
				System.out.println("Total convertido para Real: R$ " + String.format("%.2f", cofrinho.totalConvertido()));
				break; // ENCERRA O CASE 4 E RETORNA AO MENU PRINCIPAL

			case 5:
				System.out.println("Encerrando o programa...");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("❌ Opção inválida! Escolha uma das opções do menu");

			}
		}
	}
}
