package com.douzone.paint.shape;

import paint.Drawable;

public abstract class Shape implements Drawable {
	private String fillColor;
	private String lineColor;
	
	public String getFillColor() {
		return fillColor;
	}
	
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
	
	public String getLineColor() {
		return lineColor;
	}
	
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	
	public abstract void draw(); {
		/*
		System.out.println("구현 예정...");
		if(this instanceof Rect) {
			System.out.println("사각형을 그렸습니다.");
		}
		else if(this instanceof Triangle) {
			System.out.println("삼각형을 그렸습니다.");
		}
		*/
	}
}
