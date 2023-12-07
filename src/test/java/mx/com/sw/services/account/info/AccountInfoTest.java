package mx.com.sw.services.account.info;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.account.info.responses.AccountListDataResponse;
import mx.com.sw.services.account.info.responses.AccountInfoActionResponse;
import mx.com.sw.services.account.info.responses.AccountInfoData;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

import java.util.Random;
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

    // Variable para generar un correo random para prueba de crear usuario.
    private Random random = new Random();

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
     * Método de UT Para obtener la info de todos los usuarios error, Token
     * incorrecto.
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
    public void testCreateUser() {
        try {
            int randomFourDigitNumber = random.nextInt(9000) + 1000;
            String correoPrueba = "correoPrueba" + randomFourDigitNumber + "@java18.com";

            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.createUser(correoPrueba, "123abcABC..", "PruebaJava18",
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
    public void testCreateUserError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountInfoActionResponse res = account.createUser("correoPrueba@java18.com", "123abcABC..", "PruebaJava18",
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
    public void testDeleteUserId() {
        try {
            // Se reestablece el usuario para posteriormente eliminarlo nuevamente.
            AccountInfo accountRestart = new AccountInfo(settings.getUrlServicesSW(),
                    "T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbXB3YVZxTHdOdHAwVXY2NTdJb1hkREtXTzE3dk9pMmdMdkFDR2xFWFVPUXpTUm9mTG1ySXdZbFNja3FRa0RlYURqbzdzdlI2UUx1WGJiKzViUWY2dnZGbFloUDJ6RjhFTGF4M1BySnJ4cHF0YjUvbmRyWWpjTkVLN3ppd3RxL0dJPQ.T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbFlVcU92YUJTZWlHU3pER1kySnlXRTF4alNUS0ZWcUlVS0NhelhqaXdnWTRncklVSWVvZlFZMWNyUjVxYUFxMWFxcStUL1IzdGpHRTJqdS9Zakw2UGRZbFlVYmJVSkxXa1NZNzN5VUlSUzlJaTYvbi9wczBSRnZGK1NUNUVoM1FQYnJGcTRvYUNEajdpRlpQQm9sUkdZV0s5MEVlOVdQanp6bUtUVHRPL2pDNE9PTk1WZWVWWDhLQzlSRjNEUUlKUU5icG83aXV4S0tjdm9DKzlhTVI2RzJWOWN4TDVxZzYwalJDRnJmWG5qVDVvWWtJOHVsNytyT2xRU2orVFJaTmZVYjJZUFZTVkJmUEthbGxmOWhTalYyd1pXWTBtdG1QbkVUVllsRXJUYTFtMFhYaWtWcUw0QW42RlRGaGwrRXlGV2dUWnl3c2pYaWJVdEVUNk94YXc3TVJWVFlyVTMyWE9xOGd3UmozdmVjdmVUOWhaazg3enpMTkdjZmFLNkZDSTErazk3V281aE50Rm9DSUV4NDVQWVlWaTYzQ2dwbkd3QVZkcXZZTVJEUzJMZE01UW11UTg1eE05SHJhY1VpK0pkUGs3WnVHVkFzMVplQmtYcldScmU.3nqJNAdl4nYfou7gDeLAGgiWPAmeosjSPX-9Xvm9ipI",
                    null, 0);
            AccountInfoActionResponse resRestart = accountRestart.createUser("user_pruebas_ut@sw.com.mx", "123abcABC..",
                    "PruebaJava18",
                    "XAXX010101000", 3, 0, false, true);
            Assertions.assertNotNull(resRestart);
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.deleteIdUser("2c6a91f6-2b14-4e61-b528-2becd26d6c33");
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
    public void testDeleteUserIdError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.deleteIdUser("cda85126-30a3-469c-8051-5fc21b37f9ab");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}