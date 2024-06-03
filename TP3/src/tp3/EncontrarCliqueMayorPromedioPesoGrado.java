package tp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EncontrarCliqueMayorPromedioPesoGrado {

	public ArrayList<Vertice> encontrarCliqueMayorPesoGrado(Grafo grafo) {
        ArrayList<Vertice> clique = new ArrayList<Vertice>();
        ArrayList<Vertice> vertices = grafo.getVertices();
        ArrayList<Vertice> ordenadosPorPesoGrado = new ArrayList<Vertice>();

        for (Vertice v:vertices) {
            int grado = grafo.getVecinos(v.getId()).size();
            //v.setPesoGrado(v.getPeso() / grado);
            ordenadosPorPesoGrado.add(new Vertice(v.getId(), v.getPeso()/grado));
        }

        Comparator<Vertice> comparador = new ComparadorPorPeso();
        Collections.sort(ordenadosPorPesoGrado, comparador);

        for (Vertice v : ordenadosPorPesoGrado) {
            Vertice verticeOriginal = grafo.getVertice(v.getId());
            if (esCompatible(verticeOriginal, clique, grafo)) {
                clique.add(verticeOriginal);
            }
        }

        return clique;
    }

    private static boolean esCompatible(Vertice vertice, List<Vertice> clique, Grafo grafo) {
        for (Vertice verticeEnClique : clique) {
            if (!grafo.getVecinos(verticeEnClique.getId()).contains(vertice)) {
                return false;
            }
        }
        return true;
    }
}
