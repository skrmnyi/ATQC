package api_RestAssure2;

import com.google.gson.annotations.Expose;

public class UserData {
    private Integer id;
    private String  email;
    private String first_name;
    private String last_name;
    private String avatar;


    //за допомогою конструктора заповнюємо відповідь сервара
    public UserData(Integer id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    //за допомогою гетерів отримуємо значення кожного необхідного поля
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name  () {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}


