package com.console.drawing.shapes;

import com.console.drawing.Canvas;

public class Line {
	
	/**
	 * Takes two pairs of coordinates and the canvas array in order to draw a line.
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param canvasBase
	 * @throws Exception
	 */
	public static void drawLine(int x1, int y1, int x2, int y2, char [][] canvasBase) throws Exception{
		
		validateLineParameters(x1, y1, x2, y2, canvasBase);
		
		int startX = Integer.valueOf(x1);
		int startY = Integer.valueOf(y1);
		int endX = Integer.valueOf(x2);
		int endY = Integer.valueOf(y2);
		
		if( startX != endX && startY != endY) {
			throw new Exception("Incompatible coordinates provided");
		}
		
		if(startX == endX && startY != endY) {
			for(int i = startY; i < endY + 1; i ++) {
				canvasBase[startX][i] = 'x';
			}
		}
		else if(startX != endX && startY == endY) {
			for(int i = startX; i < endX + 1; i ++) {
				canvasBase[i][startY] = 'x';
			}	
		}
		else {
			throw new Exception("Incompatible coordinates provided");
		}
		
			
	}
	
	/**
	 * Validates that line coordinates are compatible with the existing canvas, or that one has already been drawn
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param canvasBase
	 * @throws Exception
	 */
	private static void validateLineParameters(int x1, int y1, int x2, int y2, char [][] canvasBase) throws Exception {
		
		if(canvasBase == null)
			throw new Exception("Canvas needs to be drawn first");
		
		if(x1 < 0 || x1 > Canvas.getCanvasWidth() || y1 < 0 || y1 > Canvas.getCanvasHeight()
				|| x2 < 0 || x2 > Canvas.getCanvasWidth() || y2 < 0 || y2 > Canvas.getCanvasHeight() )
			throw new IllegalArgumentException("Coordinates provided exceed canvas size");
	}

}
