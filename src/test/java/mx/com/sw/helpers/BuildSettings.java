package mx.com.sw.helpers;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import mx.com.sw.services.sign.Sign;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
* BuildSettings
* Clase auxiliar de UT con datos comunes.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class BuildSettings {
    private String simpleXml;
    private String bigXml;
    private String jsonCfdi;
    private String jsonCfdiBig;
    private Templates cfdiXSLT;
    private String urlSW;
    private String urlSWServices;
    private String userSW;
    private String passwordSW;
    private String cerPassword;
    private String tokenSW;
    private String email;
    private String cer;
    private String key;
    private String pfx;
    private String rfc;
    private String noCertificado;
    private String acuse;
    private String relationsXML;
    private String templateId;
    private Map<String, String> observaciones;
    private String xmlTimbrado;

    /**
    * Constructor de la clase.
    */
    public BuildSettings() {
        try {
            simpleXml = new String(Files.readAllBytes(Paths.get("resources/file.xml")), "UTF-8");
            bigXml = new String(Files.readAllBytes(Paths.get("resources/big.xml")), "UTF-8");
            jsonCfdi = new String(Files.readAllBytes(Paths.get("resources/cfdi.json")), "UTF-8");
            jsonCfdiBig = new String(Files.readAllBytes(Paths.get("resources/big.json")), "UTF-8");
            cfdiXSLT = loadXslt("resources/XSLT/cadenaoriginal_3_3.xslt");
            urlSW = "http://services.test.sw.com.mx";
            urlSWServices = "https://api.test.sw.com.mx";
            //Estas credenciales solo estaran activadas para las UT
            userSW = "userforut@ut.com";
            passwordSW = "swpassut";
            cerPassword = "12345678a";
            tokenSW = loadResourceAsString("resources/demoToken.txt");
            email = "unexestingemail@yopmail.com";
            cer = loadResouceAsB64("resources/CertificadosDePrueba/CSD_EKU9003173C9.cer");
            key = loadResouceAsB64("resources/CertificadosDePrueba/CSD_EKU9003173C9.key");
            pfx = loadResouceAsB64("resources/CertificadosDePrueba/PFX_EKU9003173C9.pfx");
            rfc = "EKU9003173C9";
            noCertificado = "30001000000400002434";
            acuse = loadResourceAsString("resources/XmlCancelacion.xml");
            relationsXML = loadResourceAsString("resources/RelationsXML.xml");
            templateId = "cfdi33";
            templateId = "payment";
            observaciones = new HashMap<String, String>();
            observaciones.put("Observaciones", "Entregar de 9am a 6pm");
            xmlTimbrado = new String(Files.readAllBytes(Paths.get("resources/file_pdf.xml")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Regresa el valor descrito.
    */
    public String getUrlSW() {
        return this.urlSW;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getUrlServicesSW() {
        return this.urlSWServices;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getUserSW() {
        return this.userSW;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getPasswordSW() {
        return this.passwordSW;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getPasswordCSD() {
        return this.cerPassword;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getTokenSW() {
        return this.tokenSW;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getEmail() {
        return this.email;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getKey() {
        return this.key;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getCSD() {
        return this.cer;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getPFX() {
        return this.pfx;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getRFC() {
        return this.rfc;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getNoCertificado() {
        return this.noCertificado;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getXmlCancelation() {
        return this.acuse;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getXmlRelations() {
        return this.relationsXML;
    }

    /**
    * Regresa el valor descrito.
    */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
    * Regresa el valor descrito.
    */
    public Map<String, String> getObservaciones() {
        return this.observaciones;
    }

    /**
    * Carga un recurso de archivo a base64 String.
    * @param path
    * @return String Base64
    */
    private String loadResouceAsB64(String path) {
        try {
            byte[] binaryData = Files.readAllBytes(Paths.get(path));
            return Base64.getEncoder().encodeToString(binaryData);
        } catch (IOException e) {
            return "";
        }
    }

    /**
    * Carga un recurso de archivo a String.
    * @param path
    * @return String
    */
    private String loadResourceAsString(String path) {
        try {
            byte[] binaryData = Files.readAllBytes(Paths.get(path));
            return new String(binaryData, "UTF-8").trim();
        } catch (IOException e) {
            return "";
        }
    }

    /**
    * Carga un recurso de archivo a objeto XSLT.
    * @param path
    * @return Templates
    */
    private Templates loadXslt(String path) {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource(new File(path));
        try {
            return factory.newTemplates(xslt);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
    * Obtiene la fecha actual en formato necesario para CFDI.
    * @return String
    */
    private String getDateCFDI() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        date.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
        return date.format(new Date());
    }

    /**
    * Genera un CFDI único y lo sella en caso de indicarse.
    * @param xml
    * @param signed
    * @return String
    */
    private String changeDateAndSign(String xml, boolean signed) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString().replace("-", "");
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().setAttribute("Fecha", getDateCFDI());
            doc.getDocumentElement().setAttribute("Folio", randomUUIDString + "sdk-java");
            if (signed) {
                Sign sign = new Sign();
                String cadena = sign.getCadenaOriginal(doc, cfdiXSLT);
                String sello = sign.getSign(cadena,
                        Files.readAllBytes(Paths.get("resources/CertificadosDePrueba/CSD_EKU9003173C9.key")),
                        "12345678a");
                doc.getDocumentElement().setAttribute("Sello", sello);
            }
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
    * Genera un CFDI único y lo sella en caso de indicarse.
    * @param signed
    * @return String
    */
    public String getCFDI(boolean signed) {
        return changeDateAndSign(simpleXml, signed);
    }
    
    /**
     * Genera un CFDI único y lo sella en caso de indicarse.
     * @param signed
     * @return String
     */
     public String getCFDIBig(boolean signed) {
         return changeDateAndSign(bigXml, signed);
     }

    /**
    * Genera un CFDI único y lo sella en caso de indicarse.
    * @param signed
    * @return String como Base64
    */
    public String getCFDIB64(boolean signed) {
        String cfdi = changeDateAndSign(simpleXml, signed);
        try {
            return Base64.getEncoder().encodeToString(cfdi.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
    * Genera un CFDI único en formato JSON.
    * @return String
    */
    public String getJsonCFDI() {
        Gson gson = new Gson();
        Map<String, Object> data = gson.fromJson(jsonCfdi, Map.class);
        if (data != null) {
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString().replace("-", "");
            data.put("Folio", randomUUIDString + "sdk-java");
            data.put("Fecha", getDateCFDI());
        }
        return gson.toJson(data);
    }

    /**
     * Genera un CFDI único en formato JSON.
     * @return String
     */
     public String getJsonCFDIBig() {
         Gson gson = new Gson();
         Map<String, Object> data = gson.fromJson(jsonCfdiBig, Map.class);
         if (data != null) {
             UUID uuid = UUID.randomUUID();
             String randomUUIDString = uuid.toString().replace("-", "");
             data.put("Folio", randomUUIDString + "sdk-java");
             data.put("Fecha", getDateCFDI());
         }
         return gson.toJson(data);
     }
    public String getXmlTimbrado() {
        return xmlTimbrado;
    }

    public void setXmlTimbrado(String xmlTimbrado) {
        this.xmlTimbrado = xmlTimbrado;
    }
}
