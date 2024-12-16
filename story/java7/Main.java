import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error");
            return;
    }
        String key = args[0];
        Map<String, List<String>> dict = new HashMap<>();
        dict.put("Table", Arrays.asList("Таблица", "Стол", "Доска", "Расписание"));
        dict.put("House", Arrays.asList("Дом", "Здание", "Строение"));
        dict.put("Cat", Arrays.asList("Кот"));
        dict.put("Window", Arrays.asList("Окно", "Витрина"));
        dict.put("Dog", Arrays.asList("Собака"));

        if (dict.containsKey(key)) {
            System.out.println(dict.get(key).toString());
        } else {
            for (Map.Entry<String, List<String>> entry : dict.entrySet()) {
                if (entry.getValue().contains(key)) {
                    System.out.println(entry.getKey());
                    return;
                }
            }
        }
    }
}