package mx.com.sw.services.resend;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mx.com.sw.exceptions.ServicesException;

public class ResendValidation {

    public ResendValidation(List<String> correos) throws ServicesException {
        validateEmail(correos);
    }

    /**
     * Valida la lista de correos.
     * 
     * @param correos lista de correos.
     * @throws ServicesException exception en caso de error.
     */
    public void validateEmail(List<String> correos) throws ServicesException {
        if (correos != null) {
            if (correos.size() > 0 && correos.size() <= 5) {
                for (int i = 0; i <= correos.size() - 1; i++) {
                    Pattern pattern = Pattern
                            .compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
                    Matcher matcher = pattern.matcher(correos.get(i));
                    if (matcher.matches() == false) {
                        throw new ServicesException(
                                "El listado de correos no contiene un formato válido o alguno de los correos es inválido.");
                    }
                }
            }else {
                throw new ServicesException("El listado de correos está vacío o contiene más de 5 correos.");
            }
        } else {
            throw new ServicesException("El listado de correos está vacío o contiene más de 5 correos.");
        }

    }
}