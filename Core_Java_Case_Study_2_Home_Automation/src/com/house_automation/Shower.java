package com.house_automation;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Shower implements Controllable{
	
	float temp;
	float time;
	Boolean status;
	LocalTime onTime;
	LocalTime offTime;
	
	public Shower() {
		this.temp = 35;
		this.status = false;
	}
	
	
	public float getTemp() {
		return temp;
	}


	public void setTemp(float temp) {
		this.temp = temp;
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


	@Override
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	@Override
	public float getTime() {
		if(onTime!=null && offTime!=null) {
			this.time = (float)this.onTime.until(offTime,ChronoUnit.SECONDS);
			return time;
		}
		return 0.0f;
	}
	
	public void setTime(float time) {
		this.time = time;
	}
	
	@Override
	public void temp_up() {
		this.temp += 1;
		System.out.println("\nTemperature: "+this.getTemp()+"°C");
		
	}

	@Override
	public void temp_down() {
		this.temp -= 1;
		System.out.println("\nTemperature: "+this.getTemp()+"°C");
		
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
			System.out.println("Shower is already on!");
		}
		else {
			this.status = true;
			this.onTime = LocalTime.now();
			System.out.println("turning on............................");
			System.out.println("Shower turned on!");
		}
	}

	@Override
	public void offAppliance() {
		if(isOff()) {
			System.out.println("Shower is already Off!");
		}
		else {
			this.status = false;
			this.offTime = LocalTime.now();
			System.out.println("Shower turned off!");
		}
		
	}

	
}
