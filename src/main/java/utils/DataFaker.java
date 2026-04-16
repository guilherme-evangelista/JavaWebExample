package utils;

import com.github.javafaker.Faker;

public class DataFaker {
    
    private static final Faker faker = new Faker();

    public static String getNome() {
        return faker.name().fullName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getSenha() {
        return faker.internet().password();
    }
}
