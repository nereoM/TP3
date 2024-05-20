package tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EncontrarCliqueMayorPeso {
	
	public ArrayList<Vertice> encontrarCliqueMayorPeso(Grafo grafo) {
		ArrayList<Vertice> vertices = grafo.getVertices();
		Collections.sort(vertices);
		Collections.reverse(vertices);
	    ArrayList<Vertice> clique = new ArrayList<Vertice>();
	    
	    for (Vertice v:vertices) {
	        boolean puedeAgregarse = true;
	        for (Vertice vertice:clique) {
	            if (!grafo.getVecinos(vertice.getId()).contains(v)) {
	                puedeAgregarse = false;
	                break;
	            }
	        }

	        if (puedeAgregarse) {
	            clique.add(v);
	        }
	    }
	    return clique;
	}
}
