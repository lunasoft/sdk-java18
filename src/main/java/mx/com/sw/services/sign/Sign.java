package mx.com.sw.services.sign;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.helpers.ResponseHelper;
import org.apache.commons.ssl.PKCS8Key;
import org.w3c.dom.Document;

/**
 * <h1>Sign</h1> Está clase permite realizar sellado y transformacion de CFDI.
 * Para ello solicita los recursos necesarios.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class Sign {

    /**
     * Este método calcula el sello digital del CFDI utilizando la cadena original,
     * llave privada y la contraseña de la misma.
     * @param cadena
     * @param privateKey
     * @param passwordPrivateKey
     */
    public String getSign(String cadena, byte[] privateKey, String passwordPrivateKey) {
        try {
            PKCS8Key pkcs8 = new PKCS8Key(privateKey, passwordPrivateKey.toCharArray());
            java.security.PrivateKey pk = pkcs8.getPrivateKey();
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(pk);
            signature.update(cadena.getBytes("UTF-8"));
            return GeneralHelpers.encodeBase64(signature.sign());
        } catch (NoSuchAlgorithmException e) {
            return ResponseHelper.getStackError(e);
        } catch (InvalidKeyException e) {
            return ResponseHelper.getStackError(e);
        } catch (SignatureException e) {
            return ResponseHelper.getStackError(e);
        } catch (UnsupportedEncodingException e) {
            return ResponseHelper.getStackError(e);
        } catch (GeneralSecurityException e) {
            return ResponseHelper.getStackError(e);
        }
    }

    /**
     * Este método obtiene la cadena original de un XML,
     * es necesario el CFDI y el template del archivo XSLT.
     * @param xml
     * @param xslt
     */
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

    /**
     * Este método obtiene la cadena original de un XML,
     * es necesario el CFDI y el template del archivo XSLT.
     * @param xml
     * @param xslt
     */
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
