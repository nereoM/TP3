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
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazPrincipal {

	private JFrame frame;
	private JTextField textVertice, textPeso, textArista1, textArista2;
	private JLabel labelVertice, labelPeso, labelArista, labelCargar, cartelError, cartelError2;
	private JButton botonAgregar, botonArista, botonGenerar;
	private JCheckBox checkManual, checkAutomatico, checkGrafoCompleto;
	private Grafo grafo;
	private EncontrarCliqueMayorPesoPorPeso clique;
	private EncontrarCliqueMayorPesoTotal clique2;
	private EncontrarCliqueMayorCantVertices clique3;
	private JButton botonMostrarG;
	private JButton botonVerticesCargados;
	private LectorTxt lector;
	private JLabel labelTiempoEjecucion;
	private DecimalFormat decimalFormat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal window = new InterfazPrincipal();
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
	public InterfazPrincipal() {
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
		frame.setBounds(200, 150, 572, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		definirObjetosPantalla();
		
		botones();
		
		grafo = new Grafo();
		
		lector = new LectorTxt();
		
		decimalFormat = new DecimalFormat("#.###");
	}

	private void definirObjetosPantalla() {
		textVertice = new JTextField();
		textVertice.setBounds(62, 108, 52, 20);
		frame.getContentPane().add(textVertice);
		textVertice.setColumns(10);
		
		textPeso = new JTextField();
		textPeso.setBounds(62, 139, 52, 20);
		frame.getContentPane().add(textPeso);
		textPeso.setColumns(10);
		
		labelVertice = new JLabel("Vertice: ");
		labelVertice.setFont(new Font("Arial", Font.BOLD, 12));
		labelVertice.setBounds(6, 105, 52, 26);
		frame.getContentPane().add(labelVertice);
		
		labelPeso = new JLabel("Peso: ");
		labelPeso.setFont(new Font("Arial", Font.BOLD, 12));
		labelPeso.setBounds(6, 142, 46, 14);
		frame.getContentPane().add(labelPeso);
		
		textArista1 = new JTextField();
		textArista1.setBounds(363, 108, 38, 20);
		frame.getContentPane().add(textArista1);
		textArista1.setColumns(10);
		
		labelArista = new JLabel("Arista: ");
		labelArista.setFont(new Font("Arial", Font.BOLD, 12));
		labelArista.setBounds(307, 111, 46, 14);
		frame.getContentPane().add(labelArista);
		
		textArista2 = new JTextField();
		textArista2.setBounds(411, 108, 38, 20);
		frame.getContentPane().add(textArista2);
		textArista2.setColumns(10);
		
		labelCargar = new JLabel("Cargar: ");
		labelCargar.setFont(new Font("Arial", Font.BOLD, 12));
		labelCargar.setBounds(12, 11, 46, 14);
		frame.getContentPane().add(labelCargar);
		
		checkGrafoCompleto = new JCheckBox("Vertices cargados");
		checkGrafoCompleto.setFont(new Font("Arial", Font.BOLD, 9));
		checkGrafoCompleto.setBounds(6, 173, 111, 23);
		frame.getContentPane().add(checkGrafoCompleto);
		
		cartelError = new JLabel("");
		cartelError.setVisible(false);
		cartelError.setFont(new Font("Arial", Font.BOLD, 9));
		cartelError.setBounds(124, 143, 113, 14);
		frame.getContentPane().add(cartelError);
		
		cartelError2 = new JLabel("");
		cartelError2.setVisible(false);
		cartelError2.setFont(new Font("Arial", Font.BOLD, 9));
		cartelError2.setBounds(180, 37, 146, 14);
		frame.getContentPane().add(cartelError2);
		
		labelTiempoEjecucion = new JLabel("");
		labelTiempoEjecucion.setVisible(false);
		labelTiempoEjecucion.setFont(new Font("Arial", Font.BOLD, 9));
		labelTiempoEjecucion.setBounds(6, 300, 186, 14);
		frame.getContentPane().add(labelTiempoEjecucion);

	}
	
	private void botones() {
		botonAgregar = new JButton("Agregar");
		botonAgregar.setEnabled(false);
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartelError.setVisible(false);
				agregarVerticeConPeso();
			}
		});
		botonAgregar.setBackground(new Color(192, 192, 192));
		botonAgregar.setBorderPainted(false);
		botonAgregar.setFont(new Font("Arial", Font.BOLD, 12));
		botonAgregar.setBounds(124, 107, 89, 23);
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
		botonArista.setBounds(307, 138, 103, 23);
		frame.getContentPane().add(botonArista);
		
		botonGenerar = new JButton("Generar");
		botonGenerar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				try {
					verificarGrafoCargado();
					grafo.randomizarPeso();
					//clique2 = new EncontrarCliqueMayorPesoTotal();
					clique3 = new EncontrarCliqueMayorCantVertices();
					long startTime = System.nanoTime();
					//List<Vertice> cliqueMaxCantVertices = clique2.encontrarCliqueMayorPeso(grafo);
					//List<Vertice> cliqueMaxPorPeso = clique.encontrarCliqueDeMayorPeso(grafo);
					List<Vertice> cliqueMaxCantVertices = clique3.encontrarCliqueMayorCantVertices(grafo);
					double tiempo = medirTiempo(startTime);
			        String tiempoFormateado = decimalFormat.format(tiempo);
					//AdaptadorDeGrafoCliqueMax frame = new AdaptadorDeGrafoCliqueMax(cliqueMaxPorPeso, devolverPesosVertices(cliqueMaxPorPeso));
			        AdaptadorDeGrafoCliqueMax frame = new AdaptadorDeGrafoCliqueMax(cliqueMaxCantVertices, devolverPesosVertices(cliqueMaxCantVertices));
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        frame.setSize(400, 400);
			        frame.setBounds(400, 150, 400, 400);
			        frame.setVisible(true);
			        frame.setResizable(false);
			        labelTiempoEjecucion.setText("Tiempo de ejecucion: " + tiempoFormateado + " ms");							// FALTA AGREGAR CANT DE NODOS EVALUADOS
			        labelTiempoEjecucion.setVisible(true);
				} catch (RuntimeException e1) {
					cartelError2.setText(e1.getMessage());
					cartelError2.setVisible(true);
				}
				
			}

		});
		botonGenerar.setBackground(new Color(192, 192, 192));
		botonGenerar.setBorderPainted(false);
		botonGenerar.setFont(new Font("Arial", Font.BOLD, 12));
		botonGenerar.setBounds(237, 414, 89, 23);
		frame.getContentPane().add(botonGenerar);
		
		botonMostrarG = new JButton("Mostrar grafo original");
		botonMostrarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					verificarGrafoCargado();
					AdaptadorDeGrafo frame = new AdaptadorDeGrafo(grafo, grafo.devolverPesosVertices());
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        frame.setSize(400, 400);
			        frame.setBounds(400, 150, 400, 400);
			        frame.setVisible(true);
			        frame.setResizable(false);
				}
				catch (RuntimeException e1) {
					cartelError2.setText(e1.getMessage());
					cartelError2.setVisible(true);
				}
		        
			}
		});
		botonMostrarG.setFont(new Font("Arial", Font.BOLD, 10));
		botonMostrarG.setBorderPainted(false);
		botonMostrarG.setBackground(new Color(192, 192, 192));
		botonMostrarG.setBounds(10, 414, 139, 23);
		frame.getContentPane().add(botonMostrarG);
		
		botonVerticesCargados = new JButton("Grafo cargado");
		botonVerticesCargados.setHorizontalAlignment(SwingConstants.LEFT);
		botonVerticesCargados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafo.inicializarMatrizAdy();
			}
		});
		botonVerticesCargados.setBorderPainted(false);
		botonVerticesCargados.setBackground(new Color(192, 192, 192));
		botonVerticesCargados.setFont(new Font("Arial", Font.BOLD, 10));
		botonVerticesCargados.setBounds(134, 172, 103, 23);
		frame.getContentPane().add(botonVerticesCargados);
		
		checkManual = new JCheckBox("Manual");
		checkManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkManual.isSelected()) {
					grafo = new Grafo();
					botonAgregar.setEnabled(true);
					cartelError2.setVisible(false);
				}
				else {
					botonAgregar.setEnabled(false);
				}
			}
		});
		
		checkAutomatico = new JCheckBox("Automatico");
		checkAutomatico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkAutomatico.isSelected()) {
					try {
						cartelError2.setVisible(false);
						lector.leerArchivoVertices(grafo);
						grafo.inicializarMatrizAdy();
						lector.leerArchivoAristas(grafo);
						botonAgregar.setEnabled(false);
					} catch (IllegalArgumentException e1) {
						cartelError2.setVisible(true);
						cartelError2.setText("Grafo ya cargado!");
					}
					
				}
				else {
					cartelError2.setVisible(false);
				}
			}
		});
		
		checkManual.setFont(new Font("Arial", Font.BOLD, 11));
		checkManual.setBounds(70, 7, 97, 23);
		frame.getContentPane().add(checkManual);
		
		checkAutomatico.setFont(new Font("Arial", Font.BOLD, 11));
		checkAutomatico.setBounds(70, 33, 97, 23);
		frame.getContentPane().add(checkAutomatico);
	}
	
	private void agregarVerticeConPeso() {
		try {
			grafo.agregarVertice(Integer.parseInt(textVertice.getText()), Integer.parseInt(textPeso.getText()));
		}
		catch (IllegalArgumentException e) {
			cartelError.setText(e.getMessage());
			cartelError.setVisible(true);
		}
		
	}
	 
    private Map<String, Double> devolverPesosVertices(List<Vertice> clique) {
		Map<String, Double> pesos = new HashMap<String, Double>();
		for(Vertice v:clique) {
			pesos.put(v.getId()+"", v.getPeso());
		}
		return pesos;
	}
    
    private double medirTiempo(long startTime) {
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
        return (double) duration / 1_000_000.0;
	}
    
    private void verificarGrafoCargado() {
		if (grafo.getVertices().size() == 0) {
			throw new RuntimeException("Grafo no cargado!");
		}
	}
}
