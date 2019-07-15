
interface Shape {

	float getArea();

	float getPerimeter();

	String toString();

}

class Rectangle implements Shape {

	float length, width;

	public Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public float getArea() {
		System.out.println("Finding area of rectangle with length = " + length + " and width = " + width);
		return calculateArea();
	}

	@Override
	public float getPerimeter() {
		System.out.println("Finding perimeter of rectangle with length = " + length + " and width = " + width);
		return calculatePerimeter();
	}
	
	@Override
	public String toString() {
		return "Rectangle = [length: " + length + ", width: " + width + ", area: " + calculateArea() + ", perimeter: "
				+ calculatePerimeter() + "]";
	}
	
	public float calculateArea(){
		return length*width;
	}

	public float calculatePerimeter(){
		return 2 * length + 2 * width;
	}
}

class Square extends Rectangle {

	public Square(float length) {
		super(length, length);
	}

	@Override
	public float getArea() {
		System.out.println("Finding area of square with side = " + length);
		return super.getArea();
	}

	@Override
	public float getPerimeter() {
		System.out.println("Finding perimeter of square with side = " + length);
		return super.getPerimeter();
	}

	@Override
	public String toString() {
		return "Square = [side: " + length + ", area: " + calculateArea() + ", perimeter: " + calculatePerimeter() + "]";
	}

}

class Circle implements Shape {

	float radius;

	public Circle(float radius) {
		this.radius = radius;
	}

	@Override
	public float getArea() {
		System.out.println("Finding area of circle with radius = " + radius);
		return calculateArea();
	}

	@Override
	public float getPerimeter() {
		System.out.println("Finding perimeter of circle with radius = " + radius);
		return calculatePerimeter();
	}

	@Override
	public String toString() {
		return "Circle = [radius: " + radius + ", area: " + calculateArea() + ", perimeter: " + calculatePerimeter() + "]";
	}
	
	public float calculateArea(){
		return (float) (3.14 * radius * radius);
	}

	public float calculatePerimeter(){
		return (float) (6.28 * radius);
	}

}
