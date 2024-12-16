import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String sourceText = args[0];

        // Разделяем исходную строку на слова
        String[] words = sourceText.split("_");

        // 2 Удаляем первое слово вместе с подчёркиванием
        String[] newWords = new String[words.length - 1];
        System.arraycopy(words, 1, newWords, 0, newWords.length);

        // 1 Поменяем местами третье и седьмое слово поскольку я удалил 1 слово мы меняем 2 и 6
        if (newWords.length >= 7) {
            String temp = newWords[1];
            newWords[1] = newWords[5];
            newWords[5] = temp;
        }

        // 3 Инвертируем первое слово
        newWords[0] = new StringBuilder(newWords[0]).reverse().toString();

        // 4 Приводим четвёртое слово к нижнему регистру
        if (newWords.length >= 4) {
            newWords[3] = newWords[3].toLowerCase();
        }

        // 5 Заменяем все буквы 'к' на 'у'
        for (int i = 0; i < newWords.length; i++) {
            newWords[i] = newWords[i].replace('к', 'у');
        }

        // Собираем строку обратно
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < newWords.length - 1; i++) {
            result.append(newWords[i]).append("_");
        }
        result.append(newWords[newWords.length - 1]);

        // Выводим результат на экран
        System.out.println(result.toString());
    }
}
