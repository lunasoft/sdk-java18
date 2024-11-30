package mx.com.sw.services.account.balance.responses;


public class AccountBalanceData {
    private String idUserBalance;
    private String idUser;
    private Integer stampsBalance;
    private Integer stampsUsed;
    private Integer stampsAssigned;
    private boolean isUnlimited;
    private String expirationDate;
    private LastTransaction lastTransaction;

    // Getters y Setters
    public String getIdUserBalance() {
        return idUserBalance;
    }

    public void setIdUserBalance(String idUserBalance) {
        this.idUserBalance = idUserBalance;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Integer getStampsBalance() {
        return stampsBalance;
    }

    public void setStampsBalance(Integer stampsBalance) {
        this.stampsBalance = stampsBalance;
    }

    public Integer getStampsUsed() {
        return stampsUsed;
    }

    public void setStampsUsed(Integer stampsUsed) {
        this.stampsUsed = stampsUsed;
    }

    public Integer getStampsAssigned() {
        return stampsAssigned;
    }

    public void setStampsAssigned(Integer stampsAssigned) {
        this.stampsAssigned = stampsAssigned;
    }

    public boolean isUnlimited() {
        return isUnlimited;
    }

    public void setUnlimited(boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LastTransaction getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(LastTransaction lastTransaction) {
        this.lastTransaction = lastTransaction;
    }
}
