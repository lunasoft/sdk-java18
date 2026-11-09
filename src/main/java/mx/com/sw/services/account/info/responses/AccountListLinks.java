package mx.com.sw.services.account.info.responses;

import com.google.gson.annotations.SerializedName;

/**
 * AccountListLinks - Rutas de navegación entre páginas de la consulta de usuarios.
 * Cada ruta es la cadena de consulta (por ejemplo "?page=2&amp;perPage=10").
 * Prev y Next son null cuando no hay página anterior o siguiente.
 */
public class AccountListLinks {
    @SerializedName("Self")
    private String self;
    @SerializedName("First")
    private String first;
    @SerializedName("End")
    private String end;
    @SerializedName("Prev")
    private String prev;
    @SerializedName("Next")
    private String next;

    public String getSelf() {
        return self;
    }

    public String getFirst() {
        return first;
    }

    public String getEnd() {
        return end;
    }

    public String getPrev() {
        return prev;
    }

    public String getNext() {
        return next;
    }
}
