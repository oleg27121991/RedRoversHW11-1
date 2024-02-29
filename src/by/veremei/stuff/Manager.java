package by.veremei.stuff;

public final class Manager extends Employee {
    private static final double MANAGER_SALARY_COEFFICIENT = 0.03;
    private final int numberOfSubordinates;
    public Manager(double baseSalary, String name, double salary, int numberOfSubordinates) {
        super(baseSalary, name, salary);
        this.numberOfSubordinates = numberOfSubordinates;
    }

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    @Override
    public double getSalary() {
        if (numberOfSubordinates == 0) {
            return this.getBaseSalary();
        } else {
            return getBaseSalary() * (numberOfSubordinates * MANAGER_SALARY_COEFFICIENT);
        }
    }
}