package decorator;

public class BorderShapeDecorator extends ShapeDecorator {
	
	public BorderShapeDecorator(Shape shape) {
		super(shape);
	}


	@Override
	public String draw() {
		return "border " + super.draw();
	}

}
