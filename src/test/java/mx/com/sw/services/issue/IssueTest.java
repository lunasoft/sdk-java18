package mx.com.sw.services.issue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

public class IssueTest {
    private BuildSettings settings;
    public IssueTest(){
        this.settings = new BuildSettings();
    }

    @Test
    public void testStampV1(){
        Issue stamp = new Issue(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV1 response = stamp.TimbrarV1(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV2(){
        Issue stamp = new Issue(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV2 response = stamp.TimbrarV2(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV3(){
        Issue stamp = new Issue(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV3 response = stamp.TimbrarV3(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV4(){
        Issue stamp = new Issue(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV4 response = stamp.TimbrarV4(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    public void testStampV1Token(){
        Issue stamp = new Issue(settings.Url, settings.Token, null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV1 response = stamp.TimbrarV1(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV2Token(){
        Issue stamp = new Issue(settings.Url, settings.Token, null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV2 response = stamp.TimbrarV2(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV3Token(){
        Issue stamp = new Issue(settings.Url, settings.Token, null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV3 response = stamp.TimbrarV3(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV4Token(){
        Issue stamp = new Issue(settings.Url, settings.Token, null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV4 response = stamp.TimbrarV4(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV1B64(){
        Issue stamp = new Issue(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDIB64(false);
        StampResponseV1 response = stamp.TimbrarV1(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV2B64(){
        Issue stamp = new Issue(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDIB64(false);
        StampResponseV2 response = stamp.TimbrarV2(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV3B64(){
        Issue stamp = new Issue(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDIB64(false);
        StampResponseV3 response = stamp.TimbrarV3(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV4B64(){
        Issue stamp = new Issue(settings.Url, settings.User, settings.Password, null, 0);
        String xml = settings.getCFDIB64(false);
        StampResponseV4 response = stamp.TimbrarV4(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }
}