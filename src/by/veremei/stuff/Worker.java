package by.veremei.stuff;

public final class Worker extends Employee {
    public Worker(double baseSalary, String name, double salary) {
        super(baseSalary, name, salary);
    }

    @Override
    public double getSalary() {
        return super.getBaseSalary();
    }
}
