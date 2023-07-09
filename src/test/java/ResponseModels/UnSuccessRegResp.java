package ResponseModels;

public class UnSuccessRegResp {
    private String error;

    public UnSuccessRegResp() {
    }

    public UnSuccessRegResp(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
