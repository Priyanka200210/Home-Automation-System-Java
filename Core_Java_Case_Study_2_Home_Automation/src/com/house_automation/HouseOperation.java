package com.house_automation;

import java.util.Scanner;

public class HouseOperation {
	Scanner sc = new Scanner(System.in);
	int houseNo;
	String ownerName,roomType,device;
	
	House house = House.getHouse(); // Singleton Class
	
	public void addHouse() {
		System.out.println("Enter House No: ");
		houseNo = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Owner Name: ");
		ownerName = sc.nextLine();
		house.setHouseNo(houseNo);
		house.setOwnerName(ownerName);
	
	}

	public void addRoom() {
		System.out.println("Enter Room Type: ");
		roomType = sc.next();
		house.addRoom(roomType);
		System.out.println(roomType+" Added Successfully!");
		
	}

	public void addDevice() {
		sc.nextLine();
		System.out.println("Enter Room Type: ");
		roomType = sc.nextLine();
		house.addDevice(roomType);
		
	}

	public void accessDevice() {
		int index,choice;
		String ch;
		do {
			System.out.println("Enter Room Type: ");
			roomType = sc.next();
			index = house.checkRoom(roomType);
			if(index!=-1) {
				do {
					System.out.println("\n1. Turn ON Device\n2. Turn OFF Device\n3. Check Status\n4. Volume Up\n5. Volume Down\n6. Temp Up\n7. Temp Down\n8. Put Device on Stand By Mode\n9. Check Time Period\n0. To Exit\nEnter your choice: ");
					choice = sc.nextInt();
					
					switch(choice) {
					case 1:{
						
						device = house.getDevice();
						house.turnOnDevice(index,device);
						break;
					}
					case 2:{
						
						device = house.getDevice();
						house.turnOffDevice(index,device);
						break;
					}
					
					case 3:{
						device = house.getDevice();
						house.checkStatus(index, device);
						break;
					}
					
					case 4:{
						device = house.getDevice();
						house.volumeUp(index, device);
						break;
					}
					
					case 5:{
						device = house.getDevice();
						house.volumeDown(index,device);
						break;
					}
					
					case 6:{
						device = house.getDevice();
						house.tempUp(index,device);
						break;
					}
					
					case 7:{
						device = house.getDevice();
						house.tempDown(index,device);
						break;
					}
					
					case 8:{
					    device = house.getDevice();
						if(device.equals("TV") || device.equals("Music_Player")) {
							house.standBy(index,device);
						}
						else if(!device.equals("Device doesn't exist!")){
							System.out.println("This device cannot put on standby mode!");
						}
						break;
					}
					case 9:{
						device = house.getDevice();
						house.checkTime(index,device);
						break;
					}
					case 0:{
						System.out.println("Thank You!");
						break;
					}
					default:
						System.out.println("Invalid Choice!");
					}
				}while(choice!=0);
			}
			else {
				System.out.println("Room doesn't exist!");
			}
			System.out.println("Do you want to come out from the room(yes/no): ");
			ch = sc.next();
		}while(ch.equals("no"));
		
	}

	public void display() {
		house.display();
		
	}

	
}
