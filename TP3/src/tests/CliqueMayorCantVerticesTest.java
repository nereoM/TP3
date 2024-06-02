package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tp3.EncontrarCliqueMayorCantVertices;
import tp3.Grafo;
import tp3.Vertice;

public class CliqueMayorCantVerticesTest {

	@Test
	public void correctoTest() {

		Grafo grafo = grafoPrueba();
		
		EncontrarCliqueMayorCantVertices obtenido = new EncontrarCliqueMayorCantVertices();
		List<Vertice> cliqueObtenida = obtenido.encontrarCliqueMayorCantVertices(grafo);
		
	    List<Vertice> cliqueEsperada = cliquePrueba();
	    
	    List<Integer> vObtenidos = new ArrayList<Integer>();
	    for (Vertice v : cliqueObtenida) {
	    	vObtenidos.add(v.getId());
	    }
	    List<Integer> vEsperados = new ArrayList<Integer>();
	    for (Vertice v : cliqueEsperada) {
	    	vEsperados.add(v.getId());
	    }
	    
	    for (Integer id : vObtenidos) {
	    	assertTrue(vEsperados.contains(id));
	    }
	
	}
	
	@Test
	public void mitadesTest() { //Si el grafo tiene dos cliques con cliques de igual tamaño, selecciona la primer clique, sin importar los pesos
		
		Grafo grafo = grafoMitades();
		
		EncontrarCliqueMayorCantVertices obtenido = new EncontrarCliqueMayorCantVertices();
		List<Vertice> cliqueObtenida = obtenido.encontrarCliqueMayorCantVertices(grafo);
		
	    List<Vertice> cliqueEsperada = cliqueMitades();
	    
	    List<Integer> vObtenidos = new ArrayList<Integer>();
	    for (Vertice v : cliqueObtenida) {
	    	vObtenidos.add(v.getId());
	    }
	    List<Integer> vEsperados = new ArrayList<Integer>();
	    for (Vertice v : cliqueEsperada) {
	    	vEsperados.add(v.getId());
	    }
	    
	    for (Integer id : vObtenidos) {
	    	assertTrue(vEsperados.contains(id));
	    }
		
	}
	
	

	private List<Vertice> cliquePrueba() {
		List<Vertice> clique = new ArrayList<Vertice>();
		clique.add(new Vertice(0,1));
		clique.add(new Vertice(1,1));
		clique.add(new Vertice(2,2));
		clique.add(new Vertice(3,3));
		clique.add(new Vertice(4,4));
		clique.add(new Vertice(5,5));
		return clique;
	}

	private Grafo grafoPrueba() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice(0, 1);
		grafo.agregarVertice(1, 1);
		grafo.agregarVertice(2, 2);
		grafo.agregarVertice(3, 3);
		grafo.agregarVertice(4, 4);
		grafo.agregarVertice(5, 5);
		grafo.agregarVertice(6, 10);
		grafo.agregarVertice(7, 10);
		grafo.agregarVertice(8, 10);
		grafo.agregarVertice(9, 10);
		grafo.inicializarMatrizAdy();
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(0, 4);
		grafo.agregarArista(0, 5);
		
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(1, 5);
		
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);
		grafo.agregarArista(2, 5);
		
		grafo.agregarArista(3, 4);
		grafo.agregarArista(3, 5);
		
		grafo.agregarArista(4, 5);
		
		grafo.agregarArista(9, 8);
		grafo.agregarArista(9, 7);
		grafo.agregarArista(8, 7);
		return grafo;
	}
	
	private List<Vertice> cliqueMitades() {
		List<Vertice> clique = new ArrayList<Vertice>();
		clique.add(new Vertice(0,1));
		clique.add(new Vertice(1,1));
		clique.add(new Vertice(2,2));
		clique.add(new Vertice(3,3));
		clique.add(new Vertice(4,4));
		
//		clique.add(new Vertice(5,10));
//		clique.add(new Vertice(6,10));
//		clique.add(new Vertice(7,10));
//		clique.add(new Vertice(8,10));
//		clique.add(new Vertice(9,10));
		return clique;
	}
	
	private Grafo grafoMitades() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice(0, 1);
		grafo.agregarVertice(1, 1);
		grafo.agregarVertice(2, 2);
		grafo.agregarVertice(3, 3);
		grafo.agregarVertice(4, 4);
		grafo.agregarVertice(5, 10);
		grafo.agregarVertice(6, 10);
		grafo.agregarVertice(7, 10);
		grafo.agregarVertice(8, 10);
		grafo.agregarVertice(9, 10);
		grafo.inicializarMatrizAdy();
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(0, 4);
		
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);
		
		grafo.agregarArista(3, 4);
				
		grafo.agregarArista(5, 6);
		grafo.agregarArista(5, 7);
		grafo.agregarArista(5, 8);
		grafo.agregarArista(5, 9);
		
		grafo.agregarArista(6, 7);
		grafo.agregarArista(6, 8);
		grafo.agregarArista(6, 9);
		
		grafo.agregarArista(7, 8);
		grafo.agregarArista(7, 9);
		
		grafo.agregarArista(8, 9);
		return grafo;
	}

}
