package mx.com.sw.services.account.balance;

import java.util.UUID;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.account.balance.responses.AccountBalanceActionResponse;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;

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
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getUrlServicesSW(),
                    settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            AccountBalanceResponse res = account.getBalance();
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getStampsBalance() > 0);
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
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountBalanceResponse response = account.getBalance();
            Assertions.assertNotNull(response);
            Assertions.assertTrue("success".equals(response.getStatus()));
            Assertions.assertNotNull(response.getData());
            System.out.println("Estado: " + response.getStatus());
            System.out.println("ID Usuario: " + response.getData().getIdUser());
            System.out.println("ID Balance Usuario: " + response.getData().getIdUserBalance());
            System.out.println("Stamps Asignados: " + response.getData().getStampsAssigned());
            System.out.println("Stamps Usados: " + response.getData().getStampsUsed());
            System.out.println("Saldo Stamps: " + response.getData().getStampsBalance());
            System.out.println("Es Ilimitado: " + response.getData().isUnlimited());
            System.out.println("Fecha Expiración: " + response.getData().getExpirationDate());
            if (response.getData().getLastTransaction() != null) {
                System.out.println("Folio: " + response.getData().getLastTransaction().getFolio());
                System.out.println("ID Usuario: " + response.getData().getLastTransaction().getIdUser());
                System.out
                        .println("ID Usuario Receptor: " + response.getData().getLastTransaction().getIdUserReceiver());
                System.out.println("Nombre Receptor: " + response.getData().getLastTransaction().getNameReceiver());
                System.out.println("Stamps In: "
                        + (response.getData().getLastTransaction().getStampsIn() != null
                                ? response.getData().getLastTransaction().getStampsIn()
                                : "null"));
                System.out.println("Stamps Out: "
                        + (response.getData().getLastTransaction().getStampsOut() != null
                                ? response.getData().getLastTransaction().getStampsOut()
                                : "null"));
                System.out.println("Stamps Current: "
                        + (response.getData().getLastTransaction().getStampsCurrent() != null
                                ? response.getData().getLastTransaction().getStampsCurrent()
                                : "null"));
                System.out.println("Comentario: " + response.getData().getLastTransaction().getComment());
                System.out.println("Fecha: " + response.getData().getLastTransaction().getDate());
                System.out.println("Email Enviado: " +
                        (response.getData().getLastTransaction().isEmailSent() ? "Sí" : "No"));

            } else {
                System.out.println("No hay transacción registrada.");
            }

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
     * Método de UT AgregarTimbres con token incorrecto.
     */
    @Test
    public void testAddStampsBadToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountBalanceActionResponse res = account
                    .addStamps(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"), 1, "Prueba");
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
            AccountBalanceActionResponse res = account
                    .addStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 1, "Prueba");
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
            AccountBalanceActionResponse res = account
                    .addStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 1, "Prueba");
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
            AccountBalanceActionResponse res = account
                    .addStamps(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"), 1, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getMessage());
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
            AccountBalanceActionResponse res = account
                    .removeStamps(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"), 1, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT EliminarTimbres con token correcto.
     */
    // @Disabled("No quitar/agregar timbres de la cuenta de pruebas")
    @Test
    public void testRemoveStampsByToken() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountBalanceActionResponse res = account
                    .removeStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 1, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT EliminarTimbres con token correcto.
     */
    // @Disabled("No quitar/agregar timbres de la cuenta de pruebas")
    @Test
    public void testRemoveStampsSaldoInsuficiente() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountBalanceActionResponse res = account
                    .removeStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 2000000000, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getMessage());
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
            AccountBalanceActionResponse res = account
                    .removeStamps(UUID.fromString("828f19b1-77dc-48bc-9cfa-d48b5cf7e30c"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT EliminarTimbres error.
     */
    @Test
    public void testRemoveStampsError() {
        try {
            AccountBalance account = new AccountBalance(settings.getUrlSW(), settings.getUrlServicesSW(),
                    settings.getUserSW(), settings.getPasswordSW(), null, 0);
            AccountBalanceActionResponse res = account
                    .removeStamps(UUID.fromString("24419cba-1bd4-4a46-8244-2ae02f6dc15e"), 5, "Prueba");
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getMessage());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
