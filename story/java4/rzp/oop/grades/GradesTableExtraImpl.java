package rzp.oop.grades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GradesTableExtraImpl extends GradesTableImpl implements GradesTableExtra {

    @Override
    public float calculateAverage() {
        if (gradesTable.isEmpty()) {
            return 0;
        }
        float totalAverage = 0;
        int studentCount = 0;

        for (String student : gradesTable.keySet()) {
            totalAverage += calculateAverageByStudent(student);
            studentCount++;
        }
        return studentCount > 0 ? totalAverage / studentCount : 0;
    }

    @Override
    public List<String> getExcellentStudents(int count, int minimum) {
        List<String> excellentStudents = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> entry : gradesTable.entrySet()) {
            String student = entry.getKey();
            Map<String, Integer> labs = entry.getValue();

            long matchingLabs = labs.values().stream().filter(state -> state >= minimum).count();
            if (matchingLabs >= count) {
                excellentStudents.add(student);
            }
        }

        return excellentStudents;
    }
}
