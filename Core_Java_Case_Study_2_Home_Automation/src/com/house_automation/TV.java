package com.house_automation;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TV implements Entertainment{
	Scanner sc = new Scanner(System.in);
	
	int volume;
	float time;
	Boolean standby;
	Boolean status;
	LocalTime onTime;
	LocalTime offTime;
	
	public TV(){
		this.volume = 4;
		this.status = false;
		this.standby = false;
	}
	
	
	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		this.volume = volume;
	}


	public LocalTime getOnTime() {
		return onTime;
	}


	public void setOnTime(LocalTime onTime) {
		this.onTime = onTime;
	}


	public LocalTime getOffTime() {
		return offTime;
	}


	public void setOffTime(LocalTime offTime) {
		this.offTime = offTime;
	}


	public void setTime(float time) {
		this.time = time;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public Boolean getStatus() {
		return status;
	}

	@Override
	public float getTime() {
		if(onTime!=null && offTime!=null) {
			this.time = (float)this.onTime.until(offTime,ChronoUnit.SECONDS);
			return time;
		}
		return 0.0f;
	}
	
	@Override
	public void volume_up() {
		volume += 1;
		System.out.println("Volume: "+this.volume);
		
	}

	@Override
	public void volume_down() {
		volume -= 1;
		System.out.println("Volume: "+this.volume);
		
	}
	
	public boolean isOn() {
		return this.status;		
	}
	
	public boolean isOff() {
		return !this.status;		
	}
	
	@Override
	public void onAppliance() {
		if(isOn()) {
			System.out.println("TV is already on!");
		}
		else {
			this.status = true;
			this.onTime = LocalTime.now();
			System.out.println("turning on............................");
			System.out.println("TV turned on!");
		}
		
	}

	@Override
	public void offAppliance() {
		if(isOff()) {
			System.out.println("TV is already off!");
			
		}
		else {
			this.status = false;
			this.offTime= LocalTime.now();
			System.out.println("TV turned off!");
			
		}
		
		
	}

	@Override
	public void play() {
		System.out.println("TV Playing!");
		
	}

	@Override
	public void pause() {
		System.out.println("TV Paused!");
		
	}
		
	public boolean isStandBy() {
		return this.standby;		
	}
	
	@Override
	public void standBy() {
		if(isStandBy()) {
			System.out.println("TV is already on standby mode!");
		}
		else {
			System.out.println("Do you really want to put TV on standby\n1. Yes\n2. No ");
			int choice = sc.nextInt();
			if(choice == 1) {
				this.standby = true;
				System.out.println("TV is on Standby!");
			}
			else if(choice == 2) {
				this.standby = false;
			}
		}
				
	}

}
