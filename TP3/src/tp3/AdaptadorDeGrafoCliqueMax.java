package tp3;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.ext.JGraphXAdapter;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

import java.util.List;

import javax.swing.*;


public class AdaptadorDeGrafoCliqueMax extends JFrame {

    private static final long serialVersionUID = 1L;

    public AdaptadorDeGrafoCliqueMax(List<Vertice> clique) {
        Graph<String, DefaultEdge> graph = convertToJGraphT(clique);

        JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(graph);

        mxCircleLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        mxGraphComponent graphComponent = new mxGraphComponent(graphAdapter);
        getContentPane().add(graphComponent);
    }

    private Graph<String, DefaultEdge> convertToJGraphT(List<Vertice> clique) {
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        for (Vertice vertex : clique) {
            graph.addVertex(vertex.getId()+"");
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
