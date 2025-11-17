package com.house_automation;

public interface Switchable {
	
	public void onAppliance();
	public void offAppliance();
	public Boolean getStatus();
	public float getTime();
}
