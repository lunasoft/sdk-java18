package mx.com.sw.helpers;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import mx.com.sw.services.sign.Sign;

import java.util.Base64;
import java.util.Date;

public class BuildSettings {
    private String simpleXml;
    private Templates cfdiXSLT;
    public BuildSettings() {
        try {
            simpleXml = new String(Files.readAllBytes(Paths.get("resources/file.xml")), "UTF-8");
            cfdiXSLT = loadXslt("resources/XSLT/cadenaoriginal_3_3.xslt");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String Url = "http://services.test.sw.com.mx";
    public String UrlSWServices = "https://api.test.sw.com.mx";
    public String User = "demo";
    public String Password = "123456789";
    public String CerPassword = "12345678a";
    public String Token = "T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbXB3YVZxTHdOdHAwVXY2NTdJb1hkREtXTzE3dk9pMmdMdkFDR2xFWFVPUXpTUm9mTG1ySXdZbFNja3FRa0RlYURqbzdzdlI2UUx1WGJiKzViUWY2dnZGbFloUDJ6RjhFTGF4M1BySnJ4cHF0YjUvbmRyWWpjTkVLN3ppd3RxL0dJPQ.T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbFlVcU92YUJTZWlHU3pER1kySnlXRTF4alNUS0ZWcUlVS0NhelhqaXdnWTRncklVSWVvZlFZMWNyUjVxYUFxMWFxcStUL1IzdGpHRTJqdS9Zakw2UGRiMTFPRlV3a2kyOWI5WUZHWk85ODJtU0M2UlJEUkFTVXhYTDNKZVdhOXIySE1tUVlFdm1jN3kvRStBQlpLRi9NeWJrd0R3clhpYWJrVUMwV0Mwd3FhUXdpUFF5NW5PN3J5cklMb0FETHlxVFRtRW16UW5ZVjAwUjdCa2g0Yk1iTExCeXJkVDRhMGMxOUZ1YWlIUWRRVC8yalFTNUczZXdvWlF0cSt2UW0waFZKY2gyaW5jeElydXN3clNPUDNvU1J2dm9weHBTSlZYNU9aaGsvalpQMUxrUndzK0dHS2dpTittY1JmR3o2M3NqNkh4MW9KVXMvUHhZYzVLQS9UK2E1SVhEZFJKYWx4ZmlEWDFuSXlqc2ZRYXlUQk1ldlZkU2tEdU10NFVMdHZKUURLblBxakw0SDl5bUxabDFLNmNPbEp6b3Jtd2Q1V2htRHlTdDZ6eTFRdUNnYnVvK2tuVUdhMmwrVWRCZi9rQkU9.7k2gVCGSZKLzJK5Ky3Nr5tKxvGSJhL13Q8W-YhT0uIo";

    public String Cer = loadResouceAsB64("resources/CertificadosDePrueba/CSD_EKU9003173C9.cer");
    public String Key = loadResouceAsB64("resources/CertificadosDePrueba/CSD_EKU9003173C9.key");
    public String Pfx = loadResouceAsB64("resources/CertificadosDePrueba/PFX_EKU9003173C9.pfx");
    public String Rfc = "EKU9003173C9";
    public String noCertificado = "30001000000400002434";
    public String Acuse = loadResourceAsString("resources/XmlCancelacion.xml");
    public String RelationsXML = loadResourceAsString("resources/RelationsXML.xml");

    public HashMap<String, String> observaciones = new HashMap<String, String>() {
        private static final long serialVersionUID = -5151524933396110285L;
        {
            put("Observaciones", "Entregar de 9am a 6pm");
        }
    };
    public String templateId = "cfdi33";
    public String b64Logo = "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";

    private String loadResouceAsB64(String path) {
        try {
            byte[] binaryData = Files.readAllBytes(Paths.get(path));
            return Base64.getEncoder().encodeToString(binaryData);
        } catch (IOException e) {
            return "";
        }
    }

    private String loadResourceAsString(String path) {
        try {
            byte[] binaryData = Files.readAllBytes(Paths.get(path));
            return new String(binaryData, "UTF-8");
        } catch (IOException e) {
            return "";
        }
    }

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

    private String changeDateAndSign(String xml, boolean signed) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        date.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
        String datetime;
        datetime = date.format(new Date());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try
        {  
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString().replace("-","");
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse( new InputSource( new StringReader( xml ) ) );
            doc.getDocumentElement().setAttribute("Fecha",datetime);
            doc.getDocumentElement().setAttribute("Folio",randomUUIDString+"sdk-java");
            if(signed){
                Sign sign = new Sign();
                String cadena = sign.getCadenaOriginal(doc, cfdiXSLT);
                String sello = sign.getSign(cadena, Files.readAllBytes(Paths.get("resources/CertificadosDePrueba/CSD_EKU9003173C9.key")),"12345678a");
                doc.getDocumentElement().setAttribute("Sello",sello);
            }
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCFDI(boolean signed){
        return changeDateAndSign(simpleXml, signed);
    }
    public String getCFDIB64(boolean signed){
        String cfdi = changeDateAndSign(simpleXml, signed);
        try {
            return Base64.getEncoder().encodeToString(cfdi.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}