package mx.com.sw.services.issue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

public class IssueJsonTest {
    private BuildSettings settings;
    public IssueJsonTest(){
        this.settings = new BuildSettings();
    }

    @Test
    public void testStampV1(){
        IssueJson stamp = new IssueJson(settings.Url, settings.User, settings.Password, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV1 response = stamp.timbrarV1(json);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.tfd);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV2(){
        IssueJson stamp = new IssueJson(settings.Url, settings.User, settings.Password, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV2 response = stamp.timbrarV2(json);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.tfd);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV3(){
        IssueJson stamp = new IssueJson(settings.Url, settings.User, settings.Password, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV3 response = stamp.timbrarV3(json);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.cfdi);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV4(){
        IssueJson stamp = new IssueJson(settings.Url, settings.User, settings.Password, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV4 response = stamp.timbrarV4(json);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.uuid);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    public void testStampV1Token(){
        IssueJson stamp = new IssueJson(settings.Url, settings.Token, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV1 response = stamp.timbrarV1(json);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.tfd);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV2Token(){
        IssueJson stamp = new IssueJson(settings.Url, settings.Token, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV2 response = stamp.timbrarV2(json);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.tfd);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV3Token(){
        IssueJson stamp = new IssueJson(settings.Url, settings.Token, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV3 response = stamp.timbrarV3(json);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.cfdi);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testStampV4Token(){
        IssueJson stamp = new IssueJson(settings.Url, settings.Token, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV4 response = stamp.timbrarV4(json);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.uuid);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testV4StampV1(){
        IssueJsonV4 stamp = new IssueJsonV4(settings.Url, settings.User, settings.Password, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV1 response = stamp.timbrarV1(json, settings.Email);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.tfd);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testV4StampV2(){
        IssueJsonV4 stamp = new IssueJsonV4(settings.Url, settings.User, settings.Password, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV2 response = stamp.timbrarV2(json, settings.Email);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.tfd);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testV4StampV3(){
        IssueJsonV4 stamp = new IssueJsonV4(settings.Url, settings.Token, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV3 response = stamp.timbrarV3(json, settings.Email);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.cfdi);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }

    @Test
    public void testV4StampV4(){
        IssueJsonV4 stamp = new IssueJsonV4(settings.Url, settings.Token, null, 0);
        String json = settings.getJsonCFDI();
        StampResponseV4 response = stamp.timbrarV4(json, settings.Email);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.data);
        Assertions.assertNotNull(response.status);
        Assertions.assertNotNull(response.data.uuid);
        Assertions.assertTrue("success".equalsIgnoreCase(response.status));
    }
}