package mx.com.sw.services.account.info;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * AccountInfoTest Clase para UT del servicio de AccountInfo.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public class AccountInfoTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public AccountInfoTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT con token.
    */
    @Test
    public void testGetInfoToken() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.getInfo();
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getTokenAccess());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT con token incorrecto.
    */
    @Test
    public void testGetInfoBadToken() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountInfoResponse res = account.getInfo();
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
