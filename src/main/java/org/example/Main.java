import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Створюємо список користувачів
        List<User> users = Arrays.asList(
                new User("Аня", 25, "anya@example.com"),
                new User("Олександр", 17, "oleksandr@example.com"),
                new User("Марина", 22, "marina@example.com"),
                new User("Іван", 16, "ivan@example.com"),
                new User("Тетяна", 30, "tetiana@example.com")
        );

        // 1. Відфільтрувати користувачів старше 18 років
        List<User> older18 = users.stream()
                .filter(user -> user.getAge() > 18)
                .collect(Collectors.toList());

        // 2. Отримати список email-адрес користувачів старше 18
        List<String> emails = older18.stream()
                .map(User::getEmail)
                .collect(Collectors.toList());

        System.out.println("Користувачі старше 18: " + emails);

        // 3. Знайти користувача з найменьшим віком
        Optional<User> youngestUser = users.stream()
                .min(Comparator.comparingInt(User::getAge));

        if (youngestUser.isPresent()) {
            System.out.println("Користувач з найменшим віком: " + youngestUser.get().getName() +
                    ", вік: " + youngestUser.get().getAge());
        }

        // 4. Порахувати кількість користувачів
        long totalUsers = users.size();
        System.out.println("Загальна кількість користувачів: " + totalUsers);
    }
}