package mx.com.sw.services.cfdi40.helpers;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
 * BaseStamp Está clase se utiliza como base para las pruebas
 * unitarias de las diferentes versiones de timbrados disponibles.
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
 */
public abstract class BaseStamp {

    private final BuildSettings settings = new BuildSettings();

    public BuildSettings getSettings() {
        return settings;
    }

    /**
     * Timbra un documento CFDI con la versión de repsuesta 1.
     * @param fileName String de la ubicación del archivo que contiene el CFDI.
     * @param stampVersion indica la versión del timbrado que se utilizara.
     * @param signed indica si el archivo se sellará.
     * @param isBase64 indica si es base64.
     * @return StampResponseV1
     * @see StampResponseV1
     * @throws ServicesException exception en caso de error.
     */
    public abstract StampResponseV1 stampResponseV1(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException;

    /**
     * Timbra un documento CFDI con la versión de repsuesta 2.
     * @param fileName String de la ubicación del archivo que contiene el CFDI.
     * @param stampVersion indica la versión del timbrado que se utilizara.
     * @param signed indica si el archivo se sellará.
     * @param isBase64 indica si es base64.
     * @return StampResponseV2
     * @see StampResponseV2
     * @throws ServicesException exception en caso de error.
     */
    public abstract StampResponseV2 stampResponseV2(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException;

    /**
     * Timbra un documento CFDI con la versión de repsuesta 3.
     * @param fileName String de la ubicación del archivo que contiene el CFDI.
     * @param stampVersion indica la versión del timbrado que se utilizara.
     * @param signed indica si el archivo se sellará.
     * @param isBase64 indica si es base64.
     * @return StampResponseV3
     * @see StampResponseV3
     * @throws ServicesException exception en caso de error.
     */
    public abstract StampResponseV3 stampResponseV3(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException;

    /**
     * Timbra un documento CFDI con la versión de repsuesta 4.
     * @param fileName String de la ubicación del archivo que contiene el CFDI.
     * @param stampVersion indica la versión del timbrado que se utilizara.
     * @param signed indica si el archivo se sellará.
     * @param isBase64 indica si es base64.
     * @return StampResponseV4
     * @see StampResponseV4
     * @throws ServicesException exception en caso de error.
     */
    public abstract StampResponseV4 stampResponseV4(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException;
}
