package tp3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class VisualizadorGrafo extends JPanel{
	
	private Map<Vertice, Point> posiciones;
	private Grafo grafo;
	
	public VisualizadorGrafo(Grafo grafo) {
		this.grafo = grafo;
        this.posiciones = new HashMap<>();
        setPreferredSize(new Dimension(800, 600));
    }
	
	public void actualizarGrafo() {
        generarPosiciones();
        revalidate();
        repaint();
    }

	public void generarPosiciones() {
        int width = getWidth();
        int height = getHeight();
        int margin = 50;
        int radius = Math.min(width, height) / 2 - margin;
        int n = grafo.tamano();
        posiciones = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n;
            int x = (int) (width / 2 + radius * Math.cos(angle));
            int y = (int) (height / 2 + radius * Math.sin(angle));
            posiciones.put(grafo.getVertice(i), new Point(x, y));
        }
    }
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar aristas
        for (Vertice vertice:grafo.getVertices()) {
            Point p1 = posiciones.get(vertice);
            for (Vertice vecino:grafo.getVecinos(vertice.getId())) {
                Point p2 = posiciones.get(vecino);
                g2.draw(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));
            }
        }

        // Dibujar nodos
        for (Map.Entry<Vertice, Point> entry : posiciones.entrySet()) {
            Vertice vertice = entry.getKey();
            Point p = entry.getValue();
            g2.fillOval(p.x - 15, p.y - 15, 30, 30);
            g2.drawString(String.valueOf(vertice.getId()), p.x - 5, p.y + 5);
        }
    }
}
