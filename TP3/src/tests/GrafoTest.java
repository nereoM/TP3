package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tp3.Grafo;

public class GrafoTest {

	private Grafo grafo;

    @Before
    public void inicializarGrafo() {
        grafo = new Grafo();
    }

    @Test
    public void agregarVerticeTest() {
        grafo.agregarVertice(0, 1.5);
        assertEquals("El tamaño del grafo después de agregar un vértice debe ser 1", 1, grafo.tamano());
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarVerticeInvalidoTest() {
        grafo.agregarVertice(-1, 1.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarVerticePesoInvalidoTest() {
        grafo.agregarVertice(1, 0.5);
    }

    @Test
    public void agregarAristaTest() {
        grafo.agregarVertice(0, 1.5);
        grafo.agregarVertice(1, 2.0);
        grafo.inicializarMatrizAdy();
        grafo.agregarArista(0, 1);
        assertTrue("Debe existir una arista entre 0 y 1", grafo.existeArista(0, 1));
        assertTrue("Debe existir una arista entre 1 y 0", grafo.existeArista(1, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarAristaInvalidaTest() {
        grafo.agregarVertice(0, 1.5);
        grafo.agregarVertice(1, 2.0);
        grafo.inicializarMatrizAdy();
        grafo.agregarArista(0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarAristaBucleTest() {
        grafo.agregarVertice(0, 1.5);
        grafo.agregarVertice(1, 2.0);
        grafo.inicializarMatrizAdy();
        grafo.agregarArista(0, 0);
    }

    @Test
    public void existeAristaTest() {
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
