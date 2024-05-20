package tp3;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(0, 4);
		grafo.agregarVertice(1, 5);
		grafo.agregarVertice(2, 7);
		grafo.agregarVertice(3, 8);
		
		grafo.inicializarMatrizAdy();
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(2, 0);
		grafo.agregarArista(2, 1);
		grafo.agregarArista(3, 1);


		
		EncontrarCliqueMayorPeso clique = new EncontrarCliqueMayorPeso();
		ArrayList<Vertice> verticeClique = clique.encontrarCliqueMayorPeso(grafo);
		
		System.out.print("[");
		for (Vertice v:verticeClique) {
			System.out.print(v.getId() + ", ");
		}
		System.out.print("]");
	}
}
