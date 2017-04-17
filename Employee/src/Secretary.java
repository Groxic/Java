
public class Secretary extends Employee {
	public Secretary(int years) {
		super(years);
	}

	@Override
	public int getSeniorityBonus() {
		return 0;
	}

	public void takeDictation(String text) {
		System.out.println("Taking dictation of text: " + text);
	}
}
