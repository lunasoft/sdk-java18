# sdk-java18
[![SW sapien](https://dka575ofm4ao0.cloudfront.net/pages-transactional_logos/retina/68712/SW_smarter-Servicios_web.png)](http://sw.com.mx/)

Librería JAVA para el consumo de los servicios de SW sapien®.

## Contenido 

- [Compatibilidad](#Compatibilidad)
- [Dependencias](#Dependencias)
- [Documentación](#Documentación)
- [Instalación](#Instalación)
- [Implementación](#Implementación)

### Compatibilidad
- CFDI 4.0
- Java 1.8 o superior

### Dependencias
Instalar solo si se descarga e instala de manera manual la librería. De igual manera se recomienda instalar la versión que incluye dependencias (archivo con terminación "jar-with-dependencies.jar").
*  [httpclient/4.5.6](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient/4.5.6)
*  [httpcore/4.4.10](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore/4.4.10)
*  [httpcore-nio/4.4.10](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore-nio/4.4.10)
*  [httpmime/4.5.6](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime/4.5.6)
*  [httpasyncclient/4.1.4](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpasyncclient/4.1.4)
*  [gson/2.8.6](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.6)
*  [not-yet-commons-ssl/0.3.11_1](https://mvnrepository.com/artifact/org.apache.servicemix.bundles/org.apache.servicemix.bundles.not-yet-commons-ssl/0.3.11_1)
*  [commons-logging/1.2](https://mvnrepository.com/artifact/commons-logging/commons-logging/1.2)


### Documentación
* [Inicio Rápido](https://developers.sw.com.mx/knowledge-base/conoce-el-proceso-de-integracion-en-solo-7-pasos/)
* Documentación disponible a través de GitHub Pages en el siguiente enlace: [sdk-java18](https://lunasoft.github.io/sdk-java18/)
* [Documentacion Oficial Servicios](http://developers.sw.com.mx)

---

### Instalación
Descargas el modulo mediante Maven:
```html
<dependency>
  <groupId>mx.com.sw</groupId>
  <artifactId>sdk-java18</artifactId>
  <version>0.0.1.0</version>
</dependency>
```

### Implementación

La librería contara con los servicios principales como lo son Timbrado de CFDI, Cancelación, Consulta estatus CFDI, etc.

## Autenticaci&oacute;n ##
El servicio de Autenticación es utilizado principalmente para obtener el **token** el cual sera utilizado para poder timbrar nuestro CFDI (xml) ya emitido (sellado), para poder utilizar este servicio es necesario que cuente con un **usuario** y **contraseña** para posteriormente obtenga el token, usted puede utilizar los que estan en este ejemplo para el ambiente de **Pruebas**.

**Obtener Token**
 ```java
import mx.com.sw.services.authentication.Authentication;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        //Creamos una instancia de tipo Authentication 
        //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
        Authentication auth = new Authentication("https://services.test.sw.com.mx", 
        "user","password", null, 0);
        AuthenticationResponse res = auth.authenticate();
    }
}
```

## Timbrado ##

<details>
<summary>
Timbrar CFDI V1
</summary>

## Timbrar CFDI V1 ##
**TimbrarV1** Recibe el contenido de un **XML** ya emitido (sellado) en formato **String**  ó tambien puede ser en **Base64**, posteriormente si la factura y el token son correctos devuelve el complemento timbre en un string (**TFD**), en caso contrario lanza una excepción.

**Timbrar XML en formato string utilizando usuario y contraseña**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.stamp.Stamp;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Stamp 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a timbrar el xml
            Stamp stamp = new Stamp("https://services.test.sw.com.mx", "user", "password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            StampResponseV1 response = stamp.timbrarV1(xml, false);
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```

**Timbrar XML en formato string utilizando token** [¿Como obtener token?](http://developers.sw.com.mx/knowledge-base/generar-un-token-infinito/)
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.stamp.Stamp;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Stamp 
            //A esta le pasamos la Url y su Token infinito 
            //Este lo puede obtener ingresando al administrador de timbres con su usuario y contraseña
            Stamp stamp = new Stamp("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            StampResponseV1 response = stamp.timbrarV1(xml, false);
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```

**Timbrar XML en Base64 utilizando token**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.stamp.Stamp;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Stamp 
            //A esta le pasamos la Url y su Token infinito 
            //Este lo puede obtener ingresando al administrador de timbres con su usuario y contraseña
            Stamp stamp = new Stamp("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            byte[] xml = Files.readAllBytes(Paths.get("file.xml"));
            String xml64 = Base64.getEncoder().encodeToString(xml);
            StampResponseV1 response = stamp.timbrarV1(xml64, true);
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Emisión Timbrado
</summary>

## Emisión Timbrado ##
**Emisión Timbrado** Realiza el sellado y timbrado de un comprobante CFDI 4.0. Recibe el contenido de un **XML** en formato **String**  ó tambien puede ser en **Base64**, posteriormente si la factura y el token son correctos devuelve el complemento timbre en un string (**TFD**), en caso contrario lanza una excepción

**Emisión Timbrado XML en formato string utilizando usuario y contraseña**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.issue.Issue;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Stamp 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a timbrar el xml
            Issue stamp = new Issue("https://services.test.sw.com.mx", "user", "password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            StampResponseV1 response = stamp.timbrarV1(xml, false);

            System.out.println(response.getStatus());
            System.out.println(response.getData().getTFD());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>


<details>
<summary>
Emisión Timbrado JSON
</summary>

## Emisión Timbrado JSON ##
**Emisión Timbrado JSON** Realiza el sellado y timbrado de un comprobante CFDI 4.0. Recibe el contenido de un **JSON** en formato **String**, posteriormente si la factura y el token son correctos devuelve el complemento timbre en un string (**TFD**), en caso contrario lanza una excepción

**Emisión Timbrado JSON en formato string utilizando usuario y contraseña**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.issue.IssueJson;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Stamp 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a timbrar el xml
            IssueJson stamp = new IssueJson("https://services.test.sw.com.mx", "user", "password",null, 0);
        
            String json = new String(Files.readAllBytes(Paths.get("pruebas.json")), "UTF-8");
            StampResponseV1 response = stamp.timbrarV1(json);
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

***NOTA:*** Existen varias versiones de respuesta, las cuales son las siguientes:

| Version |                         Respuesta                             | 
|---------|---------------------------------------------------------------|
|  V1     | Devuelve el timbre fiscal digital                             | 
|  V2     | Devuelve el timbre fiscal digital y el cfdi timbrado          | 
|  V3     | Devuelve el CFDI timbrado                                     | 
|  V4     | Devuelve todos los datos del timbrado                         |

Para mayor referencia de estas versiones de respuesta, favor de visitar el siguiente [link](https://developers.sw.com.mx/knowledge-base/versiones-de-respuesta-timbrado/).

## Cancelación ##

**Cancelacion** Se utiliza para cancelar documentos xml y se puede hacer mediante varios metodos **Cancelación CSD**, **Cancelación PFX**, **Cancelacion por XML** y **Cancelación UUID**.

<details>
<summary>
Cancelacion por CSD
</summary>

 ## Cancelacion por CSD ##
Como su nombre lo indica, este metodo recibe todos los elementos que componen el CSD los cuales son los siguientes:

* Certificado (.cer) en **Base64**
* Key (.key) en **Base64**
* RFC emisor
* Password del archivo key
* UUID
* Motivo
* Folio Sustitución

**Ejemplo de consumo de la libreria para cancelar con CSD con motivo de cancelación 02 sin relación a documento**
```java

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.cancelation.Cancelation;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Cancelation 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a Cancelar el xml o cfdi
            Cancelation cancelation = new Cancelation("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            
            //Obtenemos Certificado y lo convertimos a Base 64
            String cer = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.cer")));
            
            //Obtenemos LLave y lo convertimos a Base 64
            String key = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.key")));

            CancelationResponse response = cancelation.cancelar(cer, key, "EKU9003173C9", "12345678a", "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC", "02", null);

            if (response.getStatus().equalsIgnoreCase("success"))
                {
                    //Acuse de cancelación
                    System.out.println(response.getData().getAcuse());
                    //Estatus del UUID
                    System.out.println(response.getData().getUUID());
                }
            else
                {
                    //Obtenemos el detalle del Error
                    System.out.println("Error al cancelar");
                    System.out.println(response.getMessage());
                    System.out.println(response.getMessageDetail());
                }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```

**Ejemplo de consumo de la libreria para cancelar con CSD con motivo de cancelación 01 con relación a documento**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.cancelation.Cancelation;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Cancelation 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a Cancelar el xml o cfdi
            Cancelation cancelation = new Cancelation("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            
            //Obtenemos Certificado y lo convertimos a Base 64
            String cer = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.cer")));
            
            //Obtenemos LLave y lo convertimos a Base 64
            String key = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.key")));

            CancelationResponse response = cancelation.cancelar(cer, key, "EKU9003173C9", "12345678a", "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC", "02", "01724196-ac5a-4735-b621-e3b42bcbb459");

            if (response.getStatus().equalsIgnoreCase("success"))
                {
                    //Acuse de cancelación
                    System.out.println(response.getData().getAcuse());
                    //Estatus del UUID
                    System.out.println(response.getData().getUUID());
                }
            else
                {
                    //Obtenemos el detalle del Error
                    System.out.println("Error al cancelar");
                    System.out.println(response.getMessage());
                    System.out.println(response.getMessageDetail());
                }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Cancelacion por PFX
</summary>

## Cancelacion por PFX ##

Este método recibe los siguientes parametros:
* Archivo PFX en **Base64**
* RFC emisor
* Password (CSD)
* UUID
* Motivo
* Folio Sustitución
**Ejemplo de consumo de la libreria para cancelar con PFX con motivo de cancelación 02 sin relación a documento**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.cancelation.Cancelation;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Datos de Cancelación
            String rfc = "EKU9003173C9";
            String password = "12345678a";
            String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";

            //Creamos una instancia de tipo Cancelation 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a Cancelar el xml o cfdi
            Cancelation cancelation = new Cancelation("https://services.test.sw.com.mx", "user",
            "password", null, 0);

            //Convertimos el PFX a base 64
            String pfx = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("PFX_EKU9003173C9.pfx")));
            
            //Realizamos la petición de cancelación al servicio.
            CancelationResponse response = cancelation.cancelar(pfx, rfc, password, uuid, "02", null);

            if (response.getStatus().equalsIgnoreCase("success"))
                {
                    //Acuse de cancelación
                    System.out.println(response.getData().getAcuse());
                    //Estatus del UUID
                    System.out.println(response.getData().getUUID());
                }
            else
                {
                    //Obtenemos el detalle del Error
                    System.out.println("Error al cancelar");
                    System.out.println(response.getMessage());
                    System.out.println(response.getMessageDetail());
                }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```

**Ejemplo de consumo de la libreria para cancelar con PFX con motivo 01 con documento relacionado**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.cancelation.Cancelation;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Datos de Cancelación
            String rfc = "EKU9003173C9";
            String password = "12345678a";
            String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";
            String folioSustitucion = "09d849d8-1cbf-424e-84bc-8e6724dcb649";

            //Creamos una instancia de tipo Cancelation 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a Cancelar el xml o cfdi
            Cancelation cancelation = new Cancelation("https://services.test.sw.com.mx", "user",
            "password", null, 0);

            //Convertimos el PFX a base 64
            String pfx = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("PFX_EKU9003173C9.pfx")));
            
            //Realizamos la petición de cancelación al servicio.
            CancelationResponse response = cancelation.cancelar(pfx, rfc, password, uuid, "01", folioSustitucion);

            if (response.getStatus().equalsIgnoreCase("success"))
                {
                    //Acuse de cancelación
                    System.out.println(response.getData().getAcuse());
                    //Estatus del UUID
                    System.out.println(response.getData().getUUID());
                }
            else
                {
                    //Obtenemos el detalle del Error
                    System.out.println("Error al cancelar");
                    System.out.println(response.getMessage());
                    System.out.println(response.getMessageDetail());
                }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Cancelacion por XML
</summary>

## Cancelacion por XML ##
Este método recibe únicamente el XML sellado con los UUID a cancelar.

**Ejemplo de XML para Cancelar**
```xml
<Cancelacion xmlns="http://cancelacfd.sat.gob.mx"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema" Fecha="2021-12-26T18:15:28" RfcEmisor="EKU9003173C9">
    <Folios>
        <Folio UUID="fe4e71b0-8959-4fb9-8091-f5ac4fb0fef8" Motivo="02" FolioSustitucion=""/>
    </Folios>
    <Signature xmlns="http://www.w3.org/2000/09/xmldsig#">
        <SignedInfo>
            <CanonicalizationMethod Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315" />
            <SignatureMethod Algorithm="http://www.w3.org/2000/09/xmldsig#rsa-sha1" />
            <Reference URI="">
                <Transforms>
                    <Transform Algorithm="http://www.w3.org/2000/09/xmldsig#enveloped-signature" />
                </Transforms>
                <DigestMethod Algorithm="http://www.w3.org/2000/09/xmldsig#sha1" />
                <DigestValue>XEdUtCptjdlz9DsYAP7nnU6MytU=</DigestValue>
            </Reference>
        </SignedInfo>
        <SignatureValue>ZnWh91e5tUc4/t1ZWnb3yOgB8zuCXNPioND+rv6aLOEwIw26/8sYYb+GT4wgyqlc09wOs32XTUwWoGQwtWMG8Euqq+4xJyobWvPCsX6CiURvD/Pd33xgkH92A0AGQxEMYGVT7wK+GFS2gDTYEYAXvZqzCe6+rXnlQvHML0TOOmhVu/wc8YrCbGt4z/F5sRxhjpa0eqwFEq4RmB4nkWjcD3Pnudn3XAI5NHIiOd8KVGVcDR+LvYvKj7h+18WxZgujpggYjbFN79i1jEsAEPDfgryUdTvjDw+KC7Mg+/ge6pssH42buEMIwVE4VX9Y3NtWSGTwdIK/8pxXk+Y5wyR6Gg==</SignatureValue>
        <KeyInfo>
            <X509Data>
                <X509IssuerSerial>
                    <X509IssuerName>OID.1.2.840.113549.1.9.2=responsable: ACDMA-SAT, OID.2.5.4.45=2.5.4.45, L=COYOACAN, S=CIUDAD DE MEXICO, C=MX, PostalCode=06370, STREET=3ra cerrada de cadiz, E=oscar.martinez@sat.gob.mx, OU=SAT-IES Authority, O=SERVICIO DE ADMINISTRACION TRIBUTARIA, CN=AC UAT</X509IssuerName>
                    <X509SerialNumber>292233162870206001759766198444326234574038512436</X509SerialNumber>
                </X509IssuerSerial>
                <X509Certificate>MIIFuzCCA6OgAwIBAgIUMzAwMDEwMDAwMDA0MDAwMDI0MzQwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWRpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMTkwNjE3MTk0NDE0WhcNMjMwNjE3MTk0NDE0WjCB4jEnMCUGA1UEAxMeRVNDVUVMQSBLRU1QRVIgVVJHQVRFIFNBIERFIENWMScwJQYDVQQpEx5FU0NVRUxBIEtFTVBFUiBVUkdBVEUgU0EgREUgQ1YxJzAlBgNVBAoTHkVTQ1VFTEEgS0VNUEVSIFVSR0FURSBTQSBERSBDVjElMCMGA1UELRMcRUtVOTAwMzE3M0M5IC8gWElRQjg5MTExNlFFNDEeMBwGA1UEBRMVIC8gWElRQjg5MTExNk1HUk1aUjA1MR4wHAYDVQQLExVFc2N1ZWxhIEtlbXBlciBVcmdhdGUwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCN0peKpgfOL75iYRv1fqq+oVYsLPVUR/GibYmGKc9InHFy5lYF6OTYjnIIvmkOdRobbGlCUxORX/tLsl8Ya9gm6Yo7hHnODRBIDup3GISFzB/96R9K/MzYQOcscMIoBDARaycnLvy7FlMvO7/rlVnsSARxZRO8Kz8Zkksj2zpeYpjZIya/369+oGqQk1cTRkHo59JvJ4Tfbk/3iIyf4H/Ini9nBe9cYWo0MnKob7DDt/vsdi5tA8mMtA953LapNyCZIDCRQQlUGNgDqY9/8F5mUvVgkcczsIgGdvf9vMQPSf3jjCiKj7j6ucxl1+FwJWmbvgNmiaUR/0q4m2rm78lFAgMBAAGjHTAbMAwGA1UdEwEB/wQCMAAwCwYDVR0PBAQDAgbAMA0GCSqGSIb3DQEBCwUAA4ICAQBcpj1TjT4jiinIujIdAlFzE6kRwYJCnDG08zSp4kSnShjxADGEXH2chehKMV0FY7c4njA5eDGdA/G2OCTPvF5rpeCZP5Dw504RZkYDl2suRz+wa1sNBVpbnBJEK0fQcN3IftBwsgNFdFhUtCyw3lus1SSJbPxjLHS6FcZZ51YSeIfcNXOAuTqdimusaXq15GrSrCOkM6n2jfj2sMJYM2HXaXJ6rGTEgYmhYdwxWtil6RfZB+fGQ/H9I9WLnl4KTZUS6C9+NLHh4FPDhSk19fpS2S/56aqgFoGAkXAYt9Fy5ECaPcULIfJ1DEbsXKyRdCv3JY89+0MNkOdaDnsemS2o5Gl08zI4iYtt3L40gAZ60NPh31kVLnYNsmvfNxYyKp+AeJtDHyW9w7ftM0Hoi+BuRmcAQSKFV3pk8j51la+jrRBrAUv8blbRcQ5BiZUwJzHFEKIwTsRGoRyEx96sNnB03n6GTwjIGz92SmLdNl95r9rkvp+2m4S6q1lPuXaFg7DGBrXWC8iyqeWE2iobdwIIuXPTMVqQb12m1dAkJVRO5NdHnP/MpqOvOgLqoZBNHGyBg4Gqm4sCJHCxA1c8Elfa2RQTCk0tAzllL4vOnI1GHkGJn65xokGsaU4B4D36xh7eWrfj4/pgWHmtoDAYa8wzSwo2GVCZOs+mtEgOQB91/g==</X509Certificate>
            </X509Data>
        </KeyInfo>
    </Signature>
</Cancelacion>
```
Para caso de motivo 01 deberá añadir el atributo "FolioSustitucion" dentro del Nodo <Folio>

Ejemplo de nodo Folio: 
```
<Folios>
	<Folio UUID="b374db50-a0a3-4028-9d01-32b93e2b925a" Motivo="01" FolioSustitucion="b3641a4b-7177-4323-aaa0-29bd34bf1ff8" />
</Folios>
```

**Ejemplo de consumo de la libreria para cancelar con XML**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.cancelation.Cancelation;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Cancelation 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a Cancelar el xml o cfdi
            Cancelation cancelation = new Cancelation("https://services.test.sw.com.mx", "user",
            "password", null, 0);
            //Obtenemos el XML de cancelacion
            String xmlCancelation = new String(Files.readAllBytes(Paths.get("cancelacion.xml")), "UTF-8");
            CancelationResponse response = cancelation.cancelar(xmlCancelation);

            if (response.getStatus().equalsIgnoreCase("success"))
                {
                    //Acuse de cancelación
                    System.out.println(response.getData().getAcuse());
                    //Estatus del UUID
                    System.out.println(response.getData().getUUID());
                }
            else
                {
                    //Obtenemos el detalle del Error
                    System.out.println("Error al cancelar");
                    System.out.println(response.getMessage());
                    System.out.println(response.getMessageDetail());
                }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Cancelacion por UUID
</summary>

## Cancelacion por UUID ##
Este método recibe los siguientes parametros:
* RFC emisor
* UUID
* Motivo
* Folio Sustitución

**Ejemplo de consumo de la libreria para cancelar con UUID con motivo de cancelación 02 sin documento relacionado**
```java
import mx.com.sw.services.cancelation.Cancelation;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Datos de Cancelación
            String rfc = "EKU9003173C9";
            String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";

            //Creamos una instancia de tipo Cancelation 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a Cancelar el xml o cfdi
            Cancelation cancelation = new Cancelation("https://services.test.sw.com.mx", "user",
            "password", null, 0);
            
            //Realizamos la petición de cancelación al servicio.
            CancelationResponse response = cancelation.cancelar(rfc, uuid, "02", null);

            if (response.getStatus().equalsIgnoreCase("success"))
                {
                    //Acuse de cancelación
                    System.out.println(response.getData().getAcuse());
                    //Estatus del UUID
                    System.out.println(response.getData().getUUID());
                }
            else
                {
                    //Obtenemos el detalle del Error
                    System.out.println("Error al cancelar");
                    System.out.println(response.getMessage());
                    System.out.println(response.getMessageDetail());
                }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```

**Ejemplo de consumo de la libreria para cancelar con UUID con motivo de cancelación 01 con documento relacionado**
```java
import mx.com.sw.services.cancelation.Cancelation;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Datos de Cancelación
            String rfc = "EKU9003173C9";
            String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";

            //Creamos una instancia de tipo Cancelation 
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            //Automaticamente despues de obtenerlo se procedera a Cancelar el xml o cfdi
            Cancelation cancelation = new Cancelation("https://services.test.sw.com.mx", "user",
            "password", null, 0);
            
            //Realizamos la petición de cancelación al servicio.
            CancelationResponse response = cancelation.cancelar(rfc, uuid, "02", null);

            if (response.getStatus().equalsIgnoreCase("success"))
                {
                    //Acuse de cancelación
                    System.out.println(response.getData().getAcuse());
                    //Estatus del UUID
                    System.out.println(response.getData().getUUID());
                }
            else
                {
                    //Obtenemos el detalle del Error
                    System.out.println("Error al cancelar");
                    System.out.println(response.getMessage());
                    System.out.println(response.getMessageDetail());
                }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

## Validación ##

<details>
<summary>
Validación XML
</summary>

## Validación XML ##
Este servicio recibe un comprobante CFDI 4.0 en formato XML mediante el cual se valida integridad, sello, errores de estructura, matriz de errores del SAT incluyendo complementos, se valida que exista en el SAT, así como el estatus en el SAT.

Este metodo recibe los siguientes parametros:
- Url Servicios SW
- Usuario y contraseña o token
- XML

**Ejemplo de consumo de la libreria para validación de XML mediante usuario y contraseña**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.Validate.Validate;
import mx.com.sw.services.Validate.responses.ValidateDetailData;
import mx.com.sw.services.Validate.responses.ValidateNodeDetail;
import mx.com.sw.services.Validate.responses.ValidateResponse;

public class App {
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Validate
            //A esta le pasamos la Url, Usuario y Contraseña para obtener el token
            Validate api = new Validate("https://services.test.sw.com.mx", "user","password", null, 0);

            String xml = new String(Files.readAllBytes(Paths.get("pruebas.xml")), "UTF-8");
            //Realizamos la peticion de validacion pasando el XML
            ValidateResponse response = api.ValidateXML(xml);

            //El objeto response tendra los siguientes atributos:
            System.out.println(response.getStatus());
            List<ValidateNodeDetail> List = response.getDetail();
            for(int i=0; i<List.size();i++){
                ValidateNodeDetail node = List.get(i);
                List<ValidateDetailData> ListData = node.getDetailData();
                for(int j=0; j<ListData.size();j++){
                    ValidateDetailData data = ListData.get(j);
                    System.out.println("\t\t"+data.getMessage());
                    System.out.println("\t\t"+data.getMessageDetail());
                    System.out.println("\t\t"+data.getType());
                }
                System.out.println("\t"+node.getSection());
            }
            System.out.println(response.getCadenaOriginalComprobante());
            System.out.println(response.getCadenaOriginalSAT());
            System.out.println(response.getUuid());
            System.out.println(response.getStatusSat());
            System.out.println(response.getStatusCodeSat());
            Assertions.assertTrue("Success".equalsIgnoreCase(response.getStatus()));

            //En caso de error, se pueden visualizar los campos message y/o messageDetail
            System.out.println("Error al validar xml");
            System.out.println(res.getMessage());
            System.out.println(res.getMessageDetail());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

## Administración de Saldos ##
Este servicio consulta, asigna y elimina saldo a las cuentas que administres.

Se deberá autenticar en nuestros servicios para obtener token de acceso, o si se desea, se puede usar el token infinito.
<details>
<summary>
Consultar saldo por token
</summary>
Este metodo solo necesita la autenticación a nuestros servicios.


**Ejemplo de consumo de la libreria para consultar el saldo mediante token**
```java
import mx.com.sw.services.account.balance.AccountBalance;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo BalanceAccount 
            //A esta le pasamos la UrlApi y el token de la cuenta a consultar

            AccountBalance account = new AccountBalance("https://api.test.sw.com.mx", "token", null, 0);
            AccountBalanceResponse res = account.getBalance();
            AccountBalanceResponse response = account.getBalance();
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
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Añadir saldo
</summary>
Este metodo necesita como parametros:

- IdUser a añadirle saldo
- Cantidad de timbres
- Comentario (opcional)

**Ejemplo de consumo de la libreria para añadir saldo mediante token**
```java
import java.util.UUID;
import mx.com.sw.services.account.balance.AccountBalance;
import mx.com.sw.services.account.balance.responses.AccountActionsData;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo BalanceAccount 
            //A esta le pasamos solo UrlApi y token para obtener el token
            //Automaticamente despues de obtenerlo se procedera a consultar el saldo mediante el IdCliente
            AccountBalance account = new AccountBalance("https://api.test.sw.com.mx", "token", null, 0);
            AccountActionsData res = account.addStamps(UUID.fromString("24419cba-1af4-4a46-8244-2ae02f6dc15e"), 5, "Prueba");
           
            //Visualizamos la respuesta
            System.out.println(res.getStatus());
            System.out.println(res.getData());
            System.out.println(res.getMessage());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>
<details>
<summary>
Eliminar saldo
</summary>
Este metodo necesita como parametros:

- IdUser a remover saldo
- Cantidad de timbres
- Comentario (opcional)

**Ejemplo de consumo de la libreria para eliminar saldo mediante token**
```java
import java.util.UUID;
import mx.com.sw.services.account.balance.AccountBalance;
import mx.com.sw.services.account.balance.responses.AccountActionsData;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo BalanceAccount 
            //A esta le pasamos solo UrlApi y token para obtener el token
            //Automaticamente despues de obtenerlo se procedera a consultar el saldo mediante el IdCliente
            AccountBalance account = new AccountBalance("https://api.test.sw.com.mx", "token", null, 0);
            AccountActionsData res = account.removeStamps(UUID.fromString("24419cba-1af4-4a46-8244-2ae02f6dc15e"), 5, null);
           
            //Visualizamos la respuesta
            System.out.println(res.getStatus());
            System.out.println(res.getData());
            System.out.println(res.getMessage());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>


## Administración de Usuarios ##
Este servicio consulta, crea y elimina usuarios a las cuentas que administres.

Se deberá autenticar en nuestros servicios para obtener token de acceso, o si se desea, se puede usar el token infinito.
<details>
<summary>
Crear un usuario
</summary>
Este metodo solo necesita la autenticación a nuestros servicios.

**Ejemplo de consumo de la libreria para crear usuario mediante token**
```java
import mx.com.sw.services.account.info;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AccountInfo 
            //A esta le pasamos la UrlApi, token y en este caso se debe de ingresar, correo, contraseña, nombre, rfc, perfil default(3), numero de timbres, si es ilimitada o no y si la crearemos como activa o inactiva.
            AccountInfo account = new AccountInfo("https://api.test.sw.com.mx", settings.getTokenSW(), null, 0);
            AccountInfoResponse res = account.createUser("usuario@nuevo.com", "123abcABC..", "PruebaJava18",
                    "XAXX010101000", 1, false, "correo@notification.com", "3920000000");
            
            //Para Obtener los datos del usuario creado
            System.out.println(response.getData());

            //En caso de error, se pueden visualizar los campos message y/o messageDetail
            System.out.println("Error al consultar el usuario");
            System.out.println(res.getMessage());
            System.out.println(res.getMessageDetail());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Crear un usuario
</summary>
Este metodo solo necesita la autenticación a nuestros servicios.

**Ejemplo de consumo de la libreria para crear usuario mediante token**
```java
import mx.com.sw.services.account.info;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AccountInfo 
            //A esta le pasamos la UrlApi, token y en este caso se debe de ingresar, correo, contraseña, nombre, rfc, perfil default(3), numero de timbres, si es ilimitada o no y si la crearemos como activa o inactiva.
            AccountInfo account = new AccountInfo("https://api.test.sw.com.mx", settings.getTokenSW(), null, 0);
           AccountInfoActionResponse res = account.updateUser(UUID.fromString("be2a859c-cd5f-42b5-b35d-f065b3a9aac4"),
                    "PruebaAct Java 18", "RAQÑ7701212M3", "nuevoEmail@notification.com",
                    "9820000000", false);
            
            System.out.println(response.getStatus());
            System.out.println("Error al consultar el usuario");
            System.out.println(res.getMessage());
            System.out.println(res.getMessageDetail());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Eliminar un usuario
</summary>
Este metodo solo necesita la autenticación a nuestros servicios.

**Ejemplo de consumo de la libreria para eliminar saldo mediante token**
```java
import mx.com.sw.services.account.info;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AccountInfo 
            //A esta le pasamos la UrlApi, token y se le pasa el Id usuario de la cuenta a eliminar
           AccountInfo account = new AccountInfo(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            AccountInfoActionResponse res = account.deleteIdUser("dec88273-6587-4f1e-9673-317b30e07aab");
            System.out.println("Error al consultar el usuario");
            System.out.println(res.getMessage());
            System.out.println(res.getMessageDetail());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>
<details>
<summary>
Consultar cuentas hijas
</summary>
Este metodo solo necesita la autenticación a nuestros servicios.


**Ejemplo de consumo de la libreria para consultar cuentas hijas**
```java
import mx.com.sw.services.account.info;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AccountInfo 
            //A esta le pasamos la UrlApi y el token de la cuenta a consultar
            AccountInfo account = new AccountInfo("https://api.test.sw.com.mx", settings.getTokenSW(), null, 0);
            AccountListDataResponse res = account.getAllUsers();
            
            //Para Obtener los datos del usuario
            System.out.println(response.getData());
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
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Consultar usuario por Id
</summary>
Este metodo solo necesita la autenticación a nuestros servicios y el ID del cliente a consultar

**Ejemplo de consumo de la libreria para consultar un usuario por ID**
```java
import mx.com.sw.services.account.info;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AccountInfo 
            //A esta le pasamos la UrlApi, token y el id de la cuenta a consultar
            AccountInfo account = new AccountInfo("https://api.test.sw.com.mx", settings.getTokenSW(), null, 0);
           AccountListDataResponse res = account.getUserById("32501cf2-dc62-4370-b47d-25024c44e130");
            
            //Para Obtener los datos del usuario
            System.out.println(response.getData());
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
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Consultar usuarios por RFC
</summary>
Este metodo solo necesita la autenticación a nuestros servicios y el RFC a consultar

**Ejemplo de consumo de la libreria para consultar usuario por RFC**
```java
import mx.com.sw.services.account.info;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AccountInfo 
            AccountInfo account = new AccountInfo("https://api.test.sw.com.mx", settings.getTokenSW(), null, 0);
             AccountListDataResponse res = account.getUsersByRfc("EKU9003173C9");
            
            //Para Obtener los datos del usuario
            System.out.println(response.getData());
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
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Consultar usuarios por Email
</summary>
Este metodo solo necesita la autenticación a nuestros servicios y el Email a consultar

**Ejemplo de consumo de la libreria para consultar clientes con un correo en especifico**
```java
import mx.com.sw.services.account.info;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AccountInfo 
            AccountInfo account = new AccountInfo("https://api.test.sw.com.mx", settings.getTokenSW(), null, 0);
           AccountListDataResponse res = account.getUsersByEmail("emailquequiero@buscar.com");
    
            //Para Obtener los datos del usuario
            System.out.println(response.getData());
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
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Consultar usuarios activos o no activos
</summary>
Este metodo solo necesita la autenticación a nuestros servicios y true si quieres ver los usuarios activos, o false si buscas los desactivados

**Ejemplo de consumo de la libreria para consultar los usuarios activos**
```java
import mx.com.sw.services.account.info;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            AccountInfo account = new AccountInfo("https://api.test.sw.com.mx", settings.getTokenSW(), null, 0);
           AccountListDataResponse res = account.getUsersActivate(true);
            //Para Obtener los datos del usuario
            System.out.println(response.getData());
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
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>




## PDF ##

<details>
<summary>
Generar PDF
</summary>

## Generar PDF ##
Este método genera y obtiene un pdf en base64 a partir de un documento XML timbrado y una plantilla. Puede ser consumido ingresando tu usuario y contraseña así como tambien ingresando solo el token. Este método recibe los siguientes parámetros:

- Url servicios SW
- Url Api
- Logo Base64 (opcional)
- Template id
- Xml timbrado
- Datos extra (opcional)
**Ejemplo de consumo de la librería para la consulta**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import mx.com.sw.services.pdf.Pdf;
import mx.com.sw.services.pdf.responses.PdfResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo PDF 
            //A esta le pasamos la Url y el token
            Pdf pdf = new Pdf("https://api.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);

            //Obtenemos el xml
            String xmlcontent = new String(Files.readAllBytes(Paths.get("cfdi_pdf.xml")), "UTF-8");

            //Creamos un arreglo de objetos donde se mencionan las observaciones y/o datos extras
            HashMap<String, String> observaciones = new HashMap<String, String>();
            observaciones.put("Observaciones", "Entregar de 9am a 6pm");

            //Realizamos la petición de generacion al servicio.
            PdfResponse response = pdf.getPdf("cfdi40", xmlcontent, observaciones);

            System.out.println(response.getStatus());
            System.out.println(response.getData().getContentB64());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Regenerar PDF
</summary>

## Regenerar PDF ##
El servicio podrá generar o regenerar un PDF de un CFDI previamente timbrados y podrá guardar o remplazar el archivo PDF para ser visualizado posteriormente desde el portal de Smarter. Puede ser consumido ingresando tu usuario y contraseña así como tambien ingresando solo el token. Este método recibe los siguientes parámetros:

- Url servicios SW(cuando se añaden usuario y contraseña)
- Url Api
- UUID
**Ejemplo de consumo de la librería para la utilización**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import mx.com.sw.services.pdf.Pdf;
import mx.com.sw.services.pdf.responses.PdfResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo PDF 
            //A esta le pasamos la Url y el token
            Pdf pdf = new Pdf("https://api.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);

            //Realizamos la petición de regenerar el pdf pasando el UUID del CFDI que queremos regenerar.
            PdfResponse response = pdf.regeneratePdf(UUID.fromString("21348cb0-a94a-466c-a8e0-abef7f35a71b"));

            //Obtenemos el detalle de la respuesta
            System.out.println(response.getStatus());
            System.out.println(response.getMessage());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Reenvio Email
</summary>

## Reenvio Email ##
Este servicio realiza el reenvío de un xml y/o pdf existente mediante su UUID
a través de correo electrónico.

Este método recibe los siguientes parametros:
* UUID: Folico fiscal del comprobante timbrado
* email: Correo electrónico (máximo 5 correos separados por ” , ” )

**Ejemplo de consumo de la librería para la consulta**
```java
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import mx.com.sw.services.resend.resend;
import mx.com.sw.services.resend.response.ResendResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Resend
		    //A esta le pasamos el UrlAPi, asi como nuestro token
            Resend resend = new Resend("https://api.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            //Creamos una array con los correos (Max. 5 correos, separados por ",")
            List<String> correo = Arrays.asList("correo@test.com.mx");
            ////Automaticamente recibiremos a nuestro correo el XML y/o PDF existente
            PResendResponse response = resend.ResendEmail(UUID.fromString("5bb78a5c-9fd7-4100-8fac-9b51b585e22f"), correo)
            //Para obtener el estatus
            System.out.println(response.getStatus());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

## Certificados ##
Servicio para gestionar los certificados CSD de tu cuenta, será posible cargar, consultar y eliminar los certificados.
Para administrar los certificados de manera gráfica, puede hacerlo desde el [Administrador de timbres](https://portal.sw.com.mx/).

<details>
<summary>
Consultar Certificados
</summary>

## Consultar Certificados ##
Método para consultar todos los certificados cargados en la cuenta.

Este metodo recibe los siguientes parametros:
* Url Servicios SW(cuando se añaden usuario y contraseña)
* Usuario y contraseña ó Token 

**Ejemplo de consumo de la libreria para la consulta de certificados mediante token**
```java
import java.util.List;
import mx.com.sw.services.csd.responses.CsdDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponse;
import mx.com.sw.services.csd.responses.CsdResponse;
import mx.com.sw.services.csd.responses.CsdData;
import mx.com.sw.services.csd.CsdUtils;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo CsdUtils
            //A esta le pasamos la Url y token
            //Automaticamente se procedera a la consulta
            CsdUtils csd = new CsdUtils("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            CsdListDataResponse response = csd.GetAllCsd();
            //En caso exitoso se podran obtener los siguientes datos
            List<CsdData> lista = response.getData();
            if(lista != null) {
                for(int i=0; i<lista.size(); i++) {
                    CsdData dato = lista.get(i);
                    System.out.println(dato.getIssuerRfc());
                    System.out.println(dato.getIssuerBusinessName());
                    System.out.println(dato.getCertificateNumber());
                    System.out.println(dato.getCertificateType());
                    System.out.println(dato.getIsActive());
                    System.out.println(dato.getValidFrom());
                    System.out.println(dato.getValidTo());
                }
            }

            //En caso de error, se pueden visualizar los campos message y/o messageDetail
            System.out.println("Error");
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Consultar Certificado Por RFC
</summary>

## Consultar Certificado Por RFC ##
Método para obtener un certificado cargado enviando como parámetro el RFC del contribuyente.

Este metodo recibe los siguientes parametros:
* Url Servicios SW
* Usuario y contraseña ó Token 
* RFC del contribuyente

**Ejemplo de consumo de la librería para la consulta de certificados por RFC mediante token**
```java
import java.util.List;
import mx.com.sw.services.csd.responses.CsdDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponse;
import mx.com.sw.services.csd.responses.CsdResponse;
import mx.com.sw.services.csd.responses.CsdData;
import mx.com.sw.services.csd.CsdUtils;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //RFC del certificado
            String Rfc = "EKU9003173C9";
            //Creamos una instancia de tipo CsdUtils
            //A esta le pasamos la Url y token
            //Automaticamente se procedera a la consulta
            CsdUtils csd = new CsdUtils("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            CsdListDataResponse response = csd.GetCsdByRfc(Rfc);
            //En caso exitoso se podran obtener los siguientes datos
            List<CsdData> lista = response.getData();
            if(lista != null) {
                for(int i=0; i<lista.size(); i++) {
                    CsdData dato = lista.get(i);
                    System.out.println(dato.getIssuerRfc());
                    System.out.println(dato.getIssuerBusinessName());
                    System.out.println(dato.getCertificateNumber());
                    System.out.println(dato.getCertificateType());
                    System.out.println(dato.getIsActive());
                    System.out.println(dato.getValidFrom());
                    System.out.println(dato.getValidTo());
                }
            }

            //En caso de error, se pueden visualizar los campos message y/o messageDetail
            System.out.println("Error");
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Consultar Certificado Por NoCertificado
</summary>

## Consultar Certificado Por NoCertificado ##
Método para obtener un certificado cargado enviando como parámetro el número de certificado.

Este metodo recibe los siguientes parametros:
* Url Servicios SW
* Usuario y contraseña ó Token 
* Número de certificado a obtener

**Ejemplo de consumo de la libreria para la consulta de certificados por Número de Certificado mediante token**
```java
import java.util.List;
import mx.com.sw.services.csd.responses.CsdDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponse;
import mx.com.sw.services.csd.responses.CsdResponse;
import mx.com.sw.services.csd.responses.CsdData;
import mx.com.sw.services.csd.CsdUtils;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Número de certificado
            String NoCertificado = "30001000000400002434";
            //Creamos una instancia de tipo CsdUtils
            //A esta le pasamos la Url y token
            //Automaticamente se procedera a la consulta
            CsdUtils csd = new CsdUtils("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            CsdDataResponse response = csd.GetCsd(NoCertificado);
            //En caso exitoso se podran obtener los siguientes datos
            System.out.println(response.getData().getIssuerRfc());
            System.out.println(response.getData().getIssuerBusinessName());
            System.out.println(response.getData().getCertificateNumber());
            System.out.println(response.getData().getCertificateType());
            System.out.println(response.getData().getIsActive());
            System.out.println(response.getData().getValidFrom());
            System.out.println(response.getData().getValidTo());

            //En caso de error, se pueden visualizar los campos message y/o messageDetail
            System.out.println("Error");
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Cargar Certificado
</summary>

## Cargar Certificado ##
Método para cargar un certificado en la cuenta.

Este metodo recibe los siguientes parametros:
* Url Servicios SW
* Token
* CSD en Base64
* Key en Base64
* Contraseña del certificado

**Ejemplo de consumo de la libreria para la carga de certificado mediante token**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import mx.com.sw.services.csd.responses.CsdDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponse;
import mx.com.sw.services.csd.responses.CsdResponse;
import mx.com.sw.services.csd.responses.CsdData;
import mx.com.sw.services.csd.CsdUtils;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Datos necesarios
            String passwordCer = "12345678a";
            //Obtenemos Certificado y lo convertimos a Base 64 
            String cer = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.cer")));
            //Obtenemos LLave y lo convertimos a Base 64
            String key = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.key")));

            //Creamos una instancia de tipo CsdUtils
            //A esta le pasamos la Url y token
            //Automaticamente se procedera a la carga de los certificados
            CsdUtils csd = new CsdUtils("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            CsdResponse response = csd.UploadCsd(cer, key, passwordCer);
            //En caso exitoso se podran obtener el mensaje de exito
            System.out.println(response.data);

            //En caso de error, se pueden visualizar los campos message y/o messageDetail
            System.out.println("Error");
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Eliminar Certificado
</summary>

## Eliminar Certificado ##
Método para eliminar un certificado de la cuenta.

Este metodo recibe los siguientes parametros:
* Url Servicios SW
* Token
* Número de certificado a eliminar

**Ejemplo de consumo de la libreria para eliminar un certificado mediante token**
```java
import java.util.List;
import mx.com.sw.services.csd.responses.CsdDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponse;
import mx.com.sw.services.csd.responses.CsdResponse;
import mx.com.sw.services.csd.responses.CsdData;
import mx.com.sw.services.csd.CsdUtils;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Número de certificado
            String NoCertificado = "30001000000400002434";
            //Creamos una instancia de tipo CsdUtils
            //A esta le pasamos la Url y token
            //Automaticamente se procedera a la eliminacion
            CsdUtils csd = new CsdUtils("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            CsdResponse response = csd.DeleteCsd(NoCertificado);
            //En caso exitoso se podran obtener el mensaje de exito.
            System.out.println(response.data);

            //En caso de error, se pueden visualizar los campos message y/o messageDetail
            System.out.println("Error");
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>


## CFDI Relacionados ##
A través de estos siguientes métodos obtendremos un listado de los UUID que se encuentren relacionados a una factura.

<details>
<summary>
Relacionados por CSD
</summary>

## Relacionados por CSD ##
Este método recibe el **certificado** en base64, **llave** en base64, **RFC**, **password** del certificado, y el **UUID** de la factura.
**Ejemplo de consumo de la librería para la consulta**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.relations.Relations;
import mx.com.sw.services.relations.response.RelationsResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Relations
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a consultar las facturas relacionadas
            Relations relations = new Relations("https://services.test.sw.com.mx", "user","password", null, 0);
            //Obtenemos Certificado y lo convertimos a Base 64 
            String cer = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.cer")));
            //Obtenemos LLave y lo convertimos a Base 64
            String key = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.key")));
            //Datos
            String password = "12345678a";
            String rfc = "EKU9003173C9";
            RelationsResponse res = relations.getRelations(cer, key, rfc, password,"106d7664-6a1d-4ec6-9c09-2aa27532ec59");
            //Para obtener el status de la consulta
            System.out.println(res.getStatus());
			//Para obtener el codigoStatus
            System.out.println(res.getCodStatus());
            //Para obtener el uuid consultado
            System.out.println(res.getData().getUUIDConsultado());
	        //Para obtener el resultado de la consulta
            System.out.println(res.getData().getResultado());
	        //Para obtener los uuid padres
            System.out.println(res.getData().getUUIDsRelacionadosPadres());
	        //Para obtener los uuid hijo
            System.out.println(res.getData().getUUIDsRelacionadosHijos());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(res.getMessage());
            System.out.println(res.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Relacionados por PFX
</summary>

## Relacionados por PFX ##
Este método recibe el **PFX** en base64, **password** del certificado, **RFC**, y el **UUID** de la factura.
**Ejemplo de consumo de la librería para la consulta**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.relations.Relations;
import mx.com.sw.services.relations.response.RelationsResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Relations
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a consultar las facturas relacionadas
            Relations relations = new Relations("https://services.test.sw.com.mx", "user","password", null, 0);
            //Convertimos el PFX a base 64
            String pfx = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("PFX_EKU9003173C9.pfx")));
            //Datos
            String password = "12345678a";
            String rfc = "EKU9003173C9";
            
            RelationsResponse res = relations.getRelations(pfx, rfc, password,"106d7664-6a1d-4ec6-9c09-2aa27532ec59");
            //Para obtener el status de la consulta
            System.out.println(res.getStatus());
			//Para obtener el codigoStatus
            System.out.println(res.getCodStatus());
            //Para obtener el uuid consultado
            System.out.println(res.getData().getUUIDConsultado());
	        //Para obtener el resultado de la consulta
            System.out.println(res.getData().getResultado());
	        //Para obtener los uuid padres
            System.out.println(res.getData().getUUIDsRelacionadosPadres());
	        //Para obtener los uuid hijo
            System.out.println(res.getData().getUUIDsRelacionadosHijos());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(res.getMessage());
            System.out.println(res.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Relacionados por XML
</summary>

## Relacionados por XML ##
Este método recibe el **XML** de relacionados.
**Ejemplo de XML**
```xml
<?xml version="1.0" encoding="utf-8"?>
<PeticionConsultaRelacionados xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" Uuid="51BADE4D-8285-4597-A092-7DB1D50E5EFD" RfcReceptor="LAN7008173R5" RfcPacEnviaSolicitud="DAL050601L35" 
    xmlns="http://cancelacfd.sat.gob.mx">
    <Signature xmlns="http://www.w3.org/2000/09/xmldsig#">
        <SignedInfo>
            <CanonicalizationMethod Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315" />
            <SignatureMethod Algorithm="http://www.w3.org/2000/09/xmldsig#rsa-sha1" />
            <Reference URI="">
                <Transforms>
                    <Transform Algorithm="http://www.w3.org/2000/09/xmldsig#enveloped-signature" />
                </Transforms>
                <DigestMethod Algorithm="http://www.w3.org/2000/09/xmldsig#sha1" />
                <DigestValue>yYGkb9DCJgiGl2O4vCf5B3gXTTI=</DigestValue>
            </Reference>
        </SignedInfo>
        <SignatureValue>VBBjMXJgS/oCb4iTazKrPmhWSICGT5wbeTf8G4tW2UuqnKBLS1NWD7Uf37kAX8+GBB04So7YlTcEw3I/X2JkHDadSxCiZ940YksNIVddmCqllJL6giMHVQJoXcTH8WQ9pO/4TbREQZ8/jxPqIvxCXrOn963PKFrZFB8eo5RQxLUa12WMi5RWgh8dSUwQxS2W3dm1XXP8bqXPOjy7GtZc3ObeTLMcXo/YoLyEAobVCnP+igOEXLxKEN2HZPzHGtA2g/5ONxuhu3UTxix9D/5ItjXdH9nk7VL0A58Xgw3qv6Q0vjmlxyu7RO0E2O3D2tLejfExt3WvsjZ8xvEKXSFp+A==</SignatureValue>
        <KeyInfo>
            <X509Data>
                <X509IssuerSerial>
                    <X509IssuerName>OID.1.2.840.113549.1.9.2=Responsable: ACDMA, OID.2.5.4.45=SAT970701NN3, L=Coyoacán, S=Distrito Federal, C=MX, PostalCode=06300, STREET="Av. Hidalgo 77, Col. Guerrero", E=asisnet@pruebas.sat.gob.mx, OU=Administración de Seguridad de la Información, O=Servicio de Administración Tributaria, CN=A.C. 2 de pruebas(4096)</X509IssuerName>
                    <X509SerialNumber>3230303031303030303030333030303232383135</X509SerialNumber>
                </X509IssuerSerial>
                <X509Certificate>MIIFxTCCA62gAwIBAgIUMjAwMDEwMDAwMDAzMDAwMjI4MTUwDQYJKoZIhvcNAQELBQAwggFmMSAwHgYDVQQDDBdBLkMuIDIgZGUgcHJ1ZWJhcyg0MDk2KTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSkwJwYJKoZIhvcNAQkBFhphc2lzbmV0QHBydWViYXMuc2F0LmdvYi5teDEmMCQGA1UECQwdQXYuIEhpZGFsZ28gNzcsIENvbC4gR3VlcnJlcm8xDjAMBgNVBBEMBTA2MzAwMQswCQYDVQQGEwJNWDEZMBcGA1UECAwQRGlzdHJpdG8gRmVkZXJhbDESMBAGA1UEBwwJQ295b2Fjw6FuMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxITAfBgkqhkiG9w0BCQIMElJlc3BvbnNhYmxlOiBBQ0RNQTAeFw0xNjEwMjUyMTUyMTFaFw0yMDEwMjUyMTUyMTFaMIGxMRowGAYDVQQDExFDSU5ERU1FWCBTQSBERSBDVjEaMBgGA1UEKRMRQ0lOREVNRVggU0EgREUgQ1YxGjAYBgNVBAoTEUNJTkRFTUVYIFNBIERFIENWMSUwIwYDVQQtExxMQU43MDA4MTczUjUgLyBGVUFCNzcwMTE3QlhBMR4wHAYDVQQFExUgLyBGVUFCNzcwMTE3TURGUk5OMDkxFDASBgNVBAsUC1BydWViYV9DRkRJMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgvvCiCFDFVaYX7xdVRhp/38ULWto/LKDSZy1yrXKpaqFXqERJWF78YHKf3N5GBoXgzwFPuDX+5kvY5wtYNxx/Owu2shNZqFFh6EKsysQMeP5rz6kE1gFYenaPEUP9zj+h0bL3xR5aqoTsqGF24mKBLoiaK44pXBzGzgsxZishVJVM6XbzNJVonEUNbI25DhgWAd86f2aU3BmOH2K1RZx41dtTT56UsszJls4tPFODr/caWuZEuUvLp1M3nj7Dyu88mhD2f+1fA/g7kzcU/1tcpFXF/rIy93APvkU72jwvkrnprzs+SnG81+/F16ahuGsb2EZ88dKHwqxEkwzhMyTbQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAJ/xkL8I+fpilZP+9aO8n93+20XxVomLJjeSL+Ng2ErL2GgatpLuN5JknFBkZAhxVIgMaTS23zzk1RLtRaYvH83lBH5E+M+kEjFGp14Fne1iV2Pm3vL4jeLmzHgY1Kf5HmeVrrp4PU7WQg16VpyHaJ/eonPNiEBUjcyQ1iFfkzJmnSJvDGtfQK2TiEolDJApYv0OWdm4is9Bsfi9j6lI9/T6MNZ+/LM2L/t72Vau4r7m94JDEzaO3A0wHAtQ97fjBfBiO5M8AEISAV7eZidIl3iaJJHkQbBYiiW2gikreUZKPUX0HmlnIqqQcBJhWKRu6Nqk6aZBTETLLpGrvF9OArV1JSsbdw/ZH+P88RAt5em5/gjwwtFlNHyiKG5w+UFpaZOK3gZP0su0sa6dlPeQ9EL4JlFkGqQCgSQ+NOsXqaOavgoP5VLykLwuGnwIUnuhBTVeDbzpgrg9LuF5dYp/zs+Y9ScJqe5VMAagLSYTShNtN8luV7LvxF9pgWwZdcM7lUwqJmUddCiZqdngg3vzTactMToG16gZA4CWnMgbU4E+r541+FNMpgAZNvs2CiW/eApfaaQojsZEAHDsDv4L5n3M1CC7fYjE/d61aSng1LaO6T1mh+dEfPvLzp7zyzz+UgWMhi5Cs4pcXx1eic5r7uxPoBwcCTt3YI1jKVVnV7/w=</X509Certificate>
            </X509Data>
        </KeyInfo>
    </Signature>
</PeticionConsultaRelacionados>
```


**Ejemplo de consumo de la librería para la consulta**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.relations.Relations;
import mx.com.sw.services.relations.response.RelationsResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Relations
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a consultar las facturas relacionadas
            Relations relations = new Relations("https://services.test.sw.com.mx", "user","password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("relacionado.xml")), "UTF-8");
            
            RelationsResponse res = relations.getRelations(xml);
            //Para obtener el status de la consulta
            System.out.println(res.getStatus());
			//Para obtener el codigoStatus
            System.out.println(res.getCodStatus());
            //Para obtener el uuid consultado
            System.out.println(res.getData().getUUIDConsultado());
	        //Para obtener el resultado de la consulta
            System.out.println(res.getData().getResultado());
	        //Para obtener los uuid padres
            System.out.println(res.getData().getUUIDsRelacionadosPadres());
	        //Para obtener los uuid hijo
            System.out.println(res.getData().getUUIDsRelacionadosHijos());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(res.getMessage());
            System.out.println(res.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Relacionados por UUID
</summary>

## Relacionados por UUID ##
Este método recibe el **RFC** y el **UUID** de la factura.
***NOTA:*** El usuario deberá tener sus certificados en el administrador de timbres para la utilización de este método.
**Ejemplo de consumo de la librería para la consulta**
```java
import mx.com.sw.services.relations.Relations;
import mx.com.sw.services.relations.response.RelationsResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Relations
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a consultar las facturas relacionadas
            Relations relations = new Relations("https://services.test.sw.com.mx", "user","password", null, 0);
            RelationsResponse res = relations.getRelations("EKU9003173C9","106D7664-6A1D-4EC6-9C09-2AA27532EC59");
            
            //Para obtener el status de la consulta
            System.out.println(res.getStatus());
			//Para obtener el codigoStatus
            System.out.println(res.getCodStatus());
            //Para obtener el uuid consultado
            System.out.println(res.getData().getUUIDConsultado());
	        //Para obtener el resultado de la consulta
            System.out.println(res.getData().getResultado());
	        //Para obtener los uuid padres
            System.out.println(res.getData().getUUIDsRelacionadosPadres());
	        //Para obtener los uuid hijo
            System.out.println(res.getData().getUUIDsRelacionadosHijos());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(res.getMessage());
            System.out.println(res.getMessageDetail());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

## Consulta solicitudes pendientes Aceptar / Rechazar ##
A través de este servicio obtendremos una lista de los UUID que tenemos pendientes por aceptar o rechazar.
Este método recibe el **RFC** del cual obtendremos la lista.

<details>
  <summary>Ejemplos</summary>

**Ejemplo de consumo de la librería para la consulta**
```java
import mx.com.sw.services.pendings.Pendings;
import mx.com.sw.services.pendings.response.PendingsResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo Pending
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a consultar las facturas relacionadas
            Pendings pendings = new Pendings("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            PendingsResponse response = pendings.getPendings("EKU9003173C9");
            //Para obtener el status de la consulta
            System.out.println(response.getStatus());
			//Para obtener el codigoStatus
            System.out.println(response.getCodStatus());
            //Para obtener la lista de uuid's
            System.out.println(response.getData().getUUIDs());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

## Consulta Estatus SAT  ##

<details>
  <summary>Consulta Estatus SAT </summary>

  ####

Este servicio sirve para consultar el estatus de un CFDI antes y después de enviarlo a cancelar, con él sabremos sí puede ser cancelado de forma directa, o en caso de que se necesite consultar los CFDI relacionados para poder generar la cancelación.

:pushpin: ***NOTA:*** El servicio de consulta es de tipo SOAP y es proporcionado directamente por parte del SAT.

Este metodo recibe los siguientes parametros:
* RFC Emisor
* RFC Receptor
* Total declarado en el comprobante
* UUID del comprobante
* Sello digital del emisor (Últimos 8 caracteres)

**Ejemplo de consumo para conocer estatus de un comprobante**
```java
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo StatusCfdiResponse 
            //A esta le pasamos la URL del servicio
            StatusCfdiService app = new StatusCfdiService();
            StatusCfdiResponse response = null;

            //Enviamos los parametros del comprobante a verificar
            response = (StatusCfdiResponse) app.GetStatusCfdi("GOM0809114P5", "LSO1306189R5", "206.85", "021ea2fb-2254-4232-983b-9808c2ed831b", "WBjHe+9loaYIMM5wYwLxfhT6FnotG0KLRNheOlIxXoVMvsafsRdWY/aZ....");

            //Obtenemos el estatus de la petición
            System.out.println(response.Status);
            System.out.println(response.HttpStatusCode);

            //Se recuperar el estatus del comprobante y en que estado se encuentra
            System.out.println(response.codigoEstatus);
            System.out.println(response.estado);
            System.out.println(response.esCancelable);
            System.out.println(response.estatusCancelacion);

        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

## Aceptar / Rechazar ##
A través de estos siguientes métodos aceptaremos o rechazaremos los UUID.

<details>
<summary>
Aceptar / Rechazar por CSD
</summary>

## Aceptar / Rechazar por CSD ##
Este método recibe el **certificado** en base64, **llave** en base64, **RFC**, **password** del certificado, y los **UUID** con su respectiva acción.
**Ejemplo de consumo de la librería para la utilización**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import mx.com.sw.services.acceptreject.AcceptReject;
import mx.com.sw.services.acceptreject.requests.AcceptRejectItem;
import mx.com.sw.services.acceptreject.requests.EnumAcceptReject;
import mx.com.sw.services.acceptreject.responses.AcceptRejectResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AcceptReject
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a procesar las facturas con su acción
            AcceptReject acceptReject = new AcceptReject("https://services.test.sw.com.mx","T2lYQ0t4L0R...", null, 0);
            //Datos
            List<AcceptRejectItem> list = new ArrayList<AcceptRejectItem>() {{
                add(new AcceptRejectItem("7FA1C269-25AA-4898-BA2C-7CBCF6DB694B", EnumAcceptReject.Aceptacion));
                add(new AcceptRejectItem("6930A5C7-7225-4322-A013-4F2278763AC2", EnumAcceptReject.Aceptacion));
            }};
            String password = "12345678a";
            String rfc = "XIA190128J61";
            //Obtenemos Certificado y lo convertimos a Base 64 
            String cer = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.cer")));
            //Obtenemos LLave y lo convertimos a Base 64
            String key = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("CSD_Prueba_CFDI_EKU9003173C9.key")));
            AcceptRejectResponse response = acceptReject.setAction(cer, key, rfc, password, list);
            //Para obtener el status de la consulta
            System.out.println(response.getStatus());
			//Para obtener el codigoStatus
            System.out.println(response.getCodStatus());
            //Para obtener una lista con los folios
            System.out.println(response.getData().getFolios()));
	        //Para obtener el acuse
            System.out.println(response.getData().getAcuse());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
<summary>
Aceptar / Rechazar por PFX
</summary>

## Aceptar / Rechazar por PFX ##
Este método recibe el **PFX** en base64, **password** del certificado, **RFC**, y los **UUID** de las facturas con su respectiva acción a realizar.
**Ejemplo de consumo de la librería para la utilización**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import mx.com.sw.services.acceptreject.AcceptReject;
import mx.com.sw.services.acceptreject.requests.AcceptRejectItem;
import mx.com.sw.services.acceptreject.requests.EnumAcceptReject;
import mx.com.sw.services.acceptreject.responses.AcceptRejectResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AcceptReject
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a procesar las facturas con su acción
            AcceptReject acceptReject = new AcceptReject("https://services.test.sw.com.mx","T2lYQ0t4L0R...", null, 0);
            //Datos
            List<AcceptRejectItem> list = new ArrayList<AcceptRejectItem>() {{
                add(new AcceptRejectItem("7FA1C269-25AA-4898-BA2C-7CBCF6DB694B", EnumAcceptReject.Aceptacion));
                add(new AcceptRejectItem("6930A5C7-7225-4322-A013-4F2278763AC2", EnumAcceptReject.Aceptacion));
            }};
            String password = "12345678a";
            String rfc = "XIA190128J61";
            //Convertimos el PFX a base 64
            String pfx = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("PFX_EKU9003173C9.pfx")));
            AcceptRejectResponse response = acceptReject.setAction(pfx, rfc, password, list);
            //Para obtener el status de la consulta
            System.out.println(response.getStatus());
			//Para obtener el codigoStatus
            System.out.println(response.getCodStatus());
            //Para obtener una lista con los folios
            System.out.println(response.getData().getFolios()));
	        //Para obtener el acuse
            System.out.println(response.getData().getAcuse());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}

```
</details>

<details>
<summary>
Aceptar / Rechazar por XML
</summary>

## Aceptar / Rechazar por XML ##
Este método recibe el **XML** de aceptación / rechazo.
**Ejemplo de XML**
```xml
<?xml version='1.0' encoding='utf-8'?>
<SolicitudAceptacionRechazo xmlns:xsd='http://www.w3.org/2001/XMLSchema' 
    xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' RfcReceptor='LAN7008173R5' RfcPacEnviaSolicitud='DAL050601L35' Fecha='2018-08-22T18:38:05' 
    xmlns='http://cancelacfd.sat.gob.mx'>
    <Folios>
        <UUID>06a46e4b-b154-4c12-bb77-f9a63ed55ff2</UUID>
        <Respuesta>Aceptacion</Respuesta>
    </Folios>
    <Signature xmlns='http://www.w3.org/2000/09/xmldsig#'>
        <SignedInfo>
            <CanonicalizationMethod Algorithm='http://www.w3.org/TR/2001/REC-xml-c14n-20010315' />
            <SignatureMethod Algorithm='http://www.w3.org/2000/09/xmldsig#rsa-sha1' />
            <Reference URI=''>
                <Transforms>
                    <Transform Algorithm='http://www.w3.org/2000/09/xmldsig#enveloped-signature' />
                </Transforms>
                <DigestMethod Algorithm='http://www.w3.org/2000/09/xmldsig#sha1' />
                <DigestValue>AQ36cbqKJKHy5vaS6GhDTWtwKE4=</DigestValue>
            </Reference>
        </SignedInfo>
        <SignatureValue>HVlFUPmRLyxeztem827eaasDObRXi+oqedCNNvDyMsRizqsS99cHt5mJCEE4vWgpDGPGLrph/yd++R4aN+V562DPp9qreFkisFpEvJy5Z8o/KzG7vc5qqaD8z9ohPpRERPHvxFrIm3ryEBqnSV6zqJG02PuxkWvYonVc+B7RdsO5iAiDTMs9guUhOvHBK8BVXQHKCbUAPCp/4YepZ4LUkcdloCAMPsN0x9GaUty2RMtNJuwaRWy+5IIBUCeXXZmQhoQfS0QfPpCByt0ago5v+FocJQiYQrsUV/8mesmNw5JoOCmufQYliQFyZgsstV8+h76dU/rwLr6R8YlFOkTxKg==</SignatureValue>
        <KeyInfo>
            <X509Data>
                <X509IssuerSerial>
                    <X509IssuerName>OID.1.2.840.113549.1.9.2=Responsable: ACDMA, OID.2.5.4.45=SAT970701NN3, L=Coyoacán, S=Distrito Federal, C=MX, PostalCode=06300, STREET='Av. Hidalgo 77, Col. Guerrero', E=asisnet@pruebas.sat.gob.mx, OU=Administración de Seguridad de la Información, O=Servicio de Administración Tributaria, CN=A.C. 2 de pruebas(4096)</X509IssuerName>
                    <X509SerialNumber>3230303031303030303030333030303232383135</X509SerialNumber>
                </X509IssuerSerial>
                <X509Certificate>MIIFxTCCA62gAwIBAgIUMjAwMDEwMDAwMDAzMDAwMjI4MTUwDQYJKoZIhvcNAQELBQAwggFmMSAwHgYDVQQDDBdBLkMuIDIgZGUgcHJ1ZWJhcyg0MDk2KTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMSkwJwYJKoZIhvcNAQkBFhphc2lzbmV0QHBydWViYXMuc2F0LmdvYi5teDEmMCQGA1UECQwdQXYuIEhpZGFsZ28gNzcsIENvbC4gR3VlcnJlcm8xDjAMBgNVBBEMBTA2MzAwMQswCQYDVQQGEwJNWDEZMBcGA1UECAwQRGlzdHJpdG8gRmVkZXJhbDESMBAGA1UEBwwJQ295b2Fjw6FuMRUwEwYDVQQtEwxTQVQ5NzA3MDFOTjMxITAfBgkqhkiG9w0BCQIMElJlc3BvbnNhYmxlOiBBQ0RNQTAeFw0xNjEwMjUyMTUyMTFaFw0yMDEwMjUyMTUyMTFaMIGxMRowGAYDVQQDExFDSU5ERU1FWCBTQSBERSBDVjEaMBgGA1UEKRMRQ0lOREVNRVggU0EgREUgQ1YxGjAYBgNVBAoTEUNJTkRFTUVYIFNBIERFIENWMSUwIwYDVQQtExxMQU43MDA4MTczUjUgLyBGVUFCNzcwMTE3QlhBMR4wHAYDVQQFExUgLyBGVUFCNzcwMTE3TURGUk5OMDkxFDASBgNVBAsUC1BydWViYV9DRkRJMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgvvCiCFDFVaYX7xdVRhp/38ULWto/LKDSZy1yrXKpaqFXqERJWF78YHKf3N5GBoXgzwFPuDX+5kvY5wtYNxx/Owu2shNZqFFh6EKsysQMeP5rz6kE1gFYenaPEUP9zj+h0bL3xR5aqoTsqGF24mKBLoiaK44pXBzGzgsxZishVJVM6XbzNJVonEUNbI25DhgWAd86f2aU3BmOH2K1RZx41dtTT56UsszJls4tPFODr/caWuZEuUvLp1M3nj7Dyu88mhD2f+1fA/g7kzcU/1tcpFXF/rIy93APvkU72jwvkrnprzs+SnG81+/F16ahuGsb2EZ88dKHwqxEkwzhMyTbQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAJ/xkL8I+fpilZP+9aO8n93+20XxVomLJjeSL+Ng2ErL2GgatpLuN5JknFBkZAhxVIgMaTS23zzk1RLtRaYvH83lBH5E+M+kEjFGp14Fne1iV2Pm3vL4jeLmzHgY1Kf5HmeVrrp4PU7WQg16VpyHaJ/eonPNiEBUjcyQ1iFfkzJmnSJvDGtfQK2TiEolDJApYv0OWdm4is9Bsfi9j6lI9/T6MNZ+/LM2L/t72Vau4r7m94JDEzaO3A0wHAtQ97fjBfBiO5M8AEISAV7eZidIl3iaJJHkQbBYiiW2gikreUZKPUX0HmlnIqqQcBJhWKRu6Nqk6aZBTETLLpGrvF9OArV1JSsbdw/ZH+P88RAt5em5/gjwwtFlNHyiKG5w+UFpaZOK3gZP0su0sa6dlPeQ9EL4JlFkGqQCgSQ+NOsXqaOavgoP5VLykLwuGnwIUnuhBTVeDbzpgrg9LuF5dYp/zs+Y9ScJqe5VMAagLSYTShNtN8luV7LvxF9pgWwZdcM7lUwqJmUddCiZqdngg3vzTactMToG16gZA4CWnMgbU4E+r541+FNMpgAZNvs2CiW/eApfaaQojsZEAHDsDv4L5n3M1CC7fYjE/d61aSng1LaO6T1mh+dEfPvLzp7zyzz+UgWMhi5Cs4pcXx1eic5r7uxPoBwcCTt3YI1jKVVnV7/w=</X509Certificate>
            </X509Data>
        </KeyInfo>
    </Signature>
</SolicitudAceptacionRechazo>
```

**Ejemplo de consumo de la librería para la utilización**
```java
import mx.com.sw.services.acceptreject.AcceptReject;
import mx.com.sw.services.acceptreject.requests.EnumAcceptReject;
import mx.com.sw.services.acceptreject.responses.AcceptRejectResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AcceptReject
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a procesar las facturas con su acción
            AcceptReject acceptReject = new AcceptReject("https://services.test.sw.com.mx", "T2lYQ0t4L0R...", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("acceptReject.xml")), "UTF-8");
            AcceptRejectResponse response = acceptReject.setAction(xml);
            //Para obtener el status de la consulta
            System.out.println(response.getStatus());
			//Para obtener el codigoStatus
            System.out.println(response.getCodStatus());
            //Para obtener una lista con los folios
            System.out.println(response.getData().getFolios());
	        //Para obtener el acuse
            System.out.println(response.getData().getAcuse());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
```
</details>

<details>
<summary>
Aceptar / Rechazar por UUID
</summary>

## Aceptar / Rechazar por UUID ##
Este método recibe el **RFC**,  **UUID** de la factura y **acción** a realizar.
***NOTA:*** El usuario deberá tener sus certificados en el administrador de timbres para la utilización de este método.
**Ejemplo de consumo de la librería para la utilización**
```java
import mx.com.sw.services.acceptreject.AcceptReject;
import mx.com.sw.services.acceptreject.requests.EnumAcceptReject;
import mx.com.sw.services.acceptreject.responses.AcceptRejectResponse;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo AcceptReject
            //A esta le pasamos la Url, usuario y password o token de authentication
            //Automaticamente despues de obtenerlo se procedera a procesar las facturas con su acción
            AcceptReject acceptReject = new AcceptReject("https://services.test.sw.com.mx", "user","password", null, 0);
            AcceptRejectResponse response = acceptReject.setAction("XIA190128J61",
            "a98d4c19-8b05-4ab0-b231-8e4684a6e6c6", EnumAcceptReject.Aceptacion);
            //Para obtener el status de la consulta
            System.out.println(response.getStatus());
			//Para obtener el codigoStatus
            System.out.println(response.getCodStatus());
            //Para obtener una lista con los folios
            System.out.println(response.getData().getFolios());
	        //Para obtener el acuse
            System.out.println(response.getData().getAcuse());
	        //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

## TimbradoV4 ##

### **Email** ###
Este servicio recibe un comprobante CFDI para ser timbrado y recibe un listado de uno o hasta 5 correos electrónicos a los que se requiera enviar el XML timbrado.
Existen varias versiones de respuesta a este método, las cuales puede consultar mas a detalle en el siguiente [link](https://developers.sw.com.mx/knowledge-base/versiones-de-respuesta-timbrado/).

:pushpin: ***NOTA:*** En caso de que no se cuente con una plantilla pdf customizada los pdf’s serán generados con las plantillas genéricas.

<details>
  <summary>Timbrado CFDI (StampV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.stamp.StampV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo StampV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            StampV4 stamp = new StampV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            List<String> email = Arrays.asList("test@test.com.mx");
            StampResponseV1 response = stamp.timbrarV1(xml, email, null, false, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}

```
**Ejemplo de consumo de la librería en base64 con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.stamp.StampV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo StampV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            StampV4 stamp = new StampV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            byte[] xml = Files.readAllBytes(Paths.get("file.xml"));
            String xml64 = Base64.getEncoder().encodeToString(xml);
            List<String> email = Arrays.asList("test@test.com.mx");
            StampResponseV1 response = stamp.timbrarV1(xml, email, null, false, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
  <summary>Emisión Timbrado (IssueV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.issue.IssueV4
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueV4 stamp = new IssueV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            List<String> email = Arrays.asList("test@test.com.mx");
            StampResponseV1 response = stamp.timbrarV1(xml, email, null, false, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}

```
**Ejemplo de consumo de la librería en base64 con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.issue.IssueV4
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueV4 stamp = new IssueV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            byte[] xml = Files.readAllBytes(Paths.get("file.xml"));
            String xml64 = Base64.getEncoder().encodeToString(xml);
            List<String> email = Arrays.asList("test@test.com.mx");
            StampResponseV1 response = stamp.timbrarV1(xml, email, null, false, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```

</details>

<details>
  <summary>Emisión Timbrado Json (IssueJsonV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.issue.IssueJsonV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueJsonV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueJsonV4 stamp = new IssueJsonV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            List<String> email = Arrays.asList("test@test.com.mx");
            String json = new String(Files.readAllBytes(Paths.get("pruebas.json")), "UTF-8");
            StampResponseV1 response = stamp.timbrarV1(json, email, null, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```

</details>

### **CustomId** ###
Este servicio recibe un comprobante CFDI para ser timbrado y que recibe un header conocido como CustomID, el cuál tiene el objetivo de agregar un filtro adicional al timbrado para evitar la duplicidad de timbrado.
El CustomId es un string y el valor es asignado por el usuario, el cual tiene un límite de 100 caracteres.


<details>
  <summary>Timbrado CFDI (StampV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.stamp.StampV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo StampV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            StampV4 stamp = new StampV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            //creamos la variable de nuestro customId
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}

```
**Ejemplo de consumo de la librería en base64 con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.stamp.StampV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo StampV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            StampV4 stamp = new StampV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            byte[] xml = Files.readAllBytes(Paths.get("file.xml"));
            String xml64 = Base64.getEncoder().encodeToString(xml);
            //creamos la variable de nuestro customId
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
  <summary>Emisión Timbrado (IssueV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.issue.IssueV4
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueV4 stamp = new IssueV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            //creamos la variable de nuestro customId
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}

```
**Ejemplo de consumo de la librería en base64 con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.issue.IssueV4
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueV4 stamp = new IssueV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            byte[] xml = Files.readAllBytes(Paths.get("file.xml"));
            String xml64 = Base64.getEncoder().encodeToString(xml);
            //creamos la variable de nuestro customId
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
  <summary>Emisión Timbrado Json (IssueJsonV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.issue.IssueJsonV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueJsonV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueJsonV4 stamp = new IssueJsonV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            String json = new String(Files.readAllBytes(Paths.get("pruebas.json")), "UTF-8");
            //creamos la variable de nuestro customId
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(json, null, customId , false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

### **PDF** ###
Este servicio recibe un comprobante CFDI para ser timbrado y que recibe un header conocido como extra mediante el cual se confirma la generación de un PDF del CFDI timbrado que será guardado en automático en el ADT.

:pushpin: ***NOTA:*** En caso de que no se cuente con una plantilla PDF customizada los PDF’s serán generados con las plantillas genéricas.

<details>
  <summary>Timbrado CFDI (StampV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.stamp.StampV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo StampV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            StampV4 stamp = new StampV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            //creamos la variable de nuestro customId
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, null, true, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}

```
**Ejemplo de consumo de la librería en base64 con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.stamp.StampV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo StampV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            StampV4 stamp = new StampV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            byte[] xml = Files.readAllBytes(Paths.get("file.xml"));
            String xml64 = Base64.getEncoder().encodeToString(xml);
            //creamos la variable de nuestro customId
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, null, true, true);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
  <summary>Emisión Timbrado (IssueV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.issue.IssueV4
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueV4 stamp = new IssueV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            String xml = new String(Files.readAllBytes(Paths.get("file.xml")), "UTF-8");
            StampResponseV1 response = stamp.timbrarV1(xml, null, null, true, false);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}

```
**Ejemplo de consumo de la librería en base64 con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import mx.com.sw.services.issue.IssueV4
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueV4 stamp = new IssueV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            byte[] xml = Files.readAllBytes(Paths.get("file.xml"));
            String xml64 = Base64.getEncoder().encodeToString(xml);
            StampResponseV1 response = stamp.timbrarV1(xml, null, null, true, true);

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

<details>
  <summary>Emisión Timbrado Json (IssueJsonV4)</summary>

<br>

**Ejemplo de consumo de la librería con la version de respuesta 1**
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import mx.com.sw.services.issue.IssueJsonV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;

public class App {
    
    public static void main(String[] args)
    {
        try 
        {
            //Creamos una instancia de tipo IssueJsonV4
            //A esta le pasamos la Url, usuario y password o token
            //Automaticamente despues de obtenerlo se procedera a timbrar
            IssueJsonV4 stamp = new IssueJsonV4("https://services.test.sw.com.mx", "user", "password", null, 0);
            String json = new String(Files.readAllBytes(Paths.get("pruebas.json")), "UTF-8");
            StampResponseV1 response = stamp.timbrarV1(json, null, null , true;

            //Para obtener el estatus
            System.out.println(response.getStatus());
            //Para obtener el TFD
            System.out.println(response.getData().getTFD());
            //En caso de error se pueden consultar los siguientes campos
            System.out.println(response.getMessage());
            System.out.println(response.getMessageDetail());
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }  
    }
}
```
</details>

---

Para mayor referencia de un listado completo de los servicios favor de visitar el siguiente [link](http://developers.sw.com.mx/).

Si deseas contribuir a la libreria o tienes dudas envianos un correo a **soporte@sw.com.mx**.
