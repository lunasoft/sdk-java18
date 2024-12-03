package mx.com.sw.services.account.balance;

/**
 * AccountBalanceRequest.
 */
public class AccountBalanceRequest {
    private int Stamps;//Timbres de la operacion de eliminacion o adicion de timbres
    private String Comentario;//Comentario opcional de la operacion de eliminacion o adicion de timbres

    /**
     * Constructor de la clase.
     * @param stamps stamps del movimiento.
     * @param comentario comentario del movimiento.
     */
    public AccountBalanceRequest(int stamps, String comentario) {
        this.Stamps = stamps;
        this.Comentario = comentario;
    }

      /**
     * Obtiene los timbres.
     * @return int
     */
    public int getStamps() {
        return this.Stamps;
    }
    /**
     * Obtiene el comentario.
     * @return String
     */
    public String getComentario() {
        return this.Comentario;
    }
}
