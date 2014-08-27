package decorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape shape) {
		super(shape);
	}

	/* (non-Javadoc)
	 * @see decorator.ShapeDecorator#draw()
	 */
	@Override
	public String draw() {
		return "red " + super.draw();
	}
	
	

}
