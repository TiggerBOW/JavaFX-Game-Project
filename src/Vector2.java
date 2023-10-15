
public class Vector2 {
	
	private float xAxis;
	private float yAxis;
	
	public Vector2(float x,float y) {
		xAxis = x;
		yAxis = y;
	}
	
	public static float getAngleBetweenVectors(Vector2 a,Vector2 b) {
		
		float scalarProduct = scalar(a,b);
		float magnitudeMultiplication = a.magnitude() * b.magnitude();
		float cosAngle = scalarProduct / magnitudeMultiplication;
		float radianAngle = (float) Math.acos(cosAngle);
		
		// Radyanı dereceye çevirme işlemi
	    float degreeAngle = (float) Math.toDegrees(radianAngle);
	    
	    return degreeAngle;
	}
	public static float scalar(Vector2 a,Vector2 b) {
		return a.xAxis * b.xAxis + a.yAxis*b.yAxis;
	}
	public float magnitude() {
		return (float) Math.sqrt(Math.pow(xAxis, 2) + Math.pow(yAxis, 2));
	}
	public Vector2 normalize() {
		float vectorMagnitude = magnitude();
		float newX = xAxis / vectorMagnitude;
		float newY = yAxis / vectorMagnitude;
		return new Vector2(newX,newY);
	}
	public Vector2 add(Vector2 otherVector) {
		float newX = xAxis + otherVector.getX();
		float newY = yAxis + otherVector.getY();
		xAxis = newX;
		yAxis = newY;
		return this;
	}
	public Vector2 remove(Vector2 otherVector) {
		float newX = xAxis - otherVector.getX();
		float newY = yAxis - otherVector.getY();
		xAxis = newX;
		yAxis = newY;
		return this;
	}
	public Vector2 multipleScalar(float value) {
		float newX = xAxis * value;
		float newY = yAxis * value;
		xAxis = newX;
		yAxis = newY;
		return this;
	}
	public Vector2 turnLeft(float degree) {
		float rad = (float)Math.toRadians(degree);
		float newX = (float) (xAxis - magnitude() * Math.sin(rad));
		float newY = (float) (yAxis - magnitude() * (1 - Math.cos(rad)));
		xAxis = newX;
		yAxis = newY;
		return this;
	}
	public void print() {
		System.out.println("X : " + xAxis + " Y : " + yAxis);
	}
	public float getX() {
		return xAxis;
	}
	public float getY() {
		return yAxis;
	}
}
