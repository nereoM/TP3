package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tp3.EncontrarCliqueMayorPesoPorPeso;
import tp3.Grafo;
import tp3.Vertice;

import java.util.ArrayList;
import java.util.List;

public class EncontrarCliqueMayorPesoTest {

    private Grafo grafo;

    @Before
    public void inicializarGrafo() {
        grafo = new Grafo();
    }

    @Test
    public void testCliqueMayorPeso() {
        // Agregar vértices al grafo
        grafo.agregarVertice(0, 2.0);
        grafo.agregarVertice(1, 1.5);
        grafo.agregarVertice(2, 3.0);
        grafo.agregarVertice(3, 2.5);

        // Inicializar matriz de adyacencia
//        grafo.inicializarMatrizAdy();

        // Crear aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 0);
        grafo.agregarArista(0, 2);

        // Encontrar clique de mayor peso
        EncontrarCliqueMayorPesoPorPeso clique = new EncontrarCliqueMayorPesoPorPeso();
        List<Vertice> cliqueMax = EncontrarCliqueMayorPesoPorPeso.encontrarCliqueDeMayorPeso(grafo);

        // Verificar el resultado
        assertNotNull(cliqueMax);
        assertEquals(3, cliqueMax.size());
        assertTrue(cliqueMax.contains(grafo.getVertice(0)));
        assertTrue(cliqueMax.contains(grafo.getVertice(2)));
        assertTrue(cliqueMax.contains(grafo.getVertice(3)));
    }

    @Test
    public void testCliqueVacia() {
        // No agregar vértices ni aristas al grafo

//    	grafo.inicializarMatrizAdy();
    	EncontrarCliqueMayorPesoPorPeso clique = new EncontrarCliqueMayorPesoPorPeso();
        List<Vertice> cliqueMax = EncontrarCliqueMayorPesoPorPeso.encontrarCliqueDeMayorPeso(grafo);

        // Encontrar clique de mayor peso

        // Verificar el resultado
        //assertNotNull(cliqueMax);
        assertEquals(0, cliqueMax.size());
    }

    @Test
    public void testCliqueUnVertice() {
        // Agregar vértice al grafo
        grafo.agregarVertice(0, 2.0);

        // Inicializar matriz de adyacencia
//        grafo.inicializarMatrizAdy();

        // Encontrar clique de mayor peso
        EncontrarCliqueMayorPesoPorPeso clique = new EncontrarCliqueMayorPesoPorPeso();
        List<Vertice> cliqueMax = EncontrarCliqueMayorPesoPorPeso.encontrarCliqueDeMayorPeso(grafo);

        // Verificar el resultado
        assertNotNull(cliqueMax);
        assertEquals(1, cliqueMax.size());
        assertTrue(cliqueMax.contains(grafo.getVertice(0)));
    }
    
    @Test
    public void mismoPesoTotalDistintosVerticesTest() {
    	grafoPrueba();
    	
    	EncontrarCliqueMayorPesoPorPeso obtenido = new EncontrarCliqueMayorPesoPorPeso();
    	List<Vertice> cliqueObtenida = EncontrarCliqueMayorPesoPorPeso.encontrarCliqueDeMayorPeso(grafo);
    	
    	List<Integer> cliqueEsperada = cliquePrueba();
    	
    	for (Vertice v : cliqueObtenida) {
    		assertTrue(cliqueEsperada.contains(v.getId()));
    	}
    }

	private void grafoPrueba() {
		grafo.agregarVertice(0, 2.0);
    	grafo.agregarVertice(1, 1.5);
    	grafo.agregarVertice(2, 3.0);
    	grafo.agregarVertice(3, 2.5);
    	grafo.agregarVertice(4, 1.0);
    	grafo.agregarVertice(5, 1.0);
    	
    	grafo.agregarArista(0, 1);
    	grafo.agregarArista(0, 2);
    	grafo.agregarArista(0, 3);
    	grafo.agregarArista(1, 2);
    	grafo.agregarArista(2, 3);
    	grafo.agregarArista(2, 4);
    	grafo.agregarArista(2, 5);
    	grafo.agregarArista(3, 4);
    	grafo.agregarArista(3, 5);
    	grafo.agregarArista(4, 5);
	}

	private List<Integer> cliquePrueba() {
		List<Integer> cliqueEsperada = new ArrayList<Integer>();
		
//    	cliqueEsperada.add(2);
//    	cliqueEsperada.add(3);
//    	cliqueEsperada.add(4);
//    	cliqueEsperada.add(5);
    	
    	cliqueEsperada.add(0);
    	cliqueEsperada.add(2);
    	cliqueEsperada.add(3);
		return cliqueEsperada;
	}
    
}
