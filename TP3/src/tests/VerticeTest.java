package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tp3.Vertice;

public class VerticeTest {

	@Test(expected = IllegalArgumentException.class)
	public void idInvalidoTest() {

		Vertice v = new Vertice(-1, 1);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pesoInvalidoTest() {

		Vertice v = new Vertice(0, 0);
	
	}
	
	@Test
	public void vecinosTest() {
		Vertice v = new Vertice(0, 1.5);
		Vertice vec1 = new Vertice(1, 2.0);
		Vertice vec2 = new Vertice(2, 3.0);
		
		v.agregarVecino(vec1);
		v.agregarVecino(vec2);
		
		assertEquals(v.cantVecinos(), v.getVecinos().size());
	}

}
