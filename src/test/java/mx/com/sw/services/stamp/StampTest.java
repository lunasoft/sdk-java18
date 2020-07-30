package mx.com.sw.services.stamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

public class StampTest {
    private BuildSettings settings;
    public StampTest(){
        this.settings = new BuildSettings();
    }

    @Test
    public void testStampV1(){
        Stamp stamp = new Stamp(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDI();
        StampResponseV1 response = stamp.TimbrarV1(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV2(){
        Stamp stamp = new Stamp(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDI();
        StampResponseV2 response = stamp.TimbrarV2(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV3(){
        Stamp stamp = new Stamp(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDI();
        StampResponseV3 response = stamp.TimbrarV3(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV4(){
        Stamp stamp = new Stamp(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDI();
        StampResponseV4 response = stamp.TimbrarV4(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV1B64(){
        Stamp stamp = new Stamp(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDIB64();
        StampResponseV1 response = stamp.TimbrarV1(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV2B64(){
        Stamp stamp = new Stamp(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDIB64();
        StampResponseV2 response = stamp.TimbrarV2(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV3B64(){
        Stamp stamp = new Stamp(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDIB64();
        StampResponseV3 response = stamp.TimbrarV3(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV4B64(){
        Stamp stamp = new Stamp(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDIB64();
        StampResponseV4 response = stamp.TimbrarV4(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }
}