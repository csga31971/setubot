package xyz.csga.entity;

public class EncryptedPassportElement {
    private String type;
    private String data;
    private String phone_number;
    private String email;
    private PassportFile[] files;
    private PassportFile front_side;
    private PassportFile reverse_side;
    private PassportFile selfie;
    private PassportFile[] translation;
    private String hash;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PassportFile[] getFiles() {
        return files;
    }

    public void setFiles(PassportFile[] files) {
        this.files = files;
    }

    public PassportFile getFront_side() {
        return front_side;
    }

    public void setFront_side(PassportFile front_side) {
        this.front_side = front_side;
    }

    public PassportFile getReverse_side() {
        return reverse_side;
    }

    public void setReverse_side(PassportFile reverse_side) {
        this.reverse_side = reverse_side;
    }

    public PassportFile getSelfie() {
        return selfie;
    }

    public void setSelfie(PassportFile selfie) {
        this.selfie = selfie;
    }

    public PassportFile[] getTranslation() {
        return translation;
    }

    public void setTranslation(PassportFile[] translation) {
        this.translation = translation;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
