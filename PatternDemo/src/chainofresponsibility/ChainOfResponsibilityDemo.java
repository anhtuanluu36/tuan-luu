package chainofresponsibility;

public class ChainOfResponsibilityDemo {


	public static void main(String[] args) {
		AbstractFilter mainFilter = new CarFilter();
		AbstractFilter planeFilter = new PlaneFilter();
		mainFilter.setNextFilter(planeFilter);
		
		mainFilter.filter(SubjectEnum.PLANE, "B-52");
		mainFilter.filter(SubjectEnum.CAR, "BMW");
		mainFilter.filter(SubjectEnum.BIKE, "Honda");
	}

}
