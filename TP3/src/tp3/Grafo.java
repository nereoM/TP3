package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	public void agregarVertice(int v, double peso) {
        if (v >= 0 && peso >= 1 && !existeV(v)) {
            Vertice nuevoVertice = new Vertice(v, peso);
            vertices.add(nuevoVertice);
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
	
	public void agregarArista(int v1, int v2) {
        verificarVertice(v1);
        verificarVertice(v2);
        verificarDistintos(v1, v2);
        if (existeV(v1) && existeV(v2)) {
            vertices.get(v1).agregarVecino(vertices.get(v2));
            vertices.get(v2).agregarVecino(vertices.get(v1));
        }
        else {
        	throw new IllegalArgumentException("El vertice no existe!");
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
		if (existeV(i) && existeV(j)) {
			Vertice vi = vertices.get(i);
			Vertice vj = vertices.get(j);
			return vertices.get(i).getVecinos().contains(vj) && vertices.get(j).getVecinos().contains(vi);
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
	
	public void reiniciar() {
		vertices.clear();
	}
	
	public ArrayList<Vertice> getVecinos(int v) {
		return vertices.get(v).getVecinos();
	}
}
