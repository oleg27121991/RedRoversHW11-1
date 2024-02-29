package by.veremei.unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import by.veremei.stuff.Director;
import by.veremei.stuff.Employee;
import by.veremei.stuff.Manager;
import by.veremei.stuff.Worker;
import by.veremei.utils.CompanyUtils;
import org.junit.Before;
import org.junit.Test;

public class EmployeeUtilsTest {
    private Employee[] employees;
    private Manager[] managers;
    CompanyUtils companyUtils = new CompanyUtils();

    @Before
    public void setUp() {
        employees = new Employee[]{
                new Worker(1000, "John", 2000),
                new Worker(1500, "Alice", 3000),
                new Worker(1200, "Bob", 2500),
                new Manager(2000, "Mike", 2000, 1),
                new Manager(1800, "Jane", 1800, 2),
                new Manager(2500, "Chris", 2500, 0),
                new Director(5000, "Roman", 3000, 6)
        };

        managers = companyUtils.filterManagers(employees);
    }

    @Test
    public void testFindEmployeeByName() {
        assertEquals("Roman", companyUtils.findEmployeeByName(employees, "Roman").getName());
        assertNull(companyUtils.findEmployeeByName(employees, "Unknown"));
    }

    @Test
    public void testFindEmployeeBySubstring() {
        assertEquals("Mike", companyUtils.findEmployeeByPartName(employees, "M").getName());
    }

    @Test
    public void testCalculateTotalSalaryBudget() {
        assertEquals(9068, companyUtils.calculateTotalSalaryBudget(employees), 0.01);
    }

    @Test
    public void testFindMinimumSalary() {
        assertEquals(60.0, companyUtils.findMinSalary(employees), 0.01);
    }

    @Test
    public void testFindMaximumSalary() {
        assertEquals(2700.0, companyUtils.findMaxSalary(employees), 0.01);
    }

    @Test
    public void testFindMinimumSubordinatesCount() {
        assertEquals(0, companyUtils.findMinimumSubordinatesCount(managers));
    }

    @Test
    public void testFindMaximumSubordinatesCount() {
        assertEquals(2, companyUtils.findMaximumSubordinatesCount(managers));
    }

    @Test
    public void testFindMaximumBonus() {
        assertEquals(1940.0, companyUtils.findMaximumBonus(managers), 0.01);
    }

    @Test
    public void testFindMinimumBonus() {
        assertEquals(0.0, companyUtils.findMinimumBonus(managers), 0.01);
    }
}
