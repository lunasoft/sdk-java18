package mx.com.sw.services.cancelation;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.helpers.GeneralValidations;
import org.apache.commons.codec.binary.Base64;

public class CancelationValidation extends GeneralValidations {

    public CancelationValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
    }
    public void ValidateRequestCSD(String csd, String key, String password, String uuid) throws ServicesException
    {
        ValidateString(uuid, "Faltan especificar el UUID a Cancelar", false, null);
        ValidateString(csd, "Falta Capturar el Certificado", true, "Certificado");
        ValidateString(key, "Falta Capturar Key del Certificado", true, "Key");
        ValidateString(password, "Falta Capturar Contraseña del Certificado", false, null);
    }
    public void ValidateRequestPFX(String pfx, String password, String uuid) throws ServicesException
    {
        ValidateString(uuid, "Faltan especificar el UUID a Cancelar", false, null);
        ValidateString(pfx, "Falta Capturar el Certificado PFX", true, "PFX");
        ValidateString(password, "Falta Capturar Contraseña del Certificado", false, null);
    }
    public void ValidateRequestUUID(String rfc, String uuid) throws ServicesException
    {
        ValidateString(uuid, "Faltan especificar el UUID a Cancelar", false, null);
        ValidateString(rfc, "Falta Capturar el RFC emisor", false, null);
    }
    public void ValidateRequestXML(String xml) throws ServicesException
    {
        ValidateString(xml, "Faltan especificar el XML de cancelacion", false, null);
    }
    private void ValidateIsBase64(String key, String value) throws ServicesException
    {
        if(!Base64.isBase64(value)){
            throw new ServicesException("El valor " + key + " no es Base64");
        }
    }
    private void ValidateString(String value, String errorDescription, boolean b64, String parameterName) throws ServicesException {
        if (GeneralHelpers.stringEmptyOrNull(value))
        {
            throw new ServicesException(errorDescription);
        }
        if(b64){
            ValidateIsBase64(parameterName, value);
        }
    }
}