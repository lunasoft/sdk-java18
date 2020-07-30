package mx.com.sw.services.authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import mx.com.sw.services.authentication.responses.AuthenticationResponse;

public class AuthenticationTest {
    @Test
    public void testAuthenticate(){
        try {
            Authentication auth = new Authentication("http://services.test.sw.com.mx", "demo", "123456789", null, 0);
            AuthenticationResponse res = auth.authenticate();
            assertNotNull(res);
            assertNotNull(res.data);
            assertNotNull(res.data.token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            //fail
            assertEquals(1, 0);
        }
    }
    @Test
    public void testBadAuth(){
        try {
        	Authentication auth = new Authentication("http://services.test.sw.com.mx", "demo", "badpwd", null, 0);
            AuthenticationResponse res = auth.authenticate();
            assertNotNull(res);
            assertNotNull(res.message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            //fail
            assertEquals(1, 0);
        }
    }
}