package rzp.oop.grades;

import java.util.List;
import java.util.HashMap;

/**
 * Таблица соответствия <b>Студента</b> к <b>Списку лаб</b> к <b>Оценкам по этим лабам</b><br>
 * Рекомендуется использовать класс {@link java.util.HashMap}<br>
 * Ключ - имя студента, значение - список лаб (например, в виде собственного класса-обёртки)
 */
public interface GradesTable {
	/**
	 * Инициализирует таблицу успеваемости<br>
	 * По умолчанию все состояния лабораторных работ равны 0
	 * @param students список имён студентов
	 * @param labs список названий лабораторных работ
	 */
	void init(List<String> students, List<String> labs);
	
	/**
	 * Устанавливает состояние лабораторной работы
	 * @param student имя студента
	 * @param lab название лабораторной работы
	 * @param state состояние лабораторной работы
	 */
	void setState(String student, String lab, int state);
	
	/**
	 * Возвращает состояние лабораторной работы
	 * @param student имя студента
	 * @param lab название лабораторной работы
	 * @return состояние лабораторной работы
	 */
	int getState(String student, String lab);
	
	/**
	 * Вычисляет среднее значение состояний лабораторных работ
	 * @param student имя студента
	 * @return среднее значение состояний лабораторных работ студента
	 */
	float calculateAverageByStudent(String student);
	
	/**
	 * Установить состояние целому списку лабораторных работ определённого
	 * студента<br>
	 * <b>Внимание!</b> По многочисленным ошибкам поясняю:<br>
	 * {@code labs} - список лаб, которые затронет эта функция<br>
	 * Список не обязательно полный<br>
	 * Все лабы из этого списка присутствуют и в общем списке лаб
	 * @param student имя студента
	 * @param labs список изменяемых лабораторных работ
	 * @param state новое состояние лабораторных работ
	 */
	void fillState(String student, List<String> labs, int state);
}
