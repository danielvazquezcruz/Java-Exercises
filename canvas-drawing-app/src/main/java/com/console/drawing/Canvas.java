package com.console.drawing;

import com.console.drawing.constants.DrawingCommands;
import com.console.drawing.shapes.Line;
import com.console.drawing.shapes.Rectangle;
import com.console.drawing.utils.CommandInputValidator;

public class Canvas {
	
	private static int canvasHeight;
	private static int canvasWidth;
	
	private static char canvasBase [][] = null;
	
	public static int getCanvasHeight() {
		return canvasHeight;
	}

	public static void setCanvasHeight(int canvasHeight) {
		Canvas.canvasHeight = canvasHeight;
	}

	public static int getCanvasWidth() {
		return canvasWidth;
	}

	public static void setCanvasWidth(int canvasWidth) {
		Canvas.canvasWidth = canvasWidth;
	}
	
	public static void clearCanvas() {
		
		canvasBase = null;
	}
	
	/**
	 * Takes command line string in order to determine which command to execute
	 * @param commandStr
	 * @throws Exception
	 */
	public static void launchCanvas(String commandStr) throws Exception {
		
			String [] splitCommandStr = commandStr.split(" ");
			
			CommandInputValidator.validateCommandStr(splitCommandStr);
			
			if(DrawingCommands.CREATE_CANVAS_COMMAND.equals(splitCommandStr[0]) && splitCommandStr.length == 3) {
				
				createInitialCanvas(Integer.valueOf(splitCommandStr[1]), Integer.valueOf(splitCommandStr[2]));
			
			}	
			else if(DrawingCommands.DRAW_LINE_COMMAND.equals(splitCommandStr[0]) && splitCommandStr.length == 5) {
				
				Line.drawLine(Integer.valueOf(splitCommandStr[1]), Integer.valueOf(splitCommandStr[2]),
						Integer.valueOf(splitCommandStr[3]), Integer.valueOf(splitCommandStr[4]), canvasBase);
			
			}	
			else if(DrawingCommands.DRAW_RECTANGLE_COMMAND.equals(splitCommandStr[0]) && splitCommandStr.length == 5) {
				
				Rectangle.drawRectangle(Integer.valueOf(splitCommandStr[1]), Integer.valueOf(splitCommandStr[2]),
						Integer.valueOf(splitCommandStr[3]), Integer.valueOf(splitCommandStr[4]),canvasBase);
			
			}
			else if(DrawingCommands.FILL_COLOR_COMMAND.equals(splitCommandStr[0]) && splitCommandStr.length == 4) {
				
				fillColor(Integer.valueOf(splitCommandStr[1]), Integer.valueOf(splitCommandStr[2]),splitCommandStr[3].charAt(0));
						
			}
			else if(DrawingCommands.QUIT_COMMAND.equals(splitCommandStr[0])) {
				
				System.out.println("Closing program.....");
				Runtime.getRuntime().halt(0);
			}
			else {
				System.out.println("Invalid command or missing arguments");
			}
			
			drawFullCanvas();
			
	}
	
	/**
	 * Receives x & y coordinates in order to draw the initial canvas. If one is already created
	 * it will be overwritten by the new one.
	 * @param x
	 * @param y
	 */
	private static void createInitialCanvas(int x, int y) {
		
		//Add two extra positions to account for borders
		canvasWidth = Integer.valueOf(x) + 2;
		canvasHeight = Integer.valueOf(y) + 2;
				
		canvasBase = new char [canvasWidth][canvasHeight];
	
		for(int i = 0; i < canvasHeight; i++) {
			
			System.out.println();
			
			for(int j = 0; j < canvasWidth ; j++) {
				
				if((i == 0 || i == canvasHeight - 1) && (j > 0 && j < canvasWidth - 1)) {
					canvasBase [j][i] = '-';
				}
				else if(i > 0 && i < canvasHeight - 1 && (j == 0 || j == canvasWidth - 1 )) {
					canvasBase [j][i] = '|';
				}
					
				else {
					canvasBase [j][i] = ' ';
				}
				
				
			}
					
			
		}
		
	}
	
	/**
	 * Draws the full canvas, including any shapes or color fills which may have been added.
	 */
	private static void drawFullCanvas() {
		
		for (int i = 0; i < canvasHeight; i ++) {
			for( int j = 0; j < canvasWidth; j ++) {
				
				System.out.print(canvasBase[j][i]);
				
				if(j == canvasWidth - 1)
					System.out.println();
			}
		}
	}
	
	/**
	 * Takes x and y coordinates from which color filling would start, along with a character
	 * which will represent color.
	 * @param x1
	 * @param y1
	 * @param c
	 */
	private static void fillColor(int x1, int y1, char c) {
		
		if(x1 > canvasWidth || y1 > canvasHeight)
			throw new IllegalArgumentException("Coordinates provided exceed canvas size");
		
		
		//Fill lower right side of the canvas
		for(int i = y1; i < canvasHeight - 1; i++) {
			for(int j = x1; j < canvasWidth - 1; j++) {
				
				if(canvasBase[j][i] == 'x') {
					break;
				}else {
					canvasBase[j][i] = c ;
				}
			}
		}
		
		//Fill upper right side of the canvas
		for(int i = y1; i > 0; i--) {
			for(int j = x1; j < canvasWidth - 1; j++) {
				
				if(canvasBase[j][i] == 'x') {
					break;
				}else {
					canvasBase[j][i] = c ;
				}
			}
		}
		
		//Fill lower left side of the canvas
		for(int i = y1; i > 0; i--) {
			for(int j = x1; j > 1; j--) {
				
				if(canvasBase[j][i] == 'x') {
					break;
				}else {
					canvasBase[j][i] = c ;
				}
			}
		}
		
		//Fill upper left side of the canvas
		for(int i = y1; i < canvasHeight - 1; i++) {
			for(int j = x1; j > 1; j--) {
				
				if(canvasBase[j][i] == 'x') {
					break;
				}else {
					canvasBase[j][i] = c ;
				}
			}
		}
		
		
	}

}
