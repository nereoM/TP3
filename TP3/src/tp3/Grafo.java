package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Grafo {

	private boolean[][] A;
	private ArrayList<Vertice> vertices;
	private ArrayList<ArrayList<Vertice>> adyacencia;

	public Grafo() {
		vertices = new ArrayList<Vertice>();
		adyacencia = new ArrayList<>();
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
	
	/*
	public void agregarVertice(int v, double peso) {
		if (v >= 0 && peso >= 1 && !existeV(v)) {
			vertices.add(new Vertice(v, peso));
		}
		else {
			throw new IllegalArgumentException("Argumento/s invalido/s!");
		}
	}
	*/
	
	public void agregarVertice(int v, double peso) {
        if (v >= 0 && peso >= 1 && !existeV(v)) {
            Vertice nuevoVertice = new Vertice(v, peso);
            vertices.add(nuevoVertice);
            adyacencia.add(new ArrayList<>());  // Añade una nueva lista de adyacencia para el nuevo vértice
        } else {
            throw new IllegalArgumentException("Argumento/s invalido/s!");
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
	
	public boolean[][] devolverMatrizAdy() {
        boolean[][] ady = A;
        return ady;
    }
	
	/*
	public void agregarArista(int v1, int v2) {
		verificarVertice(v1);
		verificarVertice(v2);
		verificarDistintos(v1, v2);
		if (existeV(v1) && existeV(v2)) {
			A[v1][v2] = true;
			A[v2][v1] = true;
		}
	}
	*/
	
	public void agregarArista(int v1, int v2) {
        verificarVertice(v1);
        verificarVertice(v2);
        verificarDistintos(v1, v2);
        if (existeV(v1) && existeV(v2)) {
            adyacencia.get(v1).add(vertices.get(v2));
            adyacencia.get(v2).add(vertices.get(v1));  // Si el grafo es no dirigido
        }
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

	public double getPesoVertice(int v) {
		return vertices.get(v).getPeso();
	}
	
	public Map<String, Double> devolverPesosVertices() {
		Map<String, Double> pesos = new HashMap<String, Double>();
		for(Vertice v:vertices) {
			pesos.put(v.getId()+"", v.getPeso());
		}
		return pesos;
	}
	
	
	public ArrayList<Vertice> getVertices() {
		ArrayList<Vertice> v = vertices;
		return v;
	}
	
	public Vertice getVertice(int v) {
		return vertices.get(v);
	}

	/*
	public ArrayList<Vertice> getVecinos(int v) {
		ArrayList<Vertice> vecinos = new ArrayList<Vertice>();
		for (int i = 0; i < tamano(); i++) {
			if (A[v][i]) {
				vecinos.add(vertices.get(i));
			}
		}
		return vecinos;
	}
	*/
	
	public ArrayList<Vertice> getVecinos(int v) {
		return adyacencia.get(v);
	}
	
	public void randomizarPeso() {
		int min = 0;
        int max = tamano();
        int vertice = ThreadLocalRandom.current().nextInt(min, max);
        int peso = ThreadLocalRandom.current().nextInt(1, 11);
        vertices.get(vertice).agregarPesoVertice(peso);
        System.out.println(vertice + ", " + peso);
	}
}
