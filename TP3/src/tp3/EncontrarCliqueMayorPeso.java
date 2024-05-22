package tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class EncontrarCliqueMayorPeso {
	
	/*
	public ArrayList<Vertice> encontrarCliqueMayorPeso(Grafo grafo) {
		ArrayList<Vertice> vertices = grafo.getVertices();
		Collections.sort(vertices);
		Collections.reverse(vertices);
	    ArrayList<Vertice> clique = new ArrayList<Vertice>();
	    Set<Integer> visited = new HashSet<>();
	    boolean puedeAgregarse = true;
	    
	    for (Vertice v:vertices) {
	    	puedeAgregarse = true;
	        for (Vertice vertice:clique) {
	            if (!grafo.getVecinos(vertice.getId()).contains(v)) {
	                puedeAgregarse = false;
	                break;
	            }
	        }

	        if (!visited.contains(v.getId()) && puedeAgregarse) {
	            clique.add(v);
	            visited.add(v.getId()); // Mark v as visited
	        }
	    }
	    return clique;
	}
	*/
	
	 public static List<Vertice> encontrarCliqueDeMayorPeso(Grafo grafo) {
	        List<Vertice> verticesOrdenados = new ArrayList<Vertice>(grafo.getVertices());
	        Comparator<Vertice> comparador = new ComparadorPorBeneficio();
	        Collections.sort(verticesOrdenados, comparador);

	        List<Vertice> clique = new ArrayList<Vertice>();

	        for (Vertice vertice : verticesOrdenados) {
	            if (esCompatible(vertice, clique, grafo)) {
	                clique.add(vertice);
	            }
	        }
	        return clique;
	    }

	    private static boolean esCompatible(Vertice vertice, List<Vertice> clique, Grafo grafo) {
	        if (clique.isEmpty()) {
	            return true;
	        }

	        for (Vertice verticeEnClique : clique) {
	            if (!sonCompatibles(vertice, verticeEnClique, grafo)) {
	                return false;
	            }
	        }

	        return true;
	    }

	    private static boolean sonCompatibles(Vertice vertice1, Vertice vertice2, Grafo grafo) {
	        for (Vertice vecino : grafo.getVecinos(vertice1.getId())) {
	            if (vecino == vertice2) {
	                return true;
	            }
	        }

	        return false;
	    }
}

