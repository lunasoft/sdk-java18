package mx.com.sw.services.account.info.responses;

/**
 * AccountInfoData - Clase con la información de la cuenta del cliente.
 * 
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public class AccountInfoData {
    private String idUser;
    private String idDealer;
    private String name;
    private String taxId;
    private String username;
    private String lastPasswordChange;
    private String email;
    private boolean isAdmin;
    private int profile;
    private boolean isActive;
    private String registeredDate;
    private String accessToken;
    private String phone;
    private int stamps;
    private boolean isUnlimited;
    private String data;
    private String status;

    // Getters y Setters

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdDealer() {
        return idDealer;
    }

    public void setIdDealer(String idDealer) {
        this.idDealer = idDealer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(String lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStamps() {
        return stamps;
    }

    public void setStamps(int stamps) {
        this.stamps = stamps;
    }

    public boolean isUnlimited() {
        return isUnlimited;
    }

    public void setUnlimited(boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
