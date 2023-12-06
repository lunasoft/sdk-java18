package mx.com.sw.services.account.info;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.account.info.responses.AccountListDataResponse;
import mx.com.sw.services.account.info.responses.AccountInfoActionResponse;
import mx.com.sw.services.account.info.responses.AccountInfoData;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

import java.util.Collections;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * AccountInfoTest Clase para UT del servicio de AccountInfo.
 * 
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

    /**
     * Método de UT con ID.
     */
    @Test
    public void testGetInfoUserId() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.getInfoById("32501cf2-dc62-4370-b47d-25024c44e131");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getTokenAccess());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT con ID Incorrecto.
     */
    @Test
    public void testGetInfoUserIdError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.getInfoById("32501cf2-dc62-4370-b47d-25024c44e130");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT Para obtener la info de todos los usuarios.
     */
    @Test
    public void testGetInfoAllUsers() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountListDataResponse res = account.getAllUsers(1, 2);
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT Para obtener la info de todos los usuarios error, Token incorrecto.
     */

    @Test
    public void testGetInfoAllUsersError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountListDataResponse res = account.getAllUsers(1, 2);
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT Para crear un usuario.
     */

    @Test
    public void testGetInfoCreateUser() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.getCreateUser("correoPrueba@java18.com", "123abcABC..", "PruebaJava18",
                    "XAXX010101000", 3, 0, false, true);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT Para crear un usuario error (Ya existe).
     */

    @Test
    public void testGetInfoCreateUserError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountInfoActionResponse res = account.getCreateUser("correoPrueba@java18.com", "123abcABC..", "PruebaJava18",
                    "XAXX010101000", 3, 0, false, true);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT Para eliminar un usuario.
     */

    @Test
    public void testGetInfoDeleteUserId() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.getDeleteIdUser("cda85126-30a3-469c-8051-5fc21b37f9aa");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT Para eliminar un usuario error.
     */

    @Test
    public void testGetInfoDeleteUserIdError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.getDeleteIdUser("cda85126-30a3-469c-8051-5fc21b37f9aa");
            System.out.println(res.toString());
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}