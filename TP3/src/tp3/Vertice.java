package tp3;

public class Vertice {

	private int id;
	private double peso;
	
	public Vertice(int v, double d) {
		agregarVertice(v);
		agregarPesoVertice(d);
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
	
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
	}
}
