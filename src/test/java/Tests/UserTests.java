package Tests;

import Endpoints.UserService;
import ResponseModels.*;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTests  {

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create()) //спосіб за допомогою якого буде конвертуватись json
            .build();

    private final UserService userService = retrofit.create(UserService.class); //оголошуємо інтерфейс, і через метод create
    //реалізуємо інтерфейс який вже створили - > відбувається зчитування всіх анотацій всередині класа UserService


    @Test
    public void testUserListPage() throws IOException {
        int page = 1;
        Response<UserListResponse> response = userService.getUserList(page).execute();
        assertTrue(response.isSuccessful());

        UserListResponse rootResponse = response.body();
        assertEquals(page, rootResponse.getPage()); //перевірка що сторінка з ріспонсу, дорівнює сторінці з запиту

        List<UserResponse> userData = rootResponse.getData();
        assertTrue(userData.size() > 0); //ріспонс повернув більше чим 0 обєктів
    }

    @Test
    public void testGetUserById() throws IOException {
        int id = 2;
        Response<SingleUserResponse> response = userService.getUserById(id).execute();  //дуже важливо правильно визначити
        //клас в якому повинен бути json відповіді  і щоб в класі не було помилок
        assertTrue(response.isSuccessful());
        SingleUserResponse userResponse = response.body();
        assertEquals(id, userResponse.getData().getId()); //id юзера який в запиті, повертається від сервера в ріспонсі
    }

    @Test
    public void createUserTest() throws IOException {
        String correctTimePattern = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z";
        String name = "Vasyl";
        String job = "QA";
        UserRequest userRequest = new UserRequest(name, job);

        Response<CreateUserResponse> response = userService.createUser(userRequest).execute(); // дані виконого запиту
        //запишуться в response

        assertTrue(response.isSuccessful());
        assertEquals(name, response.body().getName());
        assertEquals(job, response.body().getJob()); //посада співпадає
        assertTrue(response.body().getCreatedAt().matches(correctTimePattern)); //час співпадає з патерном
    }

    @Test
    public void updateUserById() throws IOException {
        String name = "Stepan";
        String job = "dev";
        int id = 891;
        UserRequest userRequest = new UserRequest(name, job);
        Response<UserUpdateResponse> response = userService.updateUserById(id, userRequest).execute();

        assertTrue(response.isSuccessful());
        assertEquals(name, response.body().getName());
        assertEquals(job, response.body().getJob()); //посада співпадає
    }

    @Test
    public void deleteUserTest() throws IOException {
        Response<Void> response = userService.deleteUserById(4).execute(); //повертається пуста відповідь, тому <?> - замість пустого класу.
        //також можна написати як <Void>
        assertTrue(response.isSuccessful());
        assertEquals(204, response.code());

    }
}
