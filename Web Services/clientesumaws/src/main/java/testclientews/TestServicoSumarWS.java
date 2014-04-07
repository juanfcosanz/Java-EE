package testclientews;

import clientews.servicio.ServicioSumarWS;
import clientews.servicio.ServicoSumarImplService;

/**
 * Created by Juan Francisco on 01/04/2014.
 */
public class TestServicoSumarWS {

    public static void main(String[] args){
        ServicioSumarWS servicoSumar = new ServicoSumarImplService().getServicoSumarImplPort();

        System.out.print("Ejecutando el servico Sumar WS");
        int x = 5;
        int y = 7;

        System.out.print("\nSumando los valores "+x+" y "+y);
        System.out.print("\nResultado: "+servicoSumar.sumar(x,y));
        System.out.print("\nFin del test");
    }
}
