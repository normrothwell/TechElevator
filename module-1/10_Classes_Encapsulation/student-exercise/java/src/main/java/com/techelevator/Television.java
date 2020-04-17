package com.techelevator;

public class Television {
	private boolean isOn;
	private int currentChannel;
	private int currentVolume;
	
	
	
	
	
public Television() {
	this.isOn = false;
	this.currentChannel = 3;
	this.currentVolume = 2;
}




public void turnOff() {
	isOn = false;
}

public void turnOn() {
	isOn = true;
}

public void changeChannel(int newChannel) {
	if (isOn == true) {
		currentChannel = newChannel;
	}
}

public void channelUp() {
	if (isOn == true && currentChannel < 18) {
		currentChannel++;
	}else if (isOn == true && currentChannel == 18) {
		currentChannel = 3;
	}
}

public void channelDown() {
	if (isOn == true && currentChannel > 3) {
		currentChannel--;
	}else if (isOn == true && currentChannel == 3) {
		currentChannel = 18;
	}
}

public void raiseVolume() {
	if (isOn == true && currentVolume < 10) {
		currentVolume++;
	}
}

public void lowerVolume() {
	if (isOn == true && currentVolume > 0) {
		currentVolume--;
	}
}


public boolean isOn() {
	return isOn;
}

public int getCurrentChannel() {
	return currentChannel;
}

public int getCurrentVolume() {
	return currentVolume;
}

}
