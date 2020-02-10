package com.douzone.paint.main;


import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;

import paint.ColorPoint;
import paint.Drawable;
import paint.GraphicTest;
import paint.Point;

public class PaintApp {

	public static void main(String[] args) {
		Point point = new Point(2, 5);
		point.setX(2);
		point.setY(5);
		//drawPoint(point);
		point.draw();

		Point point2 = new Point(10, 50);
		//drawPoint(point2);
		//point2.show(false);
		point2.draw();

		ColorPoint point3 = new ColorPoint(50, 100, "red");
		//drawPoint(point3);
		point3.show(false);
		point3.show(true);
		point3.draw();

		Rect rect = new Rect();
		//drawShape(rect);
		rect.draw();

		Triangle triangle = new Triangle();
		//drawShape(triangle);
		triangle.draw();

		Circle circle = new Circle();
		//drawShape(circle);
		circle.draw();

		(new GraphicTest("HELLLO")).draw();

		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		//오류 : class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
		// a <- b <- c	c는 a,b만 사용가능 d는 못함
		//		  <- d
		//	System.out.println(circle instanceof Rect);
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		
		// interface 는 hierachy 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);

	}

	public static void drawShape(Shape shape) {
		shape.draw();
	}

	//	public static void drawRect(Rect rect) {
	//		rect.draw();
	//	}
	//	
	//	public static void drawTriangle(Triangle triangle) {
	//		triangle.draw();
	//	}

	public static void drawPoint(Point point) {
		point.show();
	}

	public static void drawPoint(ColorPoint point) {
		point.show();
	}
}
