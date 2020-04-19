public class EmployeeTest {

    public static void main(String[] args) {

        Employee[] emps = new Employee[5];

        emps[0] = new Employee("Ivanov Ivan");
        emps[1] = new Employee("Petrov Petr");
        emps[2] = new Employee("Sergeev Sergey");
        emps[3] = new Employee("Marieva Maria");
        emps[4] = new Employee("Darina Daria");

        System.out.println("Список сотрудников старше 40 лет:");
        for (Employee emp: emps
             ) {
            if (emp.getAge() > 40) {
                System.out.println(emp);
            }
        }
    }
}
