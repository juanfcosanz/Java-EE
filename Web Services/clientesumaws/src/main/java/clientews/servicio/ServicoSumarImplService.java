
package clientews.servicio;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ServicoSumarImplService", targetNamespace = "http://beans/", wsdlLocation = "http://Dolga:8080/ServicoSumarImplService/ServicoSumarImpl?wsdl")
public class ServicoSumarImplService
    extends Service
{

    private final static URL SERVICOSUMARIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(clientews.servicio.ServicoSumarImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = clientews.servicio.ServicoSumarImplService.class.getResource(".");
            url = new URL(baseUrl, "http://Dolga:8080/ServicoSumarImplService/ServicoSumarImpl?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://Dolga:8080/ServicoSumarImplService/ServicoSumarImpl?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SERVICOSUMARIMPLSERVICE_WSDL_LOCATION = url;
    }

    public ServicoSumarImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicoSumarImplService() {
        super(SERVICOSUMARIMPLSERVICE_WSDL_LOCATION, new QName("http://beans/", "ServicoSumarImplService"));
    }

    /**
     * 
     * @return
     *     returns ServicioSumarWS
     */
    @WebEndpoint(name = "ServicoSumarImplPort")
    public ServicioSumarWS getServicoSumarImplPort() {
        return super.getPort(new QName("http://beans/", "ServicoSumarImplPort"), ServicioSumarWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioSumarWS
     */
    @WebEndpoint(name = "ServicoSumarImplPort")
    public ServicioSumarWS getServicoSumarImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://beans/", "ServicoSumarImplPort"), ServicioSumarWS.class, features);
    }

}
