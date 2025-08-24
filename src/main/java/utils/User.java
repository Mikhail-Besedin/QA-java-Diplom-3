package utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;
import com.github.javafaker.Faker;
@Getter
@Setter
public class User {
    private String email;
    private String password;
    private String name;
    private static final Faker faker = new Faker(new Locale("ru"));

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public static User getRandom() {
        return new User(
                faker.internet().emailAddress(),
                faker.internet().password(8, 12, true, true),
                faker.name().firstName()
        );
    }
    public static User getUserInvalidPassword() {
        return new User(getRandom().getEmail(), faker.internet().password(1,5), getRandom().getName());
    }}
