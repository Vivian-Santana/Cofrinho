package cofrinhoDeMoedas;

import java.util.ArrayList;
import moedas.Moeda;

public class Cofrinho {

	private ArrayList<Moeda> listaMoedas;
	private int proximoIndice; // VARIÁVEL QUE CRIA NÚMEROS DE ÍNDICE PARA CADA MOEDA ADICIONADA

	// CRIA UM ARRAY LIST PARA AS MOEDAS
	public Cofrinho() {
		this.setListaMoedas(new ArrayList<Moeda>());
		proximoIndice = 1;
	}

	// MÉTODO PARA ADICIONAR MOEDA AO COFRINHO
	public void adicionar(Moeda moeda) {
		getListaMoedas().add(moeda);
		moeda.setNumero(proximoIndice++); // ATRIBUI O PRÓXIMO NÚMERO SEQUENCIAL À MOEDA ADICIONADA
	}

	// MÉTODO PARA REMOVER MOEDA ESPECÍFICA DO COFRINHO
	public void remover(Moeda moeda) {
		getListaMoedas().remove(moeda);
	}

	/*
	 * O IF VERRIFICA SE A LISTAMOEDAS ESTÁ VAZIA, SE ESTIVER MOSTRA A MENSAGEM QUE O COFRINHO ESTÁ VAZIO,
	 *  SE NÃO ESTIVER LISTA TODAS AS MOEDAS E O LAÇO FOR ADICONA UM NÚMERO DE ÍNDICE PARA AS POSIÇÕES DAS MOEDAS.
	 */
	public void listagemMoedas() {
		System.out.println("\n" + "💰 Moedas no cofrinho :");

		if (getListaMoedas().isEmpty()) {
			System.out.println("💸 O cofrinho está vazio! ");
		} else {
			for (int i = 0; i < getListaMoedas().size(); i++) {
				Moeda moeda = getListaMoedas().get(i);
				System.out.print("Índice: " + i + " - ");
				moeda.info();
			}
		}
	}

	// MÉTODO PARA CALCULAR O TOTAL CONVERTIDO PARA REAIS
	public double totalConvertido() {
		double total = 0;
		for (Moeda moeda : getListaMoedas()) {
			total += moeda.converter();
		}
		return total;
	}

	/*
	 * O MÉTODO GET, RETORNA O VALOR ATUAL DO ATRIBUTO LISTAMOEDAS EM UM OBJETO DO
	 * TIPO ARRAYLIST<MOEDA>, QUE É A LISTA DE MOEDAS ATUAL NO COFRINHO. ESSE MÉTODO
	 * PERMITE QUE OUTRAS PARTES DO CÓDIGO OBTENHAM ACESSO À LISTA DE MOEDAS ATUAL
	 * NO COFRINHO PARA VISUALIZAÇÃO OU MANIPULAÇÃO.
	 */
	public ArrayList<Moeda> getListaMoedas() {
		return listaMoedas;
	}

	/*
	 * O MÉTODO SET DEFINE O VALOR DO ATRIBUTO LISTAMOEDAS. ELE RECEBE COMO
	 * PARÂMETRO UM OBJETO DO TIPO ARRAYLIST<MOEDA>, QUE CONTÉM A NOVA LISTA DE
	 * MOEDAS A SER DEFINIDA NO COFRINHO E PERMITE QUE OUTRAS PARTES DO CÓDIGO DEFINAM
	 * UMA NOVA LISTA DE MOEDAS PARA O COFRINHO, ATUALIZANDO A LISTA DE MOEDAS.
	 */
	public void setListaMoedas(ArrayList<Moeda> listaMoedas) {
		this.listaMoedas = listaMoedas;
	}
}
