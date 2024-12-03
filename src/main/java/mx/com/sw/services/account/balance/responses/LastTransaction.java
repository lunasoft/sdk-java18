package mx.com.sw.services.account.balance.responses;

/**
 * LastTransaction - Clase con la información de la última transacción.
 */
public class LastTransaction {
    private int folio;
    private String idUser;
    private String idUserReceiver;
    private String nameReceiver;
    private Integer stampsIn;
    private Integer stampsOut;
    private Integer stampsCurrent;
    private String comment;
    private String date;
    private boolean isEmailSent;

    // Getters y Setters
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUserReceiver() {
        return idUserReceiver;
    }

    public void setIdUserReceiver(String idUserReceiver) {
        this.idUserReceiver = idUserReceiver;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public Integer getStampsIn() {
        return stampsIn;
    }

    public void setStampsIn(Integer stampsIn) {
        this.stampsIn = stampsIn;
    }

    public Integer getStampsOut() {
        return stampsOut;
    }

    public void setStampsOut(Integer stampsOut) {
        this.stampsOut = stampsOut;
    }

    public Integer getStampsCurrent() {
        return stampsCurrent;
    }

    public void setStampsCurrent(Integer stampsCurrent) {
        this.stampsCurrent = stampsCurrent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isEmailSent() {
        return isEmailSent;
    }

    public void setEmailSent(boolean isEmailSent) {
        this.isEmailSent = isEmailSent;
    }
}
