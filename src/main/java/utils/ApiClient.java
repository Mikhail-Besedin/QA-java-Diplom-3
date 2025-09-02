package utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;



import static io.restassured.RestAssured.given;



public class ApiClient {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";
    public static final String CREATE_USER = BASE_URL + "/auth/register";
    public static final String LOGIN_USER = BASE_URL + "/auth/login";
    public static final String USER_ACTIONS = BASE_URL + "/auth/user";


    @Step("Создание пользователя")
    public static Response createUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(CREATE_USER);
    }

    @Step("Удаление пользователя")
    public static void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .delete(USER_ACTIONS);
    }


    @Step("Авторизация пользователя")
    public static Response loginUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(LOGIN_USER);

    }}