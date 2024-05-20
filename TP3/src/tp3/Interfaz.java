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
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JPanel{

	private JFrame frame;
	private JTextField textVertice, textPeso, textArista1, textArista2;
	private JLabel labelVertice, labelPeso, labelArista, labelCargar, cartelError;
	private JButton botonAgregar, botonArista, botonGenerar;
	private JCheckBox checkManual, checkAutomatico, checkGrafoCompleto;
	private Grafo grafo;
	private Map<Vertice, Point> posiciones;
	private EncontrarCliqueMayorPeso clique;
	private JButton botonMostrarG;
	private JButton botonVerticesCargados;
	private VisualizadorGrafo visualizador;

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
		
		grafo = new Grafo();
		
		//Graphics g = new Graphics();
		
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
		checkAutomatico.setBounds(743, 33, 97, 23);
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
		
		checkGrafoCompleto = new JCheckBox("Vertices cargados");
		checkGrafoCompleto.setFont(new Font("Arial", Font.BOLD, 9));
		checkGrafoCompleto.setBounds(22, 72, 111, 23);
		frame.getContentPane().add(checkGrafoCompleto);
	}
	
	private void botones() {
		botonAgregar = new JButton("Agregar");
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarVerticeConPeso();
			}
		});
		botonAgregar.setBackground(new Color(192, 192, 192));
		botonAgregar.setBorderPainted(false);
		botonAgregar.setFont(new Font("Arial", Font.BOLD, 12));
		botonAgregar.setBounds(154, 13, 89, 23);
		frame.getContentPane().add(botonAgregar);
		
		botonArista = new JButton("Agregar arista");
		botonArista.setEnabled(true);
		botonArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafo.agregarArista(Integer.parseInt(textArista1.getText()), Integer.parseInt(textArista2.getText()));
			}
		});

		botonArista.setBorderPainted(false);
		botonArista.setBackground(new Color(192, 192, 192));
		botonArista.setHorizontalAlignment(SwingConstants.LEFT);
		botonArista.setFont(new Font("Arial", Font.BOLD, 10));
		botonArista.setBounds(465, 13, 103, 23);
		frame.getContentPane().add(botonArista);
		
		cartelError = new JLabel("Vertice no valido!");
		cartelError.setVisible(false);
		cartelError.setFont(new Font("Arial", Font.BOLD, 9));
		cartelError.setBounds(154, 48, 89, 14);
		frame.getContentPane().add(cartelError);
		
		botonGenerar = new JButton("Generar");
		botonGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clique.encontrarCliqueMayorPeso(grafo);
			}
		});
		botonGenerar.setBackground(new Color(192, 192, 192));
		botonGenerar.setBorderPainted(false);
		botonGenerar.setFont(new Font("Arial", Font.BOLD, 12));
		botonGenerar.setBounds(751, 647, 89, 23);
		frame.getContentPane().add(botonGenerar);
		
		botonMostrarG = new JButton("Mostrar grafo");
		botonMostrarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizador = new VisualizadorGrafo(grafo);
				visualizador.actualizarGrafo();
			}
		});
		botonMostrarG.setFont(new Font("Arial", Font.BOLD, 10));
		botonMostrarG.setBorderPainted(false);
		botonMostrarG.setBackground(new Color(192, 192, 192));
		botonMostrarG.setBounds(578, 13, 103, 23);
		frame.getContentPane().add(botonMostrarG);
		
		botonVerticesCargados = new JButton("Grafo cargado");
		botonVerticesCargados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafo.inicializarMatrizAdy();
			}
		});
		botonVerticesCargados.setBorderPainted(false);
		botonVerticesCargados.setBackground(new Color(192, 192, 192));
		botonVerticesCargados.setFont(new Font("Arial", Font.BOLD, 10));
		botonVerticesCargados.setBounds(253, 44, 106, 23);
		frame.getContentPane().add(botonVerticesCargados);
	}
	
	private void agregarVerticeConPeso() {
		try {
			grafo.agregarVertice(Integer.parseInt(textVertice.getText()), Integer.parseInt(textPeso.getText()));
		}
		catch (Exception e) {
			cartelError.setText(e.getMessage());
		}
		
	}
}
