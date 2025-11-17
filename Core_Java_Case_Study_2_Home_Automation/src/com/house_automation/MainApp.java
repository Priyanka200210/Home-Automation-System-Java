package com.house_automation;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===============================================\r\n"
				+ "   WELCOME TO SMART HOUSE AUTOMATION SYSTEM\r\n"
				+ "===============================================");
		HouseOperation app = new HouseOperation();
		
		int choice;
		app.addHouse();
		
		do {
			System.out.println("\n1. Add Room\n2. Add Device\n3. Access Device\n4. Display\n0. To Exit\nEnter your choice:");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:{
				app.addRoom();
				break;
			}
			case 2:{
				app.addDevice();
				break;
			}
			case 3:{
				app.accessDevice();
				break;
			}
			case 4:{
				app.display();
				break;
			}
			case 0:{
				System.out.println("Thank You!!");
				break;
			}
			default:
				System.out.println("Invalid Choice!!");
			}
		}while(choice!=0);
		
		
	}

}
