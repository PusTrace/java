package rzp.oop.grades;

import java.util.List;

public interface GradesTableExtra extends GradesTable {
	/**
	 * Вычисляет средне значение состояний лаборыторных работ
	 * по всем студентам и всем лабам<br>
	 * Сначала для каждого студента отдельно, а потом среднее по студентам
	 * @return среднее значение состояний лабораторных работ по всем студентам
	 */
	float calculateAverage();
	
	/**
	 * Возвращает список студентов, у которых имеется как минимум (>=) count оценок не ниже (>=) minimum
	 * по лабораторным работам
	 * @return список студентов, удовлетворяющих указанным правилам
	 */
	List<String> getExcellentStudents(int count, int minimum);
}
