package ResponseModels;

public class SuccessRegResp {
    private Integer id;
    private String token;

    public SuccessRegResp() {
    }

    public SuccessRegResp(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
