package tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class EncontrarCliqueMayorPesoPorPeso {
	
	 public static List<Vertice> encontrarCliqueDeMayorPeso(Grafo grafo) {
	        List<Vertice> verticesOrdenados = new ArrayList<Vertice>(grafo.getVertices());
	        Comparator<Vertice> comparador = new ComparadorPorPeso();
	        Collections.sort(verticesOrdenados, comparador);

	        List<Vertice> clique = new ArrayList<Vertice>();

	        for (Vertice vertice:verticesOrdenados) {
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

	        for (Vertice verticeEnClique:clique) {
	        	/*
	            if (!sonCompatibles(vertice, verticeEnClique, grafo)) {
	                return false;
	            }
	            */
	        	if (!grafo.getVecinos(verticeEnClique.getId()).contains(vertice)) {
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

