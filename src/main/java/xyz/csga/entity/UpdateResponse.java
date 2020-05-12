package xyz.csga.entity;

public class UpdateResponse {
    private boolean ok;
    private Update[] result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Update[] getResult() {
        return result;
    }

    public void setResult(Update[] result) {
        this.result = result;
    }
}
