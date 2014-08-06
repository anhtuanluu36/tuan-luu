package command;

public class CommandDemo {

	public static void main(String[] args) {
		Subject plane = new PlaneSubject();
		Command command = new TurnOnCommand(plane);
		command.execute();

		Subject car = new CarSubject();
		command = new TurnOnCommand(car);
		command.execute();
	}

}
