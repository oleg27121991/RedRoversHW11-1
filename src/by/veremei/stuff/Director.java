package by.veremei.stuff;

public final class Director extends Employee {
    private static final double DIRECTOR_SALARY_COEFFICIENT = 0.09;
    private final int numberOfSubordinates;

    public Director(double baseSalary, String name, double salary, int numberOfSubordinates) {
        super(baseSalary, name, salary);
        this.numberOfSubordinates = numberOfSubordinates;
    }

    @Override
    public double getSalary() {
        if (numberOfSubordinates == 0) {
            return this.getBaseSalary();
        } else {
            return getBaseSalary() * (numberOfSubordinates * DIRECTOR_SALARY_COEFFICIENT);
        }
    }
}