package mx.com.sw.services.account.balance;

public class AccountBalanceRequest {
    private String Comentario; //Comentario opcional de la operacion de eliminacion o adicion de timbres

    /**
     * Constructor de la clase.
     * 
     * @param comentario comentario del movimiento.
     */
    public AccountBalanceRequest(String comentario) {
        this.Comentario = comentario;
    }

    /**
     * Obtiene el comentario
     * 
     * @return String
     */
    public String getComentario() {
        return this.Comentario;
    }
}
