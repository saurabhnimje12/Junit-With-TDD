import com.example.studentgradingsystem.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class GradingServiceTest {

    GradingService service = new GradingService();

    // Lambda strategy used for tests
    GradingStrategy strategy = avg -> {
        if (avg >= 85) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 50) return "C";
        else return "Fail";
    };

    // Valid input should return correct grade
    @Test
    void testValidGrading() {
        Student s = new Student("John", "S001", Arrays.asList(90, 80, 85));
        assertEquals("A", service.gradeStudent(s, strategy));
    }

    // Grade B boundary test
    @Test
    void testGradeBoundaryB() {
        Student s = new Student("Jane", "S002", Arrays.asList(70, 75, 72));
        assertEquals("B", service.gradeStudent(s, strategy));
    }

    // Empty mark list should throw exception
    @Test
    void testEmptyMarks() {
        assertThrows(EmptyMarkListException.class, () -> {
            new Student("Bob", "S003", Collections.emptyList());
        });
    }

    // Invalid mark (negative) should throw exception
    @Test
    void testInvalidMark() {
        assertThrows(InvalidMarkException.class, () -> {
            new Student("Mark", "S004", Arrays.asList(90, -10, 75));
        });
    }
}