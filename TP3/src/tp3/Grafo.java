package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

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
	/*
	public void agregarVertice(int v, double peso) {
        if (v >= 0 && peso >= 1 && !existeV(v)) {
            Vertice nuevoVertice = new Vertice(v, peso);
            vertices.add(nuevoVertice);
            adyacencia.add(new ArrayList<>());
        } else {
            throw new IllegalArgumentException("Argumento/s invalido/s!");
        }
    }
    */
	
	public void agregarVertice(int v, double peso) {
        if (v >= 0 && peso >= 1 && !existeV(v)) {
            Vertice nuevoVertice = new Vertice(v, peso);
            vertices.add(nuevoVertice);
        } else {
            throw new IllegalArgumentException("Argumento/s invalido/s!");
        }
    }

	public boolean existeV(int ver) {
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
            adyacencia.get(v1).add(vertices.get(v2));
            adyacencia.get(v2).add(vertices.get(v1));
        }
    }
    */
	
	public void agregarArista(int v1, int v2) {
        verificarVertice(v1);
        verificarVertice(v2);
        verificarDistintos(v1, v2);
        if (existeV(v1) && existeV(v2)) {
            vertices.get(v1).agregarVecino(vertices.get(v2));
            vertices.get(v2).agregarVecino(vertices.get(v1));
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
		verificarDistintos(i, j);
//		return A[i][j];
		if (existeV(i) && existeV(j)) {
			Vertice vi = this.vertices.get(i);
			Vertice vj = this.vertices.get(j);
			return this.vertices.get(i).getVecinos().contains(vj) && this.vertices.get(j).getVecinos().contains(vi);
		}
		return false;
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
	
//	public ArrayList<Vertice> getVecinos(int v) {
//		return adyacencia.get(v);
//	}
	
	public void reiniciar() {
		vertices.clear();
	}
	
	public ArrayList<Vertice> getVecinos(int v) {
		return vertices.get(v).getVecinos();
	}
}
