package com.console.drawing.shapes;

import com.console.drawing.Canvas;

public class Rectangle {
	
	/**
	 * Takes two pairs of coordinates and the canvas array in order to draw a rectangle.
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @param canvasBase
	 * @throws Exception
	 */
	public static void drawRectangle(int startX, int startY, int endX, int endY, char [][] canvasBase) throws Exception{
		
		validateRectangleParameters(startX, startY, endX, endY, canvasBase);
		
		int xLineLength = endX - startX;
		int yLineLength = endY - startY;
		
		for(int i = startX; i < endX + 1; i ++) {
			
			canvasBase[i][startY] = 'x';
			canvasBase[i][startY + yLineLength] = 'x';
					
		}
		
		for(int i = startY; i < endY + 1; i++) {
			
			canvasBase[startX][i] = 'x';
			canvasBase[startX + xLineLength][i] = 'x';
			
		}
			
	}
	
	/**
	 * Validates that rectangle coordinates are compatible with the existing canvas, or that one has already been drawn
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param canvasBase
	 * @throws Exception
	 */
	private static void validateRectangleParameters(int x1, int y1, int x2, int y2, char [][] canvasBase) throws Exception {
		
		if(canvasBase == null)
			throw new Exception("Canvas needs to be drawn first");
		
		if(x1 < 0 || x1 > Canvas.getCanvasWidth() || y1 < 0 || y1 > Canvas.getCanvasHeight()
				|| x2 < 0 || x2 > Canvas.getCanvasWidth() || y2 < 0 || y2 > Canvas.getCanvasHeight() )
			throw new IllegalArgumentException("Coordinates provided exceed canvas size");
		
		if(x1 > x2 || y1 > y2 || x1 == x2 || y1 == y2)
			throw new IllegalArgumentException("Rectangle coordinates provided are not following specifications");
	}

}
