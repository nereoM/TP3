package tp3;

import java.util.ArrayList;
import java.util.List;

public class EncontrarCliqueMayorPesoTotal {
	
	public List<Vertice> encontrarCliqueMayorPeso(Grafo grafo) {
        List<Vertice> clique = new ArrayList<>();
        boolean[] visited = new boolean[grafo.tamano()];
        
        for (int i = 0; i < grafo.tamano(); i++) {
            if (!visited[i]) {
                List<Vertice> currentClique = new ArrayList<>();
                currentClique.add(grafo.getVertice(i));
                visited[i] = true;
                
                for (int j = i + 1; j < grafo.tamano(); j++) {
                    if (!visited[j] && isCliqueMember(currentClique, j, grafo)) {
                        currentClique.add(grafo.getVertice(j));
                        visited[j] = true;
                    }
                }
                
                if (totalWeight(currentClique, grafo) > totalWeight(clique, grafo)) {
                    clique = currentClique;
                }
            }
        }
        
        return clique;
    }
    
	private boolean isCliqueMember(List<Vertice> clique, int vertex, Grafo grafo) {
        for (Vertice v : clique) {
            if (grafo.devolverMatrizAdy()[v.getId()][vertex]) {
                return false;
            }
        }
        return true;
    }
    
    private int totalWeight(List<Vertice> clique, Grafo grafo) {
        int total = 0;
        for (Vertice v : clique) {
            total += v.getPeso();
        }
        return total;
    }

}
