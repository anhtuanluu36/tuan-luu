package chainofresponsibility;

public class CarFilter extends AbstractFilter {

	@Override
	protected String execute() {
		return "a car";
	}

	@Override
	public boolean checkFilterEnum(SubjectEnum subjectEnum) {
		return SubjectEnum.CAR == subjectEnum;
	}
	
}
