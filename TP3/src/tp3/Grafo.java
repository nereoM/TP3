package tp3;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private boolean[][] A;
	private ArrayList<Vertice> vertices;

	public Grafo() {
		vertices = new ArrayList<Vertice>();
	}
	
	public int tamano()
	{
		return vertices.size();
	}
	
	public void inicializarMatrizAdy() {
		this.A = new boolean[tamano()][tamano()];
		for (int i = 0; i < tamano(); i++) {
		    for (int j = 0; j < tamano(); j++) {
		    	this.A[i][j] = false;
		    }
		}
	}
	
	public void agregarVertice(int v, int peso) {
		if (!existeV(v)) {
			vertices.add(new Vertice(v, peso));
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	private boolean existeV(int ver) {
		for (Vertice v:vertices) {
			if (v.getId() == ver) {
				return true;
			}
		}
		return false;
	}
	
//	public void agregarVertice(int v, int peso) {
//		if (vertices.get(v) == null) {
//			vertices.add(peso);
//		}
//	}
	
	public boolean[][] devolverMatrizAdy() {
        boolean[][] ady = A;
        return ady;
    }
	
	public void agregarArista(int v1, int v2) {
		verificarVertice(v1);
		verificarVertice(v2);
		verificarDistintos(v1, v2);
		if (existeV(v1) && existeV(v2)) {
			A[v1][v2] = true;
			A[v2][v1] = true;
		}
	}
	
	public boolean existeVertice(int v) {
		return vertices.contains(v);
	}
	
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= tamano())
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}
	
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		return A[i][j];
	}

	public int getPesoVertice(int v) {
		return vertices.get(v).getPeso();
	}
	
	
	public ArrayList<Vertice> getVertices() {
		ArrayList<Vertice> v = vertices;
		return v;
	}
	
	public Vertice getVertice(int v) {
		return vertices.get(v);
	}

	public ArrayList<Vertice> getVecinos(int v) {
		ArrayList<Vertice> vecinos = new ArrayList<Vertice>();
		for (int i = 0; i < tamano(); i++) {
			if (A[v][i]) {
				vecinos.add(vertices.get(i));
			}
		}
		return vecinos;
	}
	
	public boolean contiene(int v) {
		for (Vertice ver:vertices) {
			if (ver.getId() == v) {
				return true;
			}
		}
		return false;
	}
}
