package model.department;

public class Accounting extends Department {
	private static final long serialVersionUID = 4801957816410214976L;

	public Accounting( ) {
		super("ACC", "Accounting");
	}

	@Override
	public String toString( ) {
		return "Accounting{} " + super.toString();
	}
}
