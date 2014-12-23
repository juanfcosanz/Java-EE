package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversiones {

	private static final String FORMATO_FECHA = "dd-MM-yyyy";

	// Metodo que permite convertir una fecha e cadena 
	// con el formato especificado

	public static String format(Date fecha) {
		SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
		return formateador.format( fecha );
	}
}
