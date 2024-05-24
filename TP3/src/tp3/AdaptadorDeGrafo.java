package tp3;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.ext.JGraphXAdapter;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

import java.util.Map;

import javax.swing.*;


public class AdaptadorDeGrafo extends JFrame {

    private static final long serialVersionUID = 1L;

    public AdaptadorDeGrafo(Grafo grafo, Map<String, Double> vertexWeights) {
        Graph<String, DefaultEdge> graph = convertToJGraphT(grafo);

        // Adaptar el grafo a JGraphX
        JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(graph);

        // Configurar el layout
        mxCircleLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());
        
        // Mostrar los pesos de los vértices
        for (Map.Entry<String, Double> entry : vertexWeights.entrySet()) {
            String vertex = entry.getKey();
            Double weight = entry.getValue();
            Object cell = graphAdapter.getVertexToCellMap().get(vertex);
            if (cell != null) {
                graphAdapter.getModel().setValue(cell, vertex + " (" + weight + ")");
            }
        }

        // Mostrar el grafo
        mxGraphComponent graphComponent = new mxGraphComponent(graphAdapter);
        getContentPane().add(graphComponent);
    }

    private Graph<String, DefaultEdge> convertToJGraphT(Grafo grafo) {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Añadir vértices
        for (Vertice vertex : grafo.getVertices()) {
            graph.addVertex(vertex.getId()+"");
        }

        // Añadir aristas
        /*
        for (Map.Entry<String, List<String>> entry : miGrafo.getEdges().entrySet()) {
            String source = entry.getKey();
            for (String target : entry.getValue()) {
                graph.addEdge(source, target);
            }
        }
        */
        
        for (int i = 0; i < grafo.tamano(); i++) {
            for (int j = i + 1; j < grafo.devolverMatrizAdy()[i].length; j++) {
                if (grafo.devolverMatrizAdy()[i][j]) {
                    graph.addEdge(grafo.getVertices().get(i).getId()+"", grafo.getVertices().get(j).getId()+"");
                }
            }
        }

        return graph;
    }

}