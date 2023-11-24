package mx.com.sw.services.account.balance;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.account.balance.responses.AccountActionsData;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * AccountBalanceTest Clase para UT del servicio de AccountBalance.
 * 
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-14
 */
public class AccountBalanceTest {
    private final BuildSettings settings;

    /**
     * Constructor de la clase.
     */
    public AccountBalanceTest() {
        this.settings = new BuildSettings();
    }
    

    /**
    * Método de UT con usuario y password.
    */
    @Test
    public void testGetBalance() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getUserSW(),
                settings.getPasswordSW(), null, 0);
            AccountBalanceResponse res = account.getBalance();
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getSaldoTimbres() > 0);
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT con token.
    */
    @Test
    public void testGetBalanceToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            AccountBalanceResponse res = account.getBalance();
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getSaldoTimbres() > 0);
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT con token incorrecto.
    */
    @Test
    public void testGetBalanceBadToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), "empty.token.sw", null, 0);
            AccountBalanceResponse res = account.getBalance();
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    /**
     * Método para obtener el saldo con usuario y password.
     */
    @Test
    public void testGetBalanceById() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getUrlServicesSW(),
                    settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            AccountBalanceResponse res = account
                    .getBalanceById(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"));
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getSaldoTimbres() > 0);
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método para obtener el saldo con token.
     */
    @Test
    public void testGetBalanceByIdByToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountBalanceResponse res = account
                    .getBalanceById(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"));
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getSaldoTimbres() > 0);
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método para obtener el saldo con token incorrecto.
     */
    @Test
    public void testGetBalanceByIdBadToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountBalanceResponse res = account
                    .getBalanceById(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"));
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT AgregarTimbres con token incorrecto.
     */
    @Test
    public void testAddStampsBadToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountActionsData res = account
                    .addStamps(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT AgregarTimbres con token correcto.
     */
    @Test
    public void testAddStampsByToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountActionsData res = account
                    .addStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT AgregarTimbres con Autenticacion.
     */
    @Test
    public void testAddStampsByAuth() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getUrlServicesSW(),
                    settings.getUserSW(), settings.getPasswordSW(), null, 0);
            AccountActionsData res = account
                    .addStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT AgregarTimbres con Autenticacion.
     */
    @Test
    public void testAddStampsError() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getUrlServicesSW(),
                    settings.getUserSW(), settings.getPasswordSW(), null, 0);
            AccountActionsData res = account
                    .addStamps(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertNotNull(res.getMessageDetail());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    /**
     * Método de UT EliminarTimbres con token incorrecto.
     */
    @Test
    public void testRemoveStampsBadToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountActionsData res = account
                    .removeStamps(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT EliminarTimbres con token correcto.
     */
    @Test
    public void testRemoveStampsByToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountActionsData res = account
                    .removeStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
     /**
     * Método de UT EliminarTimbres con token correcto.
     */
    @Test
    public void testRemoveStampsSaldoInsuficiente() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountActionsData res = account
                    .removeStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 2000000000, "Prueba");
             Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertNotNull(res.getMessageDetail());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT EliminarTimbres con Autenticacion.
     */
    @Test
    public void testRemoveStampsByAuth() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getUrlServicesSW(),
                    settings.getUserSW(), settings.getPasswordSW(), null, 0);
            AccountActionsData res = account
                    .removeStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT EliminarTimbres error
     */
    @Test
    public void testRemoveStampsError() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getUrlServicesSW(),
                    settings.getUserSW(), settings.getPasswordSW(), null, 0);
            AccountActionsData res = account
                    .removeStamps(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertNotNull(res.getMessageDetail());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

}
