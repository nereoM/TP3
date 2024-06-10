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

        JGraphXAdapter<String, DefaultEdge> adaptadorGrafo = new JGraphXAdapter<>(graph);

        mxCircleLayout layout = new mxCircleLayout(adaptadorGrafo);
        layout.execute(adaptadorGrafo.getDefaultParent());
        
        for (Map.Entry<String, Double> entry : vertexWeights.entrySet()) {
            String vertice = entry.getKey();
            Double peso = entry.getValue();
            Object cell = adaptadorGrafo.getVertexToCellMap().get(vertice);
            if (cell != null) {
                adaptadorGrafo.getModel().setValue(cell, vertice + " (" + peso + ")");
            }
        }

        mxGraphComponent graphComponent = new mxGraphComponent(adaptadorGrafo);
        getContentPane().add(graphComponent);
    }

    private Graph<String, DefaultEdge> convertToJGraphT(Grafo grafo) {
        Graph<String, DefaultEdge> grafoNuevo = new SimpleGraph<>(DefaultEdge.class);

        for (Vertice vertice:grafo.getVertices()) {
            grafoNuevo.addVertex(vertice.getId()+"");
        }
        
        for (Vertice v1:grafo.getVertices()) {
        	for (Vertice v2:grafo.getVertices()) {
        		if (grafo.getVecinos(v1.getId()).contains(v2)) {
        			grafoNuevo.addEdge(v1.getId()+"", v2.getId()+"");
        		}
        	}
        }

        return grafoNuevo;
    }

}