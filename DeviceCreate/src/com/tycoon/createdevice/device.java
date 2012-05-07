package com.tycoon.createdevice;

import java.io.Serializable;
@SuppressWarnings("serial") //with this annotation we are going to hide compiler warning
public class device implements Serializable {

public device(String processor,String RAM,String ROM,String Additionally,String Battery){
    this.processor=processor;
    this.RAM=RAM;
    this.ROM=ROM;
    this.Additionally=Additionally;
    this.Battery=Battery;
}

public String getprocessor() {
    return processor;
}
public void setgenerationhard(String processor) {
    this.processor = processor;
}
public String getRAM() {
    return RAM;
}
public void setRAM(String RAM) {
    this.RAM = RAM;
}
public String getgROM() {
    return ROM;
}
public void setROM(String ROM) {
    this.ROM= ROM;
}
public String getAdditionally() {
    return Additionally;
}
public void setAdditionally(String Additionally) {
    this.Additionally = Additionally;
}
public String getBattery() {
    return Battery;
}
public void setBattery(String Battery) {
    this.Battery = Battery;
}
public String getDisplay() {
    return Display;
}
public void setDisplay(String Display) {
    this.Display = Display;
}
public String getKeypad() {
    return Keypad;
}
public void setKeypad(String Keypad) {
    this.Keypad = Keypad;
}
public String getOS() {
    return OS;
}
public void setOS(String OS) {
    this.OS = OS;
}
public String getColor() {
    return Color;
}
public void setColor(String Color) {
    this.Color = Color;
}
public String getMaterial() {
    return Material;
}
public void setMaterial(String Material) {
    this.Material = Material;
}
private String processor, RAM, ROM, Additionally, Battery, Display, Keypad, OS, Color,Material;
}