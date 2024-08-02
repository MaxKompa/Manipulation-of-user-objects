package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        // Initial users for demonstration
        users.add(new User(1, "Ігор Петров", "igorpetrov@gmail.com"));
        users.add(new User(2, "Володимир Деламейн", "volodymyr@gmail.com"));
        users.add(new User(3, "Аліса Кудряшева", "alice@gmail.com"));
    }

    public Optional<User> findUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        return Optional.of(users);
    }
}
