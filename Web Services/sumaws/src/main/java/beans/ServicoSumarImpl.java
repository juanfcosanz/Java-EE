package beans;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Created by Juan Francisco on 01/04/2014.
 */

@Stateless
@WebService(endpointInterface = "beans.ServicioSumarWS")
public class ServicoSumarImpl implements ServicioSumarWS {

    @Override
    public int sumar(int a, int b) {
        return a + b;
    }
}
