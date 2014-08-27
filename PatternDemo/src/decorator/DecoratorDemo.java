/**
 * 
 */
package decorator;

/**
 * @author TuanLA
 *
 */
public class DecoratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape circle = new CircleShape();
		System.out.println(circle.draw());
		circle = new BorderShapeDecorator(circle);
		circle = new RedShapeDecorator(circle);
		System.out.println(circle.draw());
	}

}
