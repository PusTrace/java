import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String sourceText = args[0];
        String[] words = sourceText.split("_");

        // 1. Поменять местами третье и седьмое слово
        if (words.length >= 7) {
            String temp = words[2];
            words[2] = words[6];
            words[6] = temp;
        }

        // 2. Удалить первое слово вместе с подчёркиванием
        String[] newWords = new String[words.length - 1];
        System.arraycopy(words, 1, newWords, 0, newWords.length);

        // 3. Инвертировать первое слово
        newWords[0] = new StringBuilder(newWords[0]).reverse().toString();

        // 4. Привести четвёртое слово к нижнему регистру
        if (newWords.length >= 4) {
            newWords[3] = newWords[3].toLowerCase();
        }

        // 5. Заменить все буквы "к" на "у"
        for (int i = 0; i < newWords.length; i++) {
            newWords[i] = newWords[i].replace('к', 'у');
        }

        // 6. Привести нечётные слова к нижнему регистру
        for (int i = 0; i < newWords.length; i += 2) { // индексы нечётных слов 0, 2, 4 и т.д.
            newWords[i] = newWords[i].toLowerCase();
        }

        // 7. Повернуть первое слово циклически на 2 символа вправо
        newWords[0] = rotateRight(newWords[0], 2);

        // Собираем строку обратно
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < newWords.length - 1; i++) {
            result.append(newWords[i]).append("_");
        }
        result.append(newWords[newWords.length - 1]);

        // Выводим результат на экран
        System.out.println(result.toString());
    }

    // Метод для циклического сдвига строки вправо
    private static String rotateRight(String str, int positions) {
        int length = str.length();
        positions = positions % length;
        return str.substring(length - positions) + str.substring(0, length - positions);
    }
}
