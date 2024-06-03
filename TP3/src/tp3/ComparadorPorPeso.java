package tp3;

import java.util.Comparator;

public class ComparadorPorPeso implements Comparator<Vertice> {

	
	@Override
	public int compare(Vertice uno, Vertice otro) {
		if (uno.getPeso() < otro.getPeso()) {
			return 1;
		}
		else if (uno.getPeso() == otro.getPeso()) {
			return 0;
		}
		else {
			return -1;
		}
	}
}
