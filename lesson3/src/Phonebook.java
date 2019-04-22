import java.util.*;

public class Phonebook {
    private Map<String, HashSet<String>> phone_book;

    Phonebook() {
        this.phone_book = new HashMap<>();
    }

    void add(String lastName, String phone) {
        HashSet<String> numbers;

        if (phone_book.containsKey(lastName)) {
            numbers = phone_book.get(lastName);
        } else {
            numbers = new HashSet<>();
        }
            numbers.add(phone);
            phone_book.put(lastName, numbers);

    }

    Set<String> get(String lastName) {
        return phone_book.get(lastName);
    }
}
