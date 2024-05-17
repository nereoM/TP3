package tp3;

public class Vertice implements Comparable<Vertice>{

	private int id;
	private int peso;
	
	public Vertice(int v, int peso) {
		agregarVertice(v);
		agregarPesoVertice(peso);
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public void agregarVertice(int v) {
		verificarVertice(v);
		this.id = v;
	}
	
	public void agregarPesoVertice(int peso) {
		verificarVertice(id);
		if (peso <= 0) {
			throw new IllegalArgumentException();
		}
		this.peso = peso;
	}
	
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
	}

	@Override
	public int compareTo(Vertice o) {
		return this.getPeso() - o.getPeso();
	}
	
	
}
