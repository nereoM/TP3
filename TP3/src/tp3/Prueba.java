package tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prueba {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(0, 11.0);
		grafo.agregarVertice(1, 5.5);
		grafo.agregarVertice(2, 1.1);
		grafo.agregarVertice(3, 7.0);
		grafo.agregarVertice(4, 2.5);
		grafo.agregarVertice(5, 3.5);
		
		grafo.inicializarMatrizAdy();
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(2, 1);
		grafo.agregarArista(1, 5);
		grafo.agregarArista(3, 5);
		grafo.agregarArista(5, 4);
		grafo.agregarArista(4, 2);
		
		EncontrarCliqueMayorPesoPorPeso clique = new EncontrarCliqueMayorPesoPorPeso();
		List<Vertice> verticeClique = clique.encontrarCliqueDeMayorPeso(grafo);
		
		System.out.print("[");
		for (Vertice v:verticeClique) {
			System.out.print(v.getId() + ", ");
		}
		System.out.print("]");
	}
}
