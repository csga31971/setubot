package xyz.csga.entity;

public class PassportData {
    private EncryptedPassportElement[] data;
    private EncryptedCredentials credentials;

    public EncryptedPassportElement[] getData() {
        return data;
    }

    public void setData(EncryptedPassportElement[] data) {
        this.data = data;
    }

    public EncryptedCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(EncryptedCredentials credentials) {
        this.credentials = credentials;
    }
}
