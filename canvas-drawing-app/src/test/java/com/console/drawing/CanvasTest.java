package com.console.drawing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CanvasTest {
	
	@Rule 
	public ExpectedException createCanvasExcessSize = ExpectedException.none();
	public ExpectedException invalidNoArguments = ExpectedException.none();
	public ExpectedException missingCommandArgument = ExpectedException.none();
	public ExpectedException drawLinecanvasNotDrawn = ExpectedException.none();
	public ExpectedException drawLineExceedsSize = ExpectedException.none();
	public ExpectedException drawLineIncompatibleCoordsProvided = ExpectedException.none();
	public ExpectedException drawRectangleCanvasNotDrawn = ExpectedException.none();
	public ExpectedException drawRectangleExceedsSize = ExpectedException.none();
	public ExpectedException fillColorExceedsSize = ExpectedException.none();

	@Test (expected  = Exception.class)
	public void drawLine_CanvasNotDrawn_ExceptionThrown() throws Exception {
		
		Canvas.clearCanvas();
		
		Canvas.launchCanvas("L 6 2 6 4");
		
		drawLinecanvasNotDrawn.expect(Exception.class);
		drawLinecanvasNotDrawn.expectMessage("Canvas needs to be drawn first");
	
	}
	
	@Test (expected  = Exception.class)
	public void drawRectangle_CanvasNotDrawn_ExceptionThrown() throws Exception {
		
		Canvas.clearCanvas();
		
		Canvas.launchCanvas("L 6 2 6 4");
		
		drawRectangleCanvasNotDrawn.expect(Exception.class);
		drawRectangleCanvasNotDrawn.expectMessage("Canvas needs to be drawn first");
	
	}
	
	@Test (expected  = IllegalArgumentException.class)
	public void createCanvas_ExceedsSize_ExceptionThrown() throws Exception {
		
		Canvas.launchCanvas("C 600 600");
		
		createCanvasExcessSize.expect(IllegalArgumentException.class);
		createCanvasExcessSize.expectMessage("Please provide a numeric value above 0 and below 500 for x / y coordinates");
	
	}
	
	@Test (expected  = Exception.class)
	public void drawLine_ExceedsSize_ExceptionThrown() throws Exception {
		
		Canvas.launchCanvas("C 10 10");
		
		Canvas.launchCanvas("L 15 4 15 8");
		
		drawLineExceedsSize.expect(Exception.class);
		drawLineExceedsSize.expectMessage("Coordinates provided exceed canvas size");
	
	}
	
	@Test (expected  = Exception.class)
	public void drawLine_IncompatibleCoordsProvided_ExceptionThrown() throws Exception {
		
		Canvas.launchCanvas("C 10 10");
		
		Canvas.launchCanvas("L 5 8 5 8");
		
		drawLineIncompatibleCoordsProvided.expect(Exception.class);
		drawLineIncompatibleCoordsProvided.expectMessage("Coordinates provided exceed canvas size");
	
	}
	
	@Test (expected  = IllegalArgumentException.class)
	public void commandStr_InvalidNoArguments_ExceptionThrown() throws Exception {
		
		Canvas.launchCanvas("C 200 600 400 ");
		
		invalidNoArguments.expect(IllegalArgumentException.class);
		invalidNoArguments.expectMessage("Incorrect number of command arguments");
	
	}
	
	@Test (expected  = IllegalArgumentException.class)
	public void  commandStr_InvalidCommandArgument_ExceptionThrown() throws Exception {
		
		Canvas.launchCanvas("D 600 600");
		
		missingCommandArgument.expect(IllegalArgumentException.class);
		missingCommandArgument.expectMessage("A proper draw command was not provided");
	
	}
	
	@Test (expected  = Exception.class)
	public void drawRectangle_ExceedsSize_ExceptionThrown() throws Exception {
		
		Canvas.launchCanvas("C 10 10");
		
		Canvas.launchCanvas("L 15 4 15 8");
		
		drawRectangleExceedsSize.expect(Exception.class);
		drawRectangleExceedsSize.expectMessage("Coordinates provided exceed canvas size");
	
	}
	
	@Test (expected  = Exception.class)
	public void fillColor_ExceedsSize_ExceptionThrown() throws Exception {
		
		Canvas.launchCanvas("C 10 10");
		
		Canvas.launchCanvas("L 15 4 15 8");
		
		fillColorExceedsSize.expect(Exception.class);
		fillColorExceedsSize.expectMessage("Coordinates provided exceed canvas size");
	
	}
	
		
}
