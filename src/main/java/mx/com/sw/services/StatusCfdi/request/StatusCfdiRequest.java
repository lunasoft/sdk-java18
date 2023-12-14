package mx.com.sw.services.StatusCfdi.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import mx.com.sw.exceptions.GeneralException;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;
import org.apache.http.client.ClientProtocolException;
import org.eclipse.jdt.internal.eval.IRequestor;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Clase para generar una solicitud de estatus de CFDI a los servicios del SAT.
 */
public class StatusCfdiRequest {
    /**
     * Envía una solicitud de estatus de CFDI y devuelve la respuesta.
     *
     * @param request                       La solicitud de opciones de estatus de CFDI.
     * @return                              La respuesta de la solicitud de estatus de CFDI.
     * @throws GeneralException             Si ocurre un error general.
     * @throws ServicesException            Si ocurre un error en los servicios.
     * @throws UnsupportedEncodingException Si ocurre un error de codificación no admitida.
     * @throws ClientProtocolException      Si ocurre un error de protocolo del cliente.
     * @throws IOException                  Si ocurre un error de entrada o salida.
     * @throws SOAPException                Si ocurre un error de SOAP.
     */
    public StatusCfdiResponse sendRequest(IRequestor request) throws GeneralException, ServicesException,
            GeneralException, UnsupportedEncodingException, ClientProtocolException, IOException, SOAPException {
        // Obtiene los parámetros de la solicitud
        String soapEndpointUrl = ((StatusCfdiOptionsRequest) request).getURI();
        String rfcEmisor = ((StatusCfdiOptionsRequest) request).getRfcEmisor();
        String soapAction = ((StatusCfdiOptionsRequest) request).getAction();
        String rfcReceptor = ((StatusCfdiOptionsRequest) request).getRfcReceptor();
        String total = ((StatusCfdiOptionsRequest) request).getTotal();
        String uuid = ((StatusCfdiOptionsRequest) request).getUuid();
        String sello = ((StatusCfdiOptionsRequest) request).getSello();

        // Realiza la llamada al servicio web SOAP
        SOAPMessage response = callSoapWebService(soapEndpointUrl, soapAction, rfcEmisor,
                rfcReceptor, total, uuid, sello);
        SOAPBody body = response.getSOAPBody();
        SOAPFault error = body.getFault();

        // Procesa la respuesta
        if (error != null) {
            return new StatusCfdiResponse(500, "error", error.getFaultCode(), error.getFaultString());
        } else {
            String codigoEstatus = null;
            String estado = null;
            String esCancelable = null;
            String estatusCancelacion = null;
            NodeList consultaResult = body.getElementsByTagName("ConsultaResponse").item(0).getChildNodes();
            for (int i = 0; i < consultaResult.getLength(); i++) {
                NodeList datos = consultaResult.item(i).getChildNodes();
                for (int d = 0; d < datos.getLength(); d++) {
                    Node dato = datos.item(d);
                    if (dato.getNodeName().equalsIgnoreCase("a:CodigoEstatus")) {
                        codigoEstatus = dato.getTextContent();
                    }
                    if (dato.getNodeName().equalsIgnoreCase("a:Estado")) {
                        estado = dato.getTextContent();
                    }
                    if (dato.getNodeName().equalsIgnoreCase("a:EsCancelable")) {
                        esCancelable = dato.getTextContent();
                    }
                    if (dato.getNodeName().equalsIgnoreCase("a:EstatusCancelacion")) {
                        estatusCancelacion = dato.getTextContent();
                    }
                }
            }
            if (codigoEstatus.startsWith("N -")) {
                return new StatusCfdiResponse(400, "error", codigoEstatus, estado, esCancelable,
                        estatusCancelacion, codigoEstatus, codigoEstatus);
            } else {
                return new StatusCfdiResponse(200, "success", codigoEstatus, estado, esCancelable,
                        estatusCancelacion, "OK", "OK");
            }
        }
    }

    /**
     * Crea el envelope SOAP para la solicitud de estatus de CFDI.
     *
     * @param soapMessage El mensaje SOAP.
     * @param rfcEmisor   El RFC del emisor.
     * @param rfcReceptor El RFC del receptor.
     * @param total       El total del CFDI.
     * @param uuid        El UUID del CFDI.
     * @param sello       El sello del CFDI .
     * @throws SOAPException Si ocurre un error durante la petición SOAP.
     */
    private static void createSoapEnvelope(SOAPMessage soapMessage, String rfcEmisor, String rfcReceptor,
            String total, String uuid, String sello) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();
        String myNamespace = "tem";
        String myNamespaceURI = "http://tempuri.org/";
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("Consulta", myNamespace);
        SOAPElement soapExpresionImpresa = soapBodyElem.addChildElement("expresionImpresa", myNamespace);
        soapExpresionImpresa.addTextNode("<![CDATA[?re=" + rfcEmisor + "&rr=" + rfcReceptor + "&tt=" + total
                + "&id=" + uuid + "&fe" + sello + "]]>");
    }

    /**
     * Realiza una llamada al servicio web SOAP.
     *
     * @param soapEndpointUrl La URL del punto de conexión del servicio web SOAP.
     * @param soapAction      La acción SOAP.
     * @param rfcEmisor       El RFC del emisor.
     * @param rfcReceptor     El RFC del receptor.
     * @param total           El total del CFDI.
     * @param uuid            El UUID del CFDI.
     * @param sello           El sello del CFDI.
     * @return                El mensaje SOAP de respuesta.
     */
    private SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction, String rfcEmisor,
            String rfcReceptor, String total, String uuid, String sello) {
        try {
            // Configurar la confianza en la conexión SSL solo para URL de pruebas
            if (soapEndpointUrl.equals("https://pruebacfdiconsultaqr.cloudapp.net/ConsultaCFDIService.svc")) {
                TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }
                } };

                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }

            // Realiza la llamada al servicio web SOAP
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            SOAPMessage soapRequest = createSOAPRequest(soapAction, rfcEmisor, rfcReceptor, total, uuid, sello);
            SOAPMessage soapResponse = soapConnection.call(soapRequest, soapEndpointUrl);
            return soapResponse;
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\n");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Crea la solicitud SOAP.
     *
     * @param soapAction  La acción SOAP.
     * @param rfcEmisor   El RFC del emisor.
     * @param rfcReceptor El RFC del receptor.
     * @param total       El total del CFDI.
     * @param uuid        El UUID del CFDI.
     * @param sello       El sello del CFDI.
     * @return            El mensaje SOAP de solicitud.
     * @throws Exception  Si ocurre un error.
     */
    private static SOAPMessage createSOAPRequest(String soapAction, String rfcEmisor, String rfcReceptor,
            String total, String uuid, String sello) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        createSoapEnvelope(soapMessage, rfcEmisor, rfcReceptor, total, uuid, sello);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
        soapMessage.saveChanges();
        return soapMessage;
    }
}
