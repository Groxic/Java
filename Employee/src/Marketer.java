
public class Marketer extends Employee {
	public Marketer(int years) {
		super(years);
	}

	public void advertise() {
		System.out.println("Act now while supplies last!");
	}

	@Override
	public double getSalary() {
		return super.getSalary() + 10000;
	}

}