package com.console.drawing.utils;

import com.console.drawing.constants.DrawingCommands;

public class CommandInputValidator {
	
	/**
	 * Splits the command string entered by user and evaluates that a proper command and number of arguments was provided.
	 * @param splitCommandStr
	 * @throws Exception
	 */
	public static void validateCommandStr(String [] splitCommandStr) throws Exception{
		
		if(splitCommandStr.length == 2 || splitCommandStr.length > 5) {
			throw new IllegalArgumentException("Incorrect number of command arguments");
		}
		
		if(!splitCommandStr[0].equals(DrawingCommands.CREATE_CANVAS_COMMAND) && !splitCommandStr[0].equals(DrawingCommands.DRAW_LINE_COMMAND)
				&& !splitCommandStr[0].equals(DrawingCommands.DRAW_RECTANGLE_COMMAND) && !splitCommandStr[0].equals(DrawingCommands.FILL_COLOR_COMMAND)
				&& !splitCommandStr[0].equals(DrawingCommands.QUIT_COMMAND))
			throw new IllegalArgumentException("A proper draw command was not provided");
		
		try {
			
			if(splitCommandStr[0].equals(DrawingCommands.CREATE_CANVAS_COMMAND) || splitCommandStr[0].equals(DrawingCommands.DRAW_LINE_COMMAND)
				|| splitCommandStr[0].equals(DrawingCommands.DRAW_RECTANGLE_COMMAND)) {
				
				for(int i = 1; i < splitCommandStr.length; i++) {
					int coordinateValue = Integer.valueOf(splitCommandStr[i]);
					
					if(coordinateValue < 0 || coordinateValue > 500)
						throw new IllegalArgumentException("Please provide a numeric value above 0 and below 500 for x / y coordinates");
				}
			}
			else if(splitCommandStr[0].equals(DrawingCommands.FILL_COLOR_COMMAND)){
				
				for(int i = 1; i < splitCommandStr.length - 1; i++) {
					int coordinateValue = Integer.valueOf(splitCommandStr[i]);
					
					if(coordinateValue < 0 || coordinateValue > 500)
						throw new IllegalArgumentException("Please provide a numeric value above 0 and below 500 for x / y coordinates");
				}
				
				if(splitCommandStr[3].length() > 1)
					throw new IllegalArgumentException("Color must be a single character");
			}
			
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please provide a numeric value above 0 and below 500 for x / y coordinates");
		}
		
		
	}

}
