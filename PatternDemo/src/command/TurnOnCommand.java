/**
 * 
 */
package command;

/**
 * @author TuanLA
 *
 */
public class TurnOnCommand implements Command {

	public Subject subject;
	
	public TurnOnCommand(Subject subject) {
		super();
		this.subject = subject;
	}

	@Override
	public void execute() {
		System.out.println(subject.turnOn() + " Tuan executed!");
	}
}
