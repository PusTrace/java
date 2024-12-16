package rzp.oop.grades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GradesTableImpl implements GradesTable {

    public final Map<String, Map<String, Integer>> gradesTable = new HashMap<>();

    @Override
    public void init(List<String> students, List<String> labs) {
        gradesTable.clear();
        for (String student : students) {
            Map<String, Integer> labsMap = new HashMap<>();
            for (String lab : labs) {
                labsMap.put(lab, 0);
            }
            gradesTable.put(student, labsMap);
        }
    }

    @Override
    public void setState(String student, String lab, int state) {
        if (!gradesTable.containsKey(student)) {
            throw new IllegalArgumentException("Студент " + student + " не найден");
        }
        Map<String, Integer> labs = gradesTable.get(student);
        if (!labs.containsKey(lab)) {
            throw new IllegalArgumentException("Лабораторная работа " + lab + " не найдена для студента " + student);
        }
        labs.put(lab, state);
    }

    @Override
    public int getState(String student, String lab) {
        if (!gradesTable.containsKey(student)) {
            throw new IllegalArgumentException("Студент " + student + " не найден");
        }
        Map<String, Integer> labs = gradesTable.get(student);
        if (!labs.containsKey(lab)) {
            throw new IllegalArgumentException("Лабораторная работа " + lab + " не найдена для студента " + student);
        }
        return labs.get(lab);
    }

    @Override
    public float calculateAverageByStudent(String student) {
        if (!gradesTable.containsKey(student)) {
            throw new IllegalArgumentException("Студент " + student + " не найден");
        }
        Map<String, Integer> labs = gradesTable.get(student);
        return (float) labs.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public void fillState(String student, List<String> labs, int state) {
        if (!gradesTable.containsKey(student)) {
            throw new IllegalArgumentException("Студент " + student + " не найден");
        }
        Map<String, Integer> studentLabs = gradesTable.get(student);
        for (String lab : labs) {
            if (studentLabs.containsKey(lab)) {
                studentLabs.put(lab, state);
            } else {
                throw new IllegalArgumentException("Лабораторная работа " + lab + " не найдена для студента " + student);
            }
        }
    }
}
