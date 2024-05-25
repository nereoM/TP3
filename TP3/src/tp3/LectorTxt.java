package tp3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LectorTxt {
	
	public void leerArchivoVertices(Grafo grafo) {
        String linea;
        int verticeId;
        double peso;

        try {
        	Path path = Paths.get("src/archivos/cargaDeVerticesPrueba.txt");
        	linea = path.toString();
            FileReader lectorArchivo = new FileReader(linea);
            BufferedReader lector = new BufferedReader(lectorArchivo);

            while ((linea = lector.readLine()) != null) {
                String[] numeros = linea.split(",");
                verticeId = Integer.parseInt(numeros[0]);
                peso = Double.parseDouble(numeros[1]);
                
                grafo.agregarVertice(verticeId, peso);

                System.out.println("VerticeId: " + verticeId);
                System.out.println("Peso: " + peso);
                System.out.println("------------------------");
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public void leerArchivoAristas(Grafo grafo) {
        String linea;
        int vertice1;
        int vertice2;

        try {
        	Path path = Paths.get("src/archivos/cargaDeAristasPrueba.txt");
        	linea = path.toString();
            FileReader lectorArchivo = new FileReader(linea);
            BufferedReader lector = new BufferedReader(lectorArchivo);

            while ((linea = lector.readLine()) != null) {
                String[] numeros = linea.split(",");
                vertice1 = Integer.parseInt(numeros[0]);
                vertice2 = Integer.parseInt(numeros[1]);
                
                grafo.agregarArista(vertice1, vertice2);

                System.out.println("Vertice1: " + vertice1);
                System.out.println("Vertice2: " + vertice2);
                System.out.println("------------------------");
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
	}
}
