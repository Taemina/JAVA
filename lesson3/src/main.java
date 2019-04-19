import java.util.*;
public class main {

    public static void main(String[] args) {
        /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         Посчитать сколько раз встречается каждое слово.
         */
        Map<String, Integer> colors = new HashMap<>();
        String[] words = {
                "red", "green", "pink", "pink", "black", "white",
                "yellow", "white", "yellow", "green", "blue", "blue", "azure",
                "yellow", "yellow", "azure", "green", "azure", "black", "blue"
                };

        for (int i = 0; i < words.length; i++) {
                if (colors.containsKey(words[i]))
                     colors.put(words[i], colors.get(words[i]) + 1);
                else
                     colors.put(words[i], 1);
        }
        System.out.println(colors);

      /*
      2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
      В этот телефонный справочник с помощью метода add() можно добавлять записи.
      С помощью метода get() искать номер телефона по фамилии.
      Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
      тогда при запросе такой фамилии должны выводиться все телефоны.
       */
        Phonebook book = new Phonebook();

        book.add("Ivanov", "89242857777");
        book.add("Ivanov", "89235656766");
        book.add("Ivanov", "89235657346");
        book.add("Petrov", "89235673457");
        book.add("Petrov", "89235657756");
        book.add("Sidorov", "89234677685");

        System.out.println(book.get("Petrov"));
    }





}
