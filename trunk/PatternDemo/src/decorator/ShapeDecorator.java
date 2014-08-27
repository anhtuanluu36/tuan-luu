package decorator;

public abstract class ShapeDecorator implements Shape {

	private Shape shape;
	
	
	public ShapeDecorator(Shape shape) {
		super();
		this.shape = shape;
	}


	@Override
	public String draw() {
		return shape.draw();
	}

}
