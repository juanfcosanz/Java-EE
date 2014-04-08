package concursantes;

public class Soneto implements Poema {

	@Override
	public void recitar() {
		String sonetoPasionSorJuana = "Este que ves. engaño colorido, \n"
				+ "que del arte astentoso los primores \n"
				+ "es cauteloso engaño del sentido\n"
				+ "este, en que la lijosna ha pretendido.";
		System.out.println("\nSoneto "+sonetoPasionSorJuana);

	}

}
