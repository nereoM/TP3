package tp3;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.ext.JGraphXAdapter;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

import java.util.List;
import java.util.Map;

import javax.swing.*;


public class AdaptadorDeGrafoCliqueMax extends JFrame {

    private static final long serialVersionUID = 1L;

    public AdaptadorDeGrafoCliqueMax(List<Vertice> clique, Map<String, Double> vertexWeights) {
        Graph<String, DefaultEdge> grafo = convertToJGraphT(clique);

        JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(grafo);

        mxCircleLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());
        
        for (Map.Entry<String, Double> entry : vertexWeights.entrySet()) {
            String vertice = entry.getKey();
            Double peso = entry.getValue();
            Object cell = graphAdapter.getVertexToCellMap().get(vertice);
            if (cell != null) {
                graphAdapter.getModel().setValue(cell, vertice + " (" + peso + ")");
            }
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graphAdapter);
        getContentPane().add(graphComponent);
    }

    private Graph<String, DefaultEdge> convertToJGraphT(List<Vertice> clique) {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        for (Vertice vertice:clique) {
            graph.addVertex(vertice.getId()+"");
        }
        
        for (Vertice v:clique) {
        	agregarAristas(v, clique, graph);
        }
        return graph;
    }

	private void agregarAristas(Vertice v, List<Vertice> clique, Graph<String, DefaultEdge> graph) {
		for (Vertice ver:clique) {
			if (!v.equals(ver)) {
				graph.addEdge(v.getId()+"", ver.getId()+"");
			}
		}
	}
}
