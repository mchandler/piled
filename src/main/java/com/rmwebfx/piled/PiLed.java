package com.rmwebfx.piled;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class PiLed {
	
	public static void main(String[] args) throws InterruptedException {
		final GpioController gpio = GpioFactory.getInstance();
		
		// Provision pin 1 as an OUTPUT pin and set it to 'on' (HIGH)
		final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
		
		// 5 second pause
		Thread.sleep(5000);
		
		// Turn pin 1 'off' (LOW)
		pin.low();
		
		Thread.sleep(5000);
		
		// Toggle pin state (off/on/off, etc) 4 times
		for (int i = 1; i <= 4; i++) {
			pin.toggle();
			Thread.sleep(2000);
		}
		
		// shut it down!
		gpio.shutdown();
	}
}
