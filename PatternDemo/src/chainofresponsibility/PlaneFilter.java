package chainofresponsibility;

public class PlaneFilter extends AbstractFilter {

	@Override
	protected String execute() {
		return "a plane";
	}

	@Override
	public boolean checkFilterEnum(SubjectEnum subjectEnum) {
		return SubjectEnum.PLANE == subjectEnum;
	}
	
}
