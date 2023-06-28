package api_Retrofit_endpoints;

import api_Retrofit_models.*;
import retrofit2.Call;
import retrofit2.http.*;


// сервісний клас в якому є методи - ендпойнти
public interface UserService {

    // отримання списка користувачів
    @GET("api/users")
    Call<UserListResponse> getUserList(@Query("page") int pageParam);  //серіалізація обєкта -> json переконвертувати в обєкт
    //для того щоб добавити ?параметри в запит, використовується анотація Query.



    //отримання одного користувача по айді
    @GET("api/users/{id}")
    Call<SingleUserResponse> getUserById(@Path("id") int id); //параметер айді, який буде вставлений в ендпойнт


    //створення нового юзера
    @POST("api/users/{id}")
    Call<CreateUserResponse> createUser (@Body UserRequest userRequest);

    //оновлення даних юзера
    @PUT("api/users/{id}")
    Call<UserUpdateResponse> updateUserById(@Path("id") int id,
                                            @Body UserRequest userRequest);

    //видалення користуванча по id
    @DELETE("api/users/{id}")
    Call<Void> deleteUserById(@Path("id") int id); //запит нічого не повертає, тільки статус код
    //тому вказується войд = нічого не повертається




}
