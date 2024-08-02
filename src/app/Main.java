package app;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        Optional<User> userById = userRepository.findUserById(1);
        userById.ifPresent(user -> System.out.println("Користувач знайдений за ID: " + user));
        userById.orElseThrow(() -> new RuntimeException("Користувача не знайдено за ID"));

        Optional<User> userByEmail = userRepository.findUserByEmail("volodymyr@gmail.com");
        userByEmail.ifPresent(user -> System.out.println("Користувача знайдено електронною поштою: " + user));
        userByEmail.orElseThrow(() -> new RuntimeException("Користувач не знайдений електронною поштою"));

        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresent(users -> System.out.println("Загальна кількість користувачів: " + users.size()));
        allUsers.orElseThrow(() -> new RuntimeException("Користувачів не знайдено"));
    }
}
