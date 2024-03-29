package cofrinhoDeMoedas;

import java.util.ArrayList;
import moedas.Moeda;

public class Cofrinho {

	private ArrayList<Moeda> listaMoedas;

	// CRIA UM ARRAY LIST PARA AS MOEDAS
	public Cofrinho() {
		this.setListaMoedas(new ArrayList<Moeda>());
	}

	// MÉTODO PARA ADICIONAR MOEDAS AO COFRINHO
	public void adicionar(Moeda moeda) {
		listaMoedas.add(moeda);
	}

	// MÉTODO PARA REMOVER UMA MOEDA ESPECÍFICA DO COFRINHO
	public void remover(int indice) {
		listaMoedas.remove(indice);
	}

	/*
	 * O IF VERRIFICA SE A LISTAMOEDAS ESTÁ VAZIA, SE ESTIVER MOSTRA A MENSAGEM QUE O COFRINHO ESTÁ VAZIO,
	 *  SE NÃO ESTIVER, LISTA TODAS AS MOEDAS E O LAÇO FOR ADICONA UM NÚMERO DE ÍNDICE PARA AS POSIÇÕES DAS MOEDAS.
	 */
	public void listagemMoedas() {
		System.out.println("\n" + "💰 Moedas no cofrinho :");

		if (listaMoedas.isEmpty()) {
			System.out.println("💸 O cofrinho está vazio! ");
		} else {
			for (Moeda moeda: listaMoedas) {
				int indice = listaMoedas.indexOf(moeda);
				System.out.print("Índice: " + indice + " - ");
				moeda.info();
			}
		}
	}

	/* 
	 * NO MÉTODO PARA CALCULAR O TOTAL CONVERTIDO PARA REAIS O LOOP FOR ESTÁ ITERANDO SOBRE A COLEÇÃO LISTAMOEDAS, QUE CONTÉM 
	 * OBJETOS DO TIPO MOEDA. PARA CADA MOEDA NA LISTA, O MÉTODO CONVERTER() É CHAMADO E O VALOR RETORNADO É SOMADO AO TOTAL. 
	 * AO FINAL DO LOOP, O TOTAL ACUMULADO É RETORNADO COMO O RESULTADO DO MÉTODO.
	 */
	
	public double totalConvertido() {
		double total = 0;
		for (Moeda moeda : listaMoedas) {
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
