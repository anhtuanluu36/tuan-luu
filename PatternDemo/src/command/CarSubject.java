package command;

public class CarSubject implements Subject {

	@Override
	public String turnOn() {
		return "Car turn on!";

	}

	@Override
	public String turnOff() {
		return "Car turn off!";
	}
}
