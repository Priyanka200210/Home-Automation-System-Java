package com.house_automation;

import java.util.ArrayList;
import java.util.List;

public class Room {
		String roomType;
		List<Switchable> device = new ArrayList<Switchable>();
		public Room() {
			
		}
		public Room(String roomType) {
			this.roomType = roomType;
		}

		public String getRoomType() {
			return roomType;
		}

		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}

		public List<Switchable> getDevice() {
			return device;
		}

		public void setDevice(List<Switchable> device) {
			this.device = device;
		}
	
		public void addDevice(String device)
		{
			if(device.equalsIgnoreCase("TV")) {
				this.device.add(new TV());
			}
			else if(device.equalsIgnoreCase("AC")) {
				this.device.add(new AC());
			}
			else if(device.equalsIgnoreCase("Light")){
				this.device.add(new Light());
			}
			else if(device.equalsIgnoreCase("Shower")) {
				this.device.add(new Shower());
			}
			else if(device.equalsIgnoreCase("Music_Player")) {
				this.device.add(new Music_Player());
			}
			
		}
		
		public int searchDevice(String device) {
			int index = -1;
			for(int i = 0;i<getDevice().size();i++) {
				if(getDevice().get(i) instanceof TV) {
					if(device.equalsIgnoreCase("TV")) {
						index = i;
						break;
					}
				}
				else if(getDevice().get(i) instanceof AC) {
					if(device.equalsIgnoreCase("AC")) {
						index = i;
						break;
					}
				}
				else if(getDevice().get(i) instanceof Light) {
					if(device.equalsIgnoreCase("Light")) {
						index = i;
						break;
					}
				}
				
				else if(getDevice().get(i) instanceof Music_Player) {
					if(device.equalsIgnoreCase("Music_Player")) {
						index = i;
						break;
					}
				}
				else if(getDevice().get(i) instanceof Shower) {
					if(device.equalsIgnoreCase("Shower")) {
						index = i;
						break;
					}
				}
			}
			return index;
			
		}
		public void turnOnDevice(String device) {
			int index = searchDevice(device);
			if(index!=-1) {
				this.getDevice().get(index).onAppliance();
			}
			else {
				System.out.println("Device not found!");
			}
			
		}
		
		public void turnOffDevice(String device) {
			int index = searchDevice(device);
			if(index!=-1) {
				this.getDevice().get(index).offAppliance();
			}
			else {
				System.out.println("Device not found!");
			}
			
		}
		
		public void checkStatus(String device) {
			int index = searchDevice(device);
			if(index!=-1) {
				if(this.getDevice().get(index).getStatus()) {
					System.out.println("Device is ON!");
				}
				else  {
					System.out.println("Device is OFF!");
				}
			}
			else {
				System.out.println("Device not found!");
			}
			
		}
		
		public void volumeUp(String device) {
			int index = searchDevice(device);
			if(index!=-1) {
				if(this.getDevice().get(index) instanceof TV) {
					TV tv = (TV)this.device.get(index);
					tv.volume_up();
				}else if(this.getDevice().get(index) instanceof Music_Player) {
					Music_Player mp = (Music_Player)this.device.get(index);
					mp.volume_up();
				}
				else {
					System.out.println("Invalid operation on the device!");
				}
				
			}
			else {
				System.out.println("Device not found!");
			}
			
		}
		
		public void volumeDown(String device) {
			int index = searchDevice(device);
			if(index!=-1) {
				if(this.getDevice().get(index) instanceof TV) {
					TV tv = (TV)this.device.get(index);
					tv.volume_down();
				}else if(this.getDevice().get(index) instanceof Music_Player) {
					Music_Player mp = (Music_Player)this.device.get(index);
					mp.volume_down();
				}
				else {
					System.out.println("Invalid operation on the device!");
				}
				
			}
			else {
				System.out.println("Device not found!");
			}
			
		}
		
		public void tempUp(String device) {
			int index = searchDevice(device);
			if(index!=-1) {
				if(this.device.get(index) instanceof AC) {
					AC ac = (AC)this.device.get(index);
					ac.temp_up();
				}
				else if(this.device.get(index) instanceof Shower) {
					Shower sh = (Shower)this.device.get(index);
					sh.temp_up();
				}
				else {
					System.out.println("Invalid operation on the device!");
				}
			}
			else {
				System.out.println("Device not found!");
			}
			
		}
		
		public void tempDown(String device) {
			int index = searchDevice(device);
			if(index!=-1) {
				if(this.device.get(index) instanceof AC) {
					AC ac = (AC)this.device.get(index);
					ac.temp_down();
				}
				else if(this.device.get(index) instanceof Shower) {
					Shower sh = (Shower)this.device.get(index);
					sh.temp_down();
				}
				else {
					System.out.println("Invalid operation on the device!");
				}
			}
			else {
				System.out.println("Device not found!");
			}
			
		}
		
		public void standBy(String device) {
		 int index = searchDevice(device);
		 if(index!=-1) {
			 if(this.device.get(index) instanceof TV) {
				 TV tv = (TV) this.device.get(index);
				 tv.standBy();	 
			 }
			 else if(this.device.get(index) instanceof Music_Player) {
				 Music_Player mp = (Music_Player) this.device.get(index);
				 mp.standBy();
			 }
			 else {
					System.out.println("Invalid operation on the device!");
				}
		 }
		 else {
			 System.out.println("Device not found!");
			
		 	}
		
		}
		
		public void checkTime(String device) {
			int index = searchDevice(device);
			if(index!=-1) {
				System.out.println("Total time device is ON: "+this.device.get(index).getTime());
			}
			else {
				System.out.println("Device not found!");
			}
			
		}
		
		public void display() {
			System.out.println("\nRoom Type: "+roomType);
			System.out.println("Device List: ");
			for(int i = 0;i<device.size();i++){
				if(this.getDevice().get(i) instanceof TV) {
					System.out.println("TV");
				}
				else if(this.getDevice().get(i) instanceof AC) {
					System.out.println("AC");
				}
				else if(this.getDevice().get(i) instanceof Light) {
					System.out.println("Light");
				}
				else if(this.getDevice().get(i) instanceof Music_Player) {
					System.out.println("Music Player");
				}
				if(this.getDevice().get(i) instanceof Shower) {
					System.out.println("Shower");
				}
			}
		}
		
		
		
		
		
}
