package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tp3.EncontrarCliqueMayorSumaPesoGrado;
import tp3.Grafo;
import tp3.Vertice;

public class EncontrarCliquePorPesoGradoTest {

	public Grafo grafo;
	
	@Before
	public void inicializarGrafo() {
		grafo = new Grafo();
	}
	
	@Test
	public void cliqueConVerticeMayorGradoTest() {
		grafo.agregarVertice(0, 2.0);
        grafo.agregarVertice(1, 1.5);
        grafo.agregarVertice(2, 3.0);
        grafo.agregarVertice(3, 2.5);

        // Crear aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 0);
        grafo.agregarArista(0, 2);

        EncontrarCliqueMayorSumaPesoGrado clique = new EncontrarCliqueMayorSumaPesoGrado();
        ArrayList<Vertice> cliqueMax = clique.encontrarCliqueMayorPesoGrado(grafo);

        assertEquals(3, cliqueMax.size());
        assertEquals(grafo.getVertice(0).getId(), cliqueMax.get(1).getId());
        assertEquals(grafo.getVertice(2).getId(), cliqueMax.get(0).getId());
        assertEquals(grafo.getVertice(3).getId(), cliqueMax.get(2).getId());
	}
	
	@Test
    public void cliqueVaciaTest() {
        EncontrarCliqueMayorSumaPesoGrado clique = new EncontrarCliqueMayorSumaPesoGrado();
        ArrayList<Vertice> cliqueMax = clique.encontrarCliqueMayorPesoGrado(grafo);

        assertEquals(0, cliqueMax.size());
    }
	
	@Test
    public void cliqueUnVerticeTest() {
        grafo.agregarVertice(0, 2.0);

        EncontrarCliqueMayorSumaPesoGrado clique = new EncontrarCliqueMayorSumaPesoGrado();
        ArrayList<Vertice> cliqueMax = clique.encontrarCliqueMayorPesoGrado(grafo);

        assertEquals(1, cliqueMax.size());
        assertEquals(grafo.getVertice(0).getId(), cliqueMax.get(0).getId());
    }
	
	@Test
    public void testCliqueConVerticesConPesoGradoIgual() {
        grafo.agregarVertice(0, 2.0);
        grafo.agregarVertice(1, 1.5);
        grafo.agregarVertice(2, 3.0);
        grafo.agregarVertice(3, 2.5);
        grafo.agregarVertice(4, 1.0);
        grafo.agregarVertice(5, 1.0);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 3);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(3, 5);
        grafo.agregarArista(4, 5);

        EncontrarCliqueMayorSumaPesoGrado cliqueAlgoritmo = new EncontrarCliqueMayorSumaPesoGrado();
        ArrayList<Vertice> cliqueMax = cliqueAlgoritmo.encontrarCliqueMayorPesoGrado(grafo);

        assertTrue(existeV(2, cliqueMax));
        assertTrue(existeV(3, cliqueMax));
        assertTrue(existeV(4, cliqueMax));
        assertTrue(existeV(5, cliqueMax));
        
	}
	
	public boolean existeV(int ver, ArrayList<Vertice> vertices) {
		for (Vertice v:vertices) {
			if (v.getId() == ver) {
				return true;
			}
		}
		return false;
	}
}
