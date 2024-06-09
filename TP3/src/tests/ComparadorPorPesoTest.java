package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import tp3.ComparadorPorPeso;
import tp3.Vertice;

public class ComparadorPorPesoTest {
	
	@Test
    public void testCompararPesosMenor() {
        Vertice v1 = new Vertice(0, 1.0);
        Vertice v2 = new Vertice(1, 2.0);
        ComparadorPorPeso comparador = new ComparadorPorPeso();
        
        int resultado = comparador.compare(v1, v2);
        assertEquals(1, resultado);
    }

    @Test
    public void testCompararPesosIgual() {
        Vertice v1 = new Vertice(0, 1.0);
        Vertice v2 = new Vertice(1, 1.0);
        ComparadorPorPeso comparador = new ComparadorPorPeso();
        
        int resultado = comparador.compare(v1, v2);
        assertEquals(0, resultado);
    }

    @Test
    public void testCompararPesosMayor() {
        Vertice v1 = new Vertice(0, 2.0);
        Vertice v2 = new Vertice(1, 1.0);
        ComparadorPorPeso comparador = new ComparadorPorPeso();
        
        int resultado = comparador.compare(v1, v2);
        assertEquals(-1, resultado);
    }
}
