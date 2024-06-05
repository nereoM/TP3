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
	
	@Test
	public void vacioTest() {
		Grafo grafo = new Grafo();
		
		EncontrarCliqueMayorCantVertices obtenido = new EncontrarCliqueMayorCantVertices();
		List<Vertice> cliqueObtenida = obtenido.encontrarCliqueMayorCantVertices(grafo);
		
		assertEquals(0, cliqueObtenida.size());
	}
	
	private List<Vertice> cliquePrueba() {
		List<Vertice> clique = new ArrayList<Vertice>();
		clique.add(new Vertice(0,1));
		clique.add(new Vertice(1,1));
		clique.add(new Vertice(2,2));
		clique.add(new Vertice(3,3));
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
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(1, 5);
		
		grafo.agregarArista(2, 3);
		
		grafo.agregarArista(4, 5);

		return grafo;
	}
	
	private List<Vertice> cliqueMitades() {
		List<Vertice> clique = new ArrayList<Vertice>();
		clique.add(new Vertice(0,1));
		clique.add(new Vertice(1,1));
		clique.add(new Vertice(2,2));
		clique.add(new Vertice(3,3));

		return clique;
	}
	
	private Grafo grafoMitades() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice(0, 1);
		grafo.agregarVertice(1, 1);
		grafo.agregarVertice(2, 2);
		grafo.agregarVertice(3, 3);
		grafo.agregarVertice(4, 4);
		grafo.agregarVertice(5, 5);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(1, 5);
		
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);
		grafo.agregarArista(2, 5);
		
		grafo.agregarArista(4, 5);
		
		return grafo;
	}
	
}
