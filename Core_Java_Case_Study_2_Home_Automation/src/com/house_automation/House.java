package com.house_automation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class House {
	
	Scanner sc = new Scanner(System.in);
	
	int houseNo;
	String ownerName;
	List<Room> room = new ArrayList<Room>();
	
	private static House house = new House();
	
	public House() {
		
	}
	
	public static House getHouse() {
		return house;
	}

	public static void setHouse(House house) {
		House.house = house;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}
	
	public void addRoom(String room) {
		this.room.add(new Room(room));
	}
	
	public int checkRoom(String roomType) {
		int index = -1;
		for(int i = 0;i<room.size();i++) {
			if(room.get(i).getRoomType().equals(roomType)) {
				index = i;
				break;
			}
		}
		
		return index;
	}

	public void addDevice(String roomType) {
		int choice;
		int index = checkRoom(roomType);
		if(index!=-1) {
			System.out.println("\n1. TV\n2. AC\n3. Music Player\n4. Light\n5. Shower\nEnter your choice:");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:{
				room.get(index).addDevice("TV");
				System.out.println("TV added Successully!");
				break;
			}
			case 2:{
				room.get(index).addDevice("AC");
				System.out.println("AC added Successully!");
				break;
			}
			case 3:{
				room.get(index).addDevice("Music_Player");
				System.out.println("Music Player added Successully!");
				break;
			}
			case 4:{
				room.get(index).addDevice("Light");
				System.out.println("Lights added Successully!");
				break;
			}
			case 5:{
				room.get(index).addDevice("Shower");
				System.out.println("Shower added Successully!");
				break;
			}
			default:
				System.out.println("Device doesn't exist!");
		  }
		}
		else {
			System.out.println("Room Not Found!");
		}
	}
	
	public String getDevice() {
		int choice;
		System.out.println("\n1. TV\n2. Music Player\n3. AC\n4. Light\n5. Shower\nEnter your choice: ");
		choice = sc.nextInt();
		if(choice == 1) {
			return "TV";
		}
		else if(choice == 2) {
			return "Music_Player";
		}
		else if(choice == 3) {
			return "AC";
		}
		else if(choice == 4) {
			return "Light";
		}
		else if(choice == 5) {
			return "Shower";
		}
		else {
			System.out.println("Invalid Choice!");
			return "Device doesn't exist!";
		}
	}

	public void turnOnDevice(int index, String device) {
		room.get(index).turnOnDevice(device);
		
	}
	
	public void turnOffDevice(int index, String device) {
		room.get(index).turnOffDevice(device);
		
	}

	public void checkStatus(int index, String device) {
		room.get(index).checkStatus(device);
	}

	public void volumeUp(int index, String device) {
		room.get(index).volumeUp(device);
		
	}

	public void volumeDown(int index, String device) {
		room.get(index).volumeDown(device);
		
	}

	public void tempUp(int index, String device) {
		room.get(index).tempUp(device);
		
	}
	
	public void tempDown(int index, String device) {
		room.get(index).tempDown(device);
		
	}

	public void standBy(int index, String device) {
		room.get(index).standBy(device);
		
	}

	public void checkTime(int index, String device) {
		room.get(index).checkTime(device);
		
	}

	public void display() {
		System.out.println("\nHouse No: "+this.getHouseNo()+"\nOwner Name: "+this.ownerName);
		Iterator<Room> itr = room.iterator();
		while(itr.hasNext()) {
			Room r = itr.next();
			r.display();
			System.out.println("------------------------------");
			
		}
		
	}

}
