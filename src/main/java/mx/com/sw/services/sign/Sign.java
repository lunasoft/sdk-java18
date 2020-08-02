package mx.com.sw.services.sign;

import java.io.StringReader;
import java.io.StringWriter;
import java.security.Signature;

import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.ssl.PKCS8Key;
import org.w3c.dom.Document;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.helpers.ResponseHelper;

public class Sign {

    public String getSign(String cadena, byte[] privateKey, String passwordPrivateKey){
        try {
            PKCS8Key pkcs8 = new PKCS8Key(privateKey, passwordPrivateKey.toCharArray());
            java.security.PrivateKey pk = pkcs8.getPrivateKey();
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(pk);
            signature.update(cadena.getBytes("UTF-8"));
            return GeneralHelpers.encodeBase64(signature.sign());
        }catch (Exception e){
            return ResponseHelper.getStackError(e);
        }
    }
    
    public String getCadenaOriginal(String xml, Templates xslt) {
        try {
            Transformer transformer = xslt.newTransformer();
            StreamSource xmlSource = new StreamSource(new StringReader(xml));
            StringWriter outWriter = new StringWriter();
            StreamResult result = new StreamResult(outWriter);
            transformer.transform(xmlSource, result);
            StringBuffer sb = outWriter.getBuffer();
            return sb.toString();
        } catch (TransformerConfigurationException e) {
            return ResponseHelper.getStackError(e);
        } catch (TransformerException e) {
            return ResponseHelper.getStackError(e);
        }
    }
    public String getCadenaOriginal(Document xml, Templates xslt) {
        try {
            Transformer transformer = xslt.newTransformer();
            DOMSource xmlSource = new DOMSource(xml);
            StringWriter outWriter = new StringWriter();
            StreamResult result = new StreamResult(outWriter);
            transformer.transform(xmlSource, result);
            StringBuffer sb = outWriter.getBuffer();
            return sb.toString();
        } catch (TransformerConfigurationException e) {
            return ResponseHelper.getStackError(e);
        } catch (TransformerException e) {
            return ResponseHelper.getStackError(e);
        }
    }
}