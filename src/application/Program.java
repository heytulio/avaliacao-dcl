package application;

import structure.*;

public class Program {

	public static void main(String[] args) {
		Lista lista = new Lista();
				
		lista.insere(5);
		lista.insere(4);
		lista.insere(3);
		lista.insere(2);
		lista.insere(1);

		
//		lista.print();
		
		System.out.println(lista.imprime());
		lista.remove(1, false);
		lista.remove(2, false);
		lista.remove(3, false);
		lista.remove(4, false);
		lista.remove(5, false);
		System.out.println(lista.imprime());
		

		lista.insere(1);
		lista.insere(2);
		lista.insere(3);
		lista.insere(4);
		lista.insere(5);
		System.out.println(lista.imprime());
		
	}

}
