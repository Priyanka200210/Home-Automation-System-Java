package com.house_automation;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Light implements Switchable{
	
	float time;
	Boolean status;
	LocalTime onTime;
	LocalTime offTime;
	
	public Light() {
		this.status = false;
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
			return this.time;
		}
		return 0.0f;
	}
	
	public void setTime(float time) {
		this.time = time;
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
			System.out.println("Lights are already on!");
		}
		else {
			this.status = true;
			this.onTime = LocalTime.now();
			System.out.println("turning on............................");
			System.out.println("Lights turned on!");
		}
	}

	@Override
	public void offAppliance() {
		if(isOff()) {
			System.out.println("Lights are already Off!");
		}
		else {
			this.status = false;
			this.offTime = LocalTime.now();
			System.out.println("Lights turned off!");
		}
		
	}
}
