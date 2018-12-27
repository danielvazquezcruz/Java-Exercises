package com.console.drawing;

import java.util.Scanner;

public class App {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		showCommandList();

		while (sc.hasNextLine()) {
			
			try {
				Canvas.launchCanvas(sc.nextLine());
				
				System.out.print("Enter Next Command:");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
				System.out.print("Enter Next Command:");

			}
		}

	}
	
	private static void showCommandList() {
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("|      Command      |        Description                                                        ");
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("| C w h             | Create a new canvas of width w and height h 							    ");
		System.out.println("| L x1 y1 x2 y2     | Create a new line from (x1,y1) to (x2,y2) - (Vertical & Horizontal only)  ");
		System.out.println("| R x1 y1 x2 y2     | Create a new rectangle                      							    ");
		System.out.println("| B x y c           | Fill the entire area connected to (x,y) with colour 'c'                   ");
		System.out.println("| Q                 | Exit program            												    ");
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.print("Enter Command:");
		
	}

}
