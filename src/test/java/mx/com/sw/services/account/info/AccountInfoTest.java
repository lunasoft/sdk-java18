package mx.com.sw.services.account.info;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.account.info.responses.AccountListDataResponse;
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

    @Test
    public void testGetInfoUserId() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.getInfoById("04703168-bb4f-463a-8527-f586459ee6ab");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getTokenAccess());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetInfoUserIdError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.getInfoById("04703168-bb4f-463a-8527-f586459ee6ac");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Ignore
    public void testGetInfoAllUsers() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(),
                    settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.getInfoAllUsers(1, 2);
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(res.getStatus()));
            List<AccountInfoData> lista = res.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    AccountInfoData dato = lista.get(i);
                    System.out.println(dato.getStamps());
                    System.out.println(dato.getIdCliente());
                    System.out.println(dato.getEmail());

                }
            }
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetInfoAllUsersError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(),
                    settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.getInfoAllUsers(1, 2);
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Ignore
    public void testGetInfoCreateUser() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(),
                    "T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbXB3YVZxTHdOdHAwVXY2NTdJb1hkREtXTzE3dk9pMmdMdkFDR2xFWFVPUXpTUm9mTG1ySXdZbFNja3FRa0RlYURqbzdzdlI2UUx1WGJiKzViUWY2dnZGbFloUDJ6RjhFTGF4M1BySnJ4cHF0YjUvbmRyWWpjTkVLN3ppd3RxL0dJPQ.T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbFlVcU92YUJTZWlHU3pER1kySnlXRTF4alNUS0ZWcUlVS0NhelhqaXdnWTRncklVSWVvZlFZMWNyUjVxYUFxMWFxcStUL1IzdGpHRTJqdS9Zakw2UGQxNldGQmdOTDl2YVRRQ2VXV2o2djBoSUNhY2V4U1UzSWxJUUpIUkI3YVZ4T0FuK2ppYk41NUplRWIyU3dSZjJ3S3BuQzZEdTcrc0hLaE9maFRQRk5ua1Eza213UFdyWnpXelVXeW1mNHg5TVJibWQ1U0c1TmZzcmxLR2FweWhPRm41dms1bFhYeE1sNmU2Y2xCSE44bHhjUWFkSndCVktoVmNuSlZQV2xsb2R5NDBXOHFKV2trejVqckduaW96OGducUUxZHNVaThITnNrdHNUdG9vMWlnTGE0OFdqanBoeE5KSlJVU0MwVzZ5clV1a0RXa2EzUGp5dHBxWUttWmJpOXRjWHQwTk4rV1BhME1ycGRsaDI3QWkxb1FZVXJJUDZ1cmcwdFFuNTBLQXFnV3BkcFF3QTE4UE1YQWVqQ2RpeHRYemU4cG5tREF3anZWNndQei9MclBwb0dBMFUxVk5lSURWVVEvbmZUS0J0MGEraTE0Vlp2TGpCQjR1ZzY3ZWY.x-_tT440WX6B3Jzp_JpKcy9VZNT28rN7gwxozBhBEU4",
                    null, 0);
            AccountInfoResponse res = account.getInfoCreateUser("correo@java18_11.com", "123abcABC..", "TestJava18_4",
                    "READ891225217", 3, 0, false, true);
            System.out.println(res);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getTokenAccess());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetInfoCreateUserError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(),
                    "T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbXB3YVZxTHdOdHAwVXY2NTdJb1hkREtXTzE3dk9pMmdMdkFDR2xFWFVPUXpTUm9mTG1ySXdZbFNja3FRa0RlYURqbzdzdlI2UUx1WGJiKzViUWY2dnZGbFloUDJ6RjhFTGF4M1BySnJ4cHF0YjUvbmRyWWpjTkVLN3ppd3RxL0dJPQ.T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbFlVcU92YUJTZWlHU3pER1kySnlXRTF4alNUS0ZWcUlVS0NhelhqaXdnWTRncklVSWVvZlFZMWNyUjVxYUFxMWFxcStUL1IzdGpHRTJqdS9Zakw2UGQxNldGQmdOTDl2YVRRQ2VXV2o2djBoSUNhY2V4U1UzSWxJUUpIUkI3YVZ4T0FuK2ppYk41NUplRWIyU3dSZjJ3S3BuQzZEdTcrc0hLaE9maFRQRk5ua1Eza213UFdyWnpXelVXeW1mNHg5TVJibWQ1U0c1TmZzcmxLR2FweWhPRm41dms1bFhYeE1sNmU2Y2xCSE44bHhjUWFkSndCVktoVmNuSlZQV2xsb2R5NDBXOHFKV2trejVqckduaW96OGducUUxZHNVaThITnNrdHNUdG9vMWlnTGE0OFdqanBoeE5KSlJVU0MwVzZ5clV1a0RXa2EzUGp5dHBxWUttWmJpOXRjWHQwTk4rV1BhME1ycGRsaDI3QWkxb1FZVXJJUDZ1cmcwdFFuNTBLQXFnV3BkcFF3QTE4UE1YQWVqQ2RpeHRYemU4cG5tREF3anZWNndQei9MclBwb0dBMFUxVk5lSURWVVEvbmZUS0J0MGEraTE0Vlp2TGpCQjR1ZzY3ZWY.x-_tT440WX6B3Jzp_JpKcy9VZNT28rN7gwxozBhBEU4",
                    null, 0);
            AccountInfoResponse res = account.getInfoCreateUser("correo@java18_11.com", "123abcABC..", "TestJava18_4",
                    "READ891225217", 3, 0, false, true);
            System.out.println(res);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Ignore
    public void testGetInfoDeleteUserId() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(),
                    "T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbXB3YVZxTHdOdHAwVXY2NTdJb1hkREtXTzE3dk9pMmdMdkFDR2xFWFVPUXpTUm9mTG1ySXdZbFNja3FRa0RlYURqbzdzdlI2UUx1WGJiKzViUWY2dnZGbFloUDJ6RjhFTGF4M1BySnJ4cHF0YjUvbmRyWWpjTkVLN3ppd3RxL0dJPQ.T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbFlVcU92YUJTZWlHU3pER1kySnlXRTF4alNUS0ZWcUlVS0NhelhqaXdnWTRncklVSWVvZlFZMWNyUjVxYUFxMWFxcStUL1IzdGpHRTJqdS9Zakw2UGQxNldGQmdOTDl2YVRRQ2VXV2o2djBoSUNhY2V4U1UzSWxJUUpIUkI3YVZ4T0FuK2ppYk41NUplRWIyU3dSZjJ3S3BuQzZEdTcrc0hLaE9maFRQRk5ua1Eza213UFdyWnpXelVXeW1mNHg5TVJibWQ1U0c1TmZzcmxLR2FweWhPRm41dms1bFhYeE1sNmU2Y2xCSE44bHhjUWFkSndCVktoVmNuSlZQV2xsb2R5NDBXOHFKV2trejVqckduaW96OGducUUxZHNVaThITnNrdHNUdG9vMWlnTGE0OFdqanBoeE5KSlJVU0MwVzZ5clV1a0RXa2EzUGp5dHBxWUttWmJpOXRjWHQwTk4rV1BhME1ycGRsaDI3QWkxb1FZVXJJUDZ1cmcwdFFuNTBLQXFnV3BkcFF3QTE4UE1YQWVqQ2RpeHRYemU4cG5tREF3anZWNndQei9MclBwb0dBMFUxVk5lSURWVVEvbmZUS0J0MGEraTE0Vlp2TGpCQjR1ZzY3ZWY.x-_tT440WX6B3Jzp_JpKcy9VZNT28rN7gwxozBhBEU4",
                    null, 0);
            AccountInfoResponse res = account.getInfoDeleteIdUser("89F589F4-C365-4AF9-8F49-B7BB5D036552");
            System.out.println(res.toString());
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getTokenAccess());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetInfoDeleteUserIdError() {
        try {
            AccountInfo account = new AccountInfo(settings.getUrlServicesSW(),
                    "T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbXB3YVZxTHdOdHAwVXY2NTdJb1hkREtXTzE3dk9pMmdMdkFDR2xFWFVPUXpTUm9mTG1ySXdZbFNja3FRa0RlYURqbzdzdlI2UUx1WGJiKzViUWY2dnZGbFloUDJ6RjhFTGF4M1BySnJ4cHF0YjUvbmRyWWpjTkVLN3ppd3RxL0dJPQ.T2lYQ0t4L0RHVkR4dHZ5Nkk1VHNEakZ3Y0J4Nk9GODZuRyt4cE1wVm5tbFlVcU92YUJTZWlHU3pER1kySnlXRTF4alNUS0ZWcUlVS0NhelhqaXdnWTRncklVSWVvZlFZMWNyUjVxYUFxMWFxcStUL1IzdGpHRTJqdS9Zakw2UGQxNldGQmdOTDl2YVRRQ2VXV2o2djBoSUNhY2V4U1UzSWxJUUpIUkI3YVZ4T0FuK2ppYk41NUplRWIyU3dSZjJ3S3BuQzZEdTcrc0hLaE9maFRQRk5ua1Eza213UFdyWnpXelVXeW1mNHg5TVJibWQ1U0c1TmZzcmxLR2FweWhPRm41dms1bFhYeE1sNmU2Y2xCSE44bHhjUWFkSndCVktoVmNuSlZQV2xsb2R5NDBXOHFKV2trejVqckduaW96OGducUUxZHNVaThITnNrdHNUdG9vMWlnTGE0OFdqanBoeE5KSlJVU0MwVzZ5clV1a0RXa2EzUGp5dHBxWUttWmJpOXRjWHQwTk4rV1BhME1ycGRsaDI3QWkxb1FZVXJJUDZ1cmcwdFFuNTBLQXFnV3BkcFF3QTE4UE1YQWVqQ2RpeHRYemU4cG5tREF3anZWNndQei9MclBwb0dBMFUxVk5lSURWVVEvbmZUS0J0MGEraTE0Vlp2TGpCQjR1ZzY3ZWY.x-_tT440WX6B3Jzp_JpKcy9VZNT28rN7gwxozBhBEU4",
                    null, 0);
            AccountInfoResponse res = account.getInfoDeleteIdUser("89F589F4-C365-4AF9-8F49-B7BB5D036552");
            System.out.println(res.toString());
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
