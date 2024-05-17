package tp3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Interfaz extends JPanel{

	private JFrame frame;
	private JTextField textVertice, textPeso, textArista1, textArista2;
	private JLabel labelVertice, labelPeso, labelArista, labelCargar;
	private JButton botonAgregar, botonArista;
	private JCheckBox checkManual, checkAutomatico;
	private Grafo grafo;
	private Map<Vertice, Point> posiciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 862, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		definirObjetosPantalla();
		
		botones();
		
		Grafo grafo = new Grafo();
		
	}

	private void definirObjetosPantalla() {
		textVertice = new JTextField();
		textVertice.setBounds(78, 14, 52, 20);
		frame.getContentPane().add(textVertice);
		textVertice.setColumns(10);
		
		textPeso = new JTextField();
		textPeso.setBounds(78, 45, 52, 20);
		frame.getContentPane().add(textPeso);
		textPeso.setColumns(10);
		
		labelVertice = new JLabel("Vertice: ");
		labelVertice.setFont(new Font("Arial", Font.BOLD, 12));
		labelVertice.setBounds(22, 11, 52, 26);
		frame.getContentPane().add(labelVertice);
		
		labelPeso = new JLabel("Peso: ");
		labelPeso.setFont(new Font("Arial", Font.BOLD, 12));
		labelPeso.setBounds(22, 48, 46, 14);
		frame.getContentPane().add(labelPeso);
		
		checkManual = new JCheckBox("Manual");
		checkManual.setFont(new Font("Arial", Font.BOLD, 11));
		checkManual.setBounds(743, 7, 97, 23);
		frame.getContentPane().add(checkManual);
		
		checkAutomatico = new JCheckBox("Automatico");
		checkAutomatico.setFont(new Font("Arial", Font.BOLD, 11));
		checkAutomatico.setBounds(743, 39, 97, 23);
		frame.getContentPane().add(checkAutomatico);
		
		textArista1 = new JTextField();
		textArista1.setBounds(369, 14, 38, 20);
		frame.getContentPane().add(textArista1);
		textArista1.setColumns(10);
		
		labelArista = new JLabel("Arista: ");
		labelArista.setFont(new Font("Arial", Font.BOLD, 12));
		labelArista.setBounds(313, 17, 46, 14);
		frame.getContentPane().add(labelArista);
		
		textArista2 = new JTextField();
		textArista2.setBounds(417, 14, 38, 20);
		frame.getContentPane().add(textArista2);
		textArista2.setColumns(10);
		
		labelCargar = new JLabel("Cargar: ");
		labelCargar.setFont(new Font("Arial", Font.BOLD, 12));
		labelCargar.setBounds(691, 11, 46, 14);
		frame.getContentPane().add(labelCargar);
		
	}
	
	private void botones() {
		botonAgregar = new JButton("Agregar");
		botonAgregar.setBackground(new Color(192, 192, 192));
		botonAgregar.setBorderPainted(false);
		botonAgregar.setFont(new Font("Arial", Font.BOLD, 12));
		botonAgregar.setBounds(154, 13, 89, 23);
		frame.getContentPane().add(botonAgregar);
		
		botonArista = new JButton("Agregar arista");
		botonArista.setBorderPainted(false);
		botonArista.setBackground(new Color(192, 192, 192));
		botonArista.setHorizontalAlignment(SwingConstants.LEFT);
		botonArista.setFont(new Font("Arial", Font.BOLD, 10));
		botonArista.setBounds(480, 13, 103, 23);
		frame.getContentPane().add(botonArista);
	}
	
	private void agregarVerticeConPeso() {
		try {
			grafo.agregarVertice(Integer.parseInt(textVertice.getText()), Integer.parseInt(textPeso.getText()));
		}
		catch () {
			
		}
		
	}
	
	private void generarPosiciones() {
        int width = 800;
        int height = 600;
        int margin = 50;
        int radius = Math.min(width, height) / 2 - margin;

        int n = grafo.tamano();
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
