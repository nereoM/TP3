package tp3;

import java.util.ArrayList;

public class Vertice {

	private int id;
	private double peso;
	private ArrayList<Vertice> vecinos;
	
	public Vertice(int v, double d) {
		agregarVertice(v);
		agregarPesoVertice(d);
		vecinos = new ArrayList<Vertice>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void agregarVertice(int v) {
		verificarVertice(v);
		this.id = v;
	}
	
	public void agregarPesoVertice(double d) {
		verificarVertice(id);
		if (d <= 0) {
			throw new IllegalArgumentException();
		}
		this.peso = d;
	}
	
	public void agregarVecino(Vertice v) {
		if (!vecinos.contains(v)) {
			vecinos.add(v);
		}
	}
	
	public ArrayList<Vertice> getVecinos() {
		return vecinos;
	}
	
	public void setVecinos(ArrayList<Vertice> v) {
		vecinos = v;
	}
	
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
	}
}
