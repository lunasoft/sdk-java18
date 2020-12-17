package mx.com.sw.services.account.balance;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * AccountBalanceTest Clase para UT del servicio de AccountBalance.
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
}
