package mx.com.sw.helpers;

import com.google.gson.Gson;
import com.ibm.icu.util.Calendar;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import mx.com.sw.services.sign.Sign;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sw.CadenaOriginalCfdi;

/**
 * BuildSettings
 * Clase auxiliar de UT con datos comunes.
 * @author Eduardo Mares
 * @version 0.0.0.2
 * @since 2022-05-03
 */
public class BuildSettings {
    private String simpleXml;
    private String bigXml;
    private String jsonCfdi;
    private String jsonCfdiBig;
    private String urlSW;
    private String urlSWServices;
    private String userSW;
    private String passwordSW;
    private String cerPassword;
    private String pfxPassword;
    private String tokenSW;
    private String email;
    private String cer;
    private String key;
    private String pfx;
    private String rfc;
    private String noCertificado;
    private String acuse;
    private String relationsXML;
    private String acceptRejectXML;
    private String templateId;
    private Map<String, String> observaciones;
    private String xmlTimbrado;
    private UUID uuid;
    private List<String> correo;
    private List<String> correos;

    /**
     * Constructor de la clase.
     */
    public BuildSettings() {
        try {
            simpleXml = new String(Files.readAllBytes(Paths.get("resources/file.xml")), "UTF-8");
            bigXml = new String(Files.readAllBytes(Paths.get("resources/big.xml")), "UTF-8");
            jsonCfdi = new String(Files.readAllBytes(Paths.get("resources/cfdi.json")), "UTF-8");
            jsonCfdiBig = new String(Files.readAllBytes(Paths.get("resources/big.json")), "UTF-8");
            urlSW = "http://services.test.sw.com.mx";
            urlSWServices = "https://api.test.sw.com.mx";
            // Estas credenciales solo estarán activadas para las UT,
            // deben de estar configuradas en las variables de entorno.
            userSW = System.getenv("SDKTEST_USER");
            passwordSW = System.getenv("SDKTEST_PASSWORD");
            tokenSW = System.getenv("SDKTEST_TOKEN");
            email = "unexestingemail@yopmail.com";
            cer = loadResouceAsB64("resources/CertificadosDePrueba/EKU9003173C9.cer");
            key = loadResouceAsB64("resources/CertificadosDePrueba/EKU9003173C9.key");
            pfx = loadResouceAsB64("resources/CertificadosDePrueba/EKU9003173C9.pfx");
            cerPassword = "12345678a";
            pfxPassword = "swpass";
            rfc = "EKU9003173C9";
            noCertificado = "30001000000500003416";
            acuse = loadResourceAsString("resources/XmlCancelacion.xml");
            relationsXML = loadResourceAsString("resources/RelationsXML.xml");
            acceptRejectXML = loadResourceAsString("resources/AcceptReject.xml");
            templateId = "cfdi40";
            templateId = "payment20";
            observaciones = new HashMap<String, String>();
            observaciones.put("Observaciones", "Entregar de 9am a 6pm");
            xmlTimbrado = new String(Files.readAllBytes(Paths.get("resources/file_pdf.xml")), "UTF-8");
            uuid = UUID.fromString("8d8310f8-9fcb-4c2a-af17-cb747724d208");
            correo = Arrays.asList("correo@test.com.mx");
            correos = Arrays.asList("correo@test.com.mx", "correo@test2.com.mx", "correo@test3.com.mx",
                    "correo@test4.com.mx", "correo@test5.com.mx", "correo@tes6t.com.mx");
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
    public String getPasswordPFX() {
        return this.pfxPassword;
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
    public String getXMLAcceptReject() {
        return this.acceptRejectXML;
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
     * Regresa el valor descrito.
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Regresa el valor descrito.
     */
    public List<String> getCorreo() {
        return this.correo;
    }

    /**
     * Regresa el valor descrito.
     */
    public List<String> getCorreos() {
        return this.correos;
    }

    /**
     * Carga un recurso de archivo a base64 String.
     * @param path
     * @return String Base64
     */
    private String loadResouceAsB64(String path) {
        try {
            byte[] binaryData = Files.readAllBytes(Paths.get(path));
            String cad64 = Base64.getEncoder().encodeToString(binaryData);
            return cad64;
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
     * Obtiene la fecha actual en formato necesario para CFDI.
     * @return String
     */
    private String getDateCFDI() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -1); // Restar una hora
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
        return sdf.format(calendar.getTime());
    }

    /**
     * Genera un CFDI único y lo sella en caso de indicarse.
     * @param xml
     * @param signed
     * @return String
     */
    private String changeDateAndSign(String xml, boolean signed, String version) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            String randomUUIDString = UUID.randomUUID().toString().replace("-", "");
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().setAttribute("Fecha", getDateCFDI());
            doc.getDocumentElement().setAttribute("Folio", randomUUIDString + "sdk-java");
            doc.getDocumentElement().setAttribute("NoCertificado", getNoCertificado());
            doc.getDocumentElement().setAttribute("Certificado", getCSD());
            if (signed) {
                Sign sign = new Sign();
                String cadena = getGenerateCadena(doc, version);
                String sello = sign.getSign(cadena,
                        Files.readAllBytes(Paths.get("resources/CertificadosDePrueba/EKU9003173C9.key")),
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
    public String getCFDIBig(boolean signed) {
        return changeDateAndSign(bigXml, signed, "4.0");
    }

    /**
     * Genera un CFDI único y lo sella en caso de indicarse.
     * @param signed
     * @return String como Base64
     */
    public String getCFDIB64(boolean signed) {
        String cfdi = changeDateAndSign(simpleXml, signed, "4.0");
        try {
            return Base64.getEncoder().encodeToString(cfdi.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
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
        return changeDateAndSign(simpleXml, signed, "4.0");
    }

    /**
     * Genera un CFDI especifico y lo sella en caso de indicarse.
     * @param fileName
     * @param signed
     * @param version
     * @param isBase64
     * @return String
     */
    public String getCFDI(String fileName, boolean signed, String version, boolean isBase64) {

        String xml = "";
        try {
            xml = new String(Files.readAllBytes(Paths.get(fileName)), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cfdi = changeDateAndSign(xml, signed, version);

        if (isBase64) {
            try {
                cfdi = Base64.getEncoder().encodeToString(cfdi.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return cfdi;
    }

    /**
     * Genera un CFDI especifico.
     * @param fileName
     * @param isBase64
     * @return String
     */
    public String getJsonCFDI(String fileName, boolean isBase64) {

        Gson gson = new Gson();
        String xml = "";
        try {
            xml = new String(Files.readAllBytes(Paths.get(fileName)), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> data = gson.fromJson(xml, Map.class);
        if (data != null) {
            String randomUUIDString = UUID.randomUUID().toString().replace("-", "");
            data.put("Folio", randomUUIDString + "sdk-java");
            data.put("Fecha", getDateCFDI());
        }

        if (isBase64) {
            try {
                return Base64.getEncoder().encodeToString(gson.toJson(data).getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return gson.toJson(data);
    }

    /**
     * Genera un CFDI único en formato JSON.
     * @return String
     */
    public String getJsonCFDI() {
        Gson gson = new Gson();
        Map<String, Object> data = gson.fromJson(jsonCfdi, Map.class);
        if (data != null) {
            String randomUUIDString = UUID.randomUUID().toString().replace("-", "");
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
            String randomUUIDString = UUID.randomUUID().toString().replace("-", "");
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

    private String getGenerateCadena(Document xml, String version) {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(bout);
            DOMSource source = new DOMSource(xml);
            transformer.transform(source, result);

            return CadenaOriginalCfdi.getCadenaOriginal(bout.toByteArray(), version);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
