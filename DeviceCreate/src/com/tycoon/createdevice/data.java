package com.tycoon.createdevice;

import java.io.Serializable;
@SuppressWarnings("serial") //with this annotation we are going to hide compiler warning
public class data implements Serializable {

public data(int generationhard,int generationsoft,int generationdesign,int cash,int popbonus){
    this.generationhard=generationhard;
    this.generationsoft=generationsoft;
    this.generationdesign=generationdesign;
    this.cash=cash;
    this.popbonus=popbonus;
}

public int getgenerationhard() {
    return generationhard;
}
public void setgenerationhard(int generation) {
    this.generationhard = generationhard;
}
public int getgenerationsoft() {
    return generationsoft;
}
public void setgenerationsoft(int generation) {
    this.generationsoft = generationsoft;
}
public int getgenerationdesign() {
    return generationdesign;
}
public void setgenerationdesign(int generationdesign) {
    this.generationdesign = generationdesign;
}
public int getcash() {
    return cash;
}
public void setcash(int cash) {
    this.cash = cash;
}
public int getpopbonus() {
    return popbonus;
}
public void setpopbonus(int popbonus) {
    this.popbonus = popbonus;
}

private int generationhard,generationsoft,generationdesign,cash,popbonus;
}