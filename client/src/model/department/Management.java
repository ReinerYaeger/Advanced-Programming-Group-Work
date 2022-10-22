package model.department;

public class Management extends Department {

	private static final long serialVersionUID = 4801957816410214976L;

	public Management( ) {
		super("MGT", "Management");
	}

	@Override
	public String toString( ) {
		return "Management{} " + super.toString();
	}
}
