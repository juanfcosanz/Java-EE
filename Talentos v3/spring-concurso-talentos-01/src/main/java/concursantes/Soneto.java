package concursantes;

public class Soneto implements Poema {

	@Override
	public void recitar() {
		String sonetoPasionSorJuana = "Este que ves. enga�o colorido, \n"
				+ "que del arte astentoso los primores \n"
				+ "es cauteloso enga�o del sentido\n"
				+ "este, en que la lijosna ha pretendido.";
		System.out.println("\nSoneto "+sonetoPasionSorJuana);

	}

}
