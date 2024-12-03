package mx.com.sw.services.account.info;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;
import mx.com.sw.services.account.info.responses.AccountInfoActionResponse;
import mx.com.sw.services.account.info.responses.AccountInfoData;
import mx.com.sw.services.account.info.responses.AccountListDataResponse;
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
     * Método de UT Para crear un usuario.
     */
    @Test
    public void testCreateUser() {
        try {
            Random random = new Random();
            int randomFourDigitNumber = random.nextInt(9000) + 1000;
            String correoPrueba = "correoPrueba" + randomFourDigitNumber + "@java18.com";

            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.createUser(correoPrueba, "123abcABC..", "PruebaJava18",
                    "XAXX010101000", 1, false, "correo@notification.com", "3920000000");
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
            AccountInfoResponse res = account.createUser("correoPrueba@java18.com", "123abcABC..", "PruebaJava18",
                    "XAXX010101000", 1, false, "correo@notification.com", "3920000000");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT Para crear un usuario.
     */
    @Test
    public void testUpdateUser() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.updateUser(UUID.fromString("be2a859c-cd5f-42b5-b35d-f065b3a9aac4"),
                    "PruebaAct Java 18", "RAQÑ7701212M3", "nuevoEmail@notification.com",
                    "9820000000", false);
            Assertions.assertNotNull(res);
            Assertions.assertTrue(res.getStatus().equals("success") || res.getMessage()
                    .equals("No es posible actualizar, los datos enviados son identicos a los actuales"));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT Para crear un usuario error (Ya existe).
     */
    @Test
    public void testUpdateUserError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            AccountInfoActionResponse res = account.updateUser(UUID.fromString("be2a859c-cd5f-42b5-b35d-f065b3a9aac4"),
                    "PruebaAct Java 18", "XAXX010101000..", "nuevoEmail@notification.com",
                    "9820000000", false);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
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
            AccountListDataResponse res = account.getUserById("32501cf2-dc62-4370-b47d-25024c44e131");
            Assertions.assertNotNull(res);
            List<AccountInfoData> lista = res.getData();
		if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
				AccountInfoData dato = lista.get(i);
				System.out.println("Email: " + dato.getEmail());
				System.out.println("Nombre: " + dato.getName());
				System.out.println("Perfil: " + dato.getProfile());
				System.out.println("Stamps: " + dato.getStamps());
				System.out.println("idUsuario: " + dato.getIdUser());
				System.out.println("Rfc: " + dato.getTaxId());
				System.out.println("Ilimitado: " + dato.isUnlimited());
				System.out.println("Activo: " + dato.isActive() + "\n");
			}
		}
            Assertions.assertTrue("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    @Test
    public void testGetInfoUserRfc() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountListDataResponse res = account.getUsersByRfc("EKU9003173C9");
            Assertions.assertNotNull(res);
            List<AccountInfoData> lista = res.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    AccountInfoData dato = lista.get(i);
                    System.out.println("Email: " + dato.getEmail());
                    System.out.println("Nombre: " + dato.getName());
                    System.out.println("Perfil: " + dato.getProfile());
                    System.out.println("Stamps: " + dato.getStamps());
                    System.out.println("idUsuario: " + dato.getIdUser());
                    System.out.println("Rfc: " + dato.getTaxId());
                    System.out.println("Ilimitado: " + dato.isUnlimited());
                    System.out.println("Activo: " + dato.isActive() + "\n");
                }
            }
            Assertions.assertTrue("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetInfoUserEmail() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountListDataResponse res = account.getUsersByEmail(settings.getEmail());
            Assertions.assertNotNull(res);
            List<AccountInfoData> lista = res.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    AccountInfoData dato = lista.get(i);
                    System.out.println("Email: " + dato.getEmail());
                    System.out.println("Nombre: " + dato.getName());
                    System.out.println("Perfil: " + dato.getProfile());
                    System.out.println("Stamps: " + dato.getStamps());
                    System.out.println("idUsuario: " + dato.getIdUser());
                    System.out.println("Rfc: " + dato.getTaxId());
                    System.out.println("Ilimitado: " + dato.isUnlimited());
                    System.out.println("Activo: " + dato.isActive() + "\n");
                }
            }
            Assertions.assertTrue("success".equals(res.getStatus())||res.getData().isEmpty());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetInfoUserActives() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountListDataResponse res = account.getUsersActivate(true);
            Assertions.assertNotNull(res);
            List<AccountInfoData> lista = res.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    AccountInfoData dato = lista.get(i);
                    System.out.println("Email: " + dato.getEmail());
                    System.out.println("Nombre: " + dato.getName());
                    System.out.println("Perfil: " + dato.getProfile());
                    System.out.println("Stamps: " + dato.getStamps());
                    System.out.println("idUsuario: " + dato.getIdUser());
                    System.out.println("Rfc: " + dato.getTaxId());
                    System.out.println("Ilimitado: " + dato.isUnlimited());
                    System.out.println("Activo: " + dato.isActive() + "\n");
                }
            }
            Assertions.assertTrue("success".equals(res.getStatus())||res.getData().isEmpty());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    @Test
    public void testGetInfoUserNoActives() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountListDataResponse res = account.getUsersActivate(false);
            Assertions.assertNotNull(res);
            List<AccountInfoData> lista = res.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    AccountInfoData dato = lista.get(i);
                    System.out.println("Email: " + dato.getEmail());
                    System.out.println("Nombre: " + dato.getName());
                    System.out.println("Perfil: " + dato.getProfile());
                    System.out.println("Stamps: " + dato.getStamps());
                    System.out.println("idUsuario: " + dato.getIdUser());
                    System.out.println("Rfc: " + dato.getTaxId());
                    System.out.println("Ilimitado: " + dato.isUnlimited());
                    System.out.println("Activo: " + dato.isActive() + "\n");
                }
            }
            Assertions.assertTrue("success".equals(res.getStatus())||res.getData().isEmpty());
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
            AccountListDataResponse res = account.getUserById("32501cf2-dc62-4370-b47d-25024c44e130");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus())||res.getData().isEmpty());
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
            AccountListDataResponse res = account.getAllUsers();
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(res.getStatus()));
            List<AccountInfoData> lista = res.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    AccountInfoData dato = lista.get(i);
                    System.out.println("Email: " + dato.getEmail());
                    System.out.println("Nombre: " + dato.getName());
                    System.out.println("Perfil: " + dato.getProfile());
                    System.out.println("Stamps: " + dato.getStamps());
                    System.out.println("idUsuario: " + dato.getIdUser());
                    System.out.println("Rfc: " + dato.getTaxId());
                    System.out.println("Ilimitado: " + dato.isUnlimited());
                    System.out.println("Activo: " + dato.isActive() + "\n");
                }
            }
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
            AccountListDataResponse res = account.getAllUsers();
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(res.getStatus()));
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
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.deleteIdUser("dec88273-6587-4f1e-9673-317b30e07aab");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus())|| res.getMessage().equals("El usuario ya ha sido previamente removido"));
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
