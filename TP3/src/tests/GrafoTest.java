package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tp3.Grafo;

public class GrafoTest {

	private Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Grafo();
    }

    @Test
    public void testTamanoInicial() {
        assertEquals("El tamaño inicial del grafo debe ser 0", 0, grafo.tamano());
    }

    @Test
    public void testAgregarVertice() {
        grafo.agregarVertice(0, 1.5);
        assertEquals("El tamaño del grafo después de agregar un vértice debe ser 1", 1, grafo.tamano());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarVerticeInvalido() {
        grafo.agregarVertice(-1, 1.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarVerticePesoInvalido() {
        grafo.agregarVertice(1, 0.5);
    }

    @Test
    public void testInicializarMatrizAdy() {
        grafo.agregarVertice(0, 1.5);
        grafo.agregarVertice(1, 2.0);
        grafo.inicializarMatrizAdy();
        boolean[][] matrizAdy = grafo.devolverMatrizAdy();
        assertFalse("La matriz de adyacencia debe ser falsa en [0][1]", matrizAdy[0][1]);
        assertFalse("La matriz de adyacencia debe ser falsa en [1][0]", matrizAdy[1][0]);
    }

    @Test
    public void testAgregarArista() {
        grafo.agregarVertice(0, 1.5);
        grafo.agregarVertice(1, 2.0);
        grafo.inicializarMatrizAdy();
        grafo.agregarArista(0, 1);
        assertTrue("Debe existir una arista entre 0 y 1", grafo.existeArista(0, 1));
        assertTrue("Debe existir una arista entre 1 y 0", grafo.existeArista(1, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarAristaInvalida() {
        grafo.agregarVertice(0, 1.5);
        grafo.agregarVertice(1, 2.0);
        grafo.inicializarMatrizAdy();
        grafo.agregarArista(0, 2); // El vértice 2 no existe
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarAristaLoop() {
        grafo.agregarVertice(0, 1.5);
        grafo.agregarVertice(1, 2.0);
        grafo.inicializarMatrizAdy();
        grafo.agregarArista(0, 0); // No se permiten loops
    }

    @Test
    public void testExisteArista() {
        grafo.agregarVertice(0, 1.5);
        grafo.agregarVertice(1, 2.0);
        grafo.inicializarMatrizAdy();
        grafo.agregarArista(0, 1);
        assertTrue("Debe existir una arista entre 0 y 1", grafo.existeArista(0, 1));
    }
    
    @Test
    public void existeAristaFalseTest() {
    	grafo.agregarVertice(0, 2.0);
    	grafo.agregarVertice(1, 3.5);
    	grafo.inicializarMatrizAdy();
    	assertFalse(grafo.existeArista(0, 1));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void existeAristaConVerticeNoExistenteFalseTest() {
    	grafo.agregarVertice(0, 2.0);
    	grafo.agregarVertice(1, 3.5);
    	grafo.inicializarMatrizAdy();
    	grafo.existeArista(0, 2);
    }
}
