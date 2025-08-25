import com.example.employeeleavetracker.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveServiceTest {

    LeaveService service = new LeaveService();
    LeavePolicy policy = leave -> !leave.getDate().isBefore(LocalDate.now());

    @Test
    void testApplyValidLeave() {
        Employee emp = new Employee("John", 5);
        Leave leave = new Leave(LeaveType.CASUAL, LocalDate.now().plusDays(1));
        service.applyLeave(emp, leave, policy);
        assertEquals(4, emp.getRemainingLeaves());
    }

    @Test
    void testApplyInvalidLeaveDate() {
        Employee emp = new Employee("Jane", 3);
        Leave leave = new Leave(LeaveType.CASUAL, LocalDate.now().minusDays(1));
        assertThrows(InvalidLeaveDateException.class, () -> service.applyLeave(emp, leave, policy));
    }

    @Test
    void testLeaveLimitExceeded() {
        Employee emp = new Employee("Tom", 1);
        service.applyLeave(emp, new Leave(LeaveType.SICK, LocalDate.now()), policy);
        assertThrows(LeaveLimitExceededException.class, () ->
                service.applyLeave(emp, new Leave(LeaveType.CASUAL, LocalDate.now()), policy));
    }

    @Test
    void testLowLeaveBalance() {
        Employee emp1 = new Employee("E1", 5);
        Employee emp2 = new Employee("E2", 10);
        for (int i = 0; i < 6; i++) {
            emp2.applyLeave(new Leave(LeaveType.SICK, LocalDate.now().plusDays(i)));
        }
        List<Employee> result = service.getLowLeaveBalanceEmployees(Arrays.asList(emp1, emp2));
        assertTrue(result.contains(emp2));
        assertFalse(result.contains(emp1));
    }
}

