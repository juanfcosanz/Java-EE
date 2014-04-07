package beans;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Juan Francisco on 01/04/2014.
 */

@WebService
public interface ServicioSumarWS {

    @WebMethod
    public int sumar(int a, int b);
}
