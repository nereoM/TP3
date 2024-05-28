package tp3;

import java.util.ArrayList;
import java.util.List;

public class EncontrarCliqueMayorCantVertices {

	List<Vertice> encontrarCliqueMayorCantVertices(Grafo grafo) {
	    List<Vertice> clique = new ArrayList<>();
	    List<Vertice> cliqueActual = new ArrayList<>();
	    boolean[] visitados = new boolean[grafo.tamano()];

	    for (int i = 0; i < grafo.tamano(); i++) {
	        if (!visitados[i]) {
	            cliqueActual.clear();
	            cliqueActual.add(grafo.getVertice(i));
	            visitados[i] = true;

	            for (int j = i + 1; j < grafo.tamano(); j++) {
	                if (!visitados[j] && perteneceAClique(cliqueActual, j, grafo)) {
	                    cliqueActual.add(grafo.getVertice(j));
	                }
	            }

	            if (cliqueActual.size() > clique.size()) {
	                clique.clear();
	                clique.addAll(cliqueActual);
	            }
	        }
	    }

	    return clique;
	}
	
	private boolean perteneceAClique(List<Vertice> clique, int vertex, Grafo grafo) {
        for (Vertice v : clique) {
            if (!grafo.devolverMatrizAdy()[v.getId()][vertex]) {
                return false;
            }
        }
        return true;
    }
}
