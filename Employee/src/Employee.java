
public class Employee {
	private int years;

	public Employee(int initialYears) {
		years = initialYears;
	}

	public int getHours() {
		return 40;
	}

	public int getYears() {
		return years;
	}

	public String getVacationForm() {
		return "yellow";
	}

	public double getSalary() {
		return 50000.0;
	}

	public int getVacationDays() {
		return 10 + getSeniorityBonus();
	}

	public int getSeniorityBonus() {
		return 2 * years;
	}

	public static void printInfo(Employee empl) {
		System.out.println("salary: " + empl.getSalary());
		System.out.println("v.days: " + empl.getVacationDays());
		System.out.println("v.form: " + empl.getVacationForm());
		System.out.println();
	}

}
