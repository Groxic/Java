
public class LegalSecretary extends Secretary {
	public LegalSecretary(int years) {
		super(years);
	}

	public void fileLegalBriefs() {
		System.out.println("I could file all day!");
	}

	@Override
	public double getSalary() {
		return super.getSalary() + 5000;
	}

}
