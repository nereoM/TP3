package tp3;

import java.util.Comparator;
import java.util.Random;

public class ComparadorPorPeso implements Comparator<Vertice> {

	private Random random = new Random();
	
	@Override
	public int compare(Vertice uno, Vertice otro) {
		if (uno.getPeso() < otro.getPeso()) {
			return 1;
		}
		else if (uno.getPeso() == otro.getPeso()) {
			return random.nextInt(2) * 2 - 1;
		}
		else {
			return -1;
		}
	}
}
