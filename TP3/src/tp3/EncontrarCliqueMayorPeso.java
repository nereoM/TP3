package tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class EncontrarCliqueMayorPeso {
	
	
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
}
