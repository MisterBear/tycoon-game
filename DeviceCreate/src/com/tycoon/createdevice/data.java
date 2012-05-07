package com.tycoon.createdevice;

import java.io.Serializable;
@SuppressWarnings("serial") //with this annotation we are going to hide compiler warning
public class data implements Serializable {

public data(int generation,int cash,int PriceBonus){
    this.generation=generation;
    this.cash=cash;
    this.PriceBonus=PriceBonus;
}

public int getgeneration() {
    return generation;
}
public void setgeneration(int generation) {
    this.generation = generation;
}

public int getcash() {
    return cash;
}
public void setcash(int cash) {
    this.cash = cash;
}
public int getPriceBonus() {
    return PriceBonus;
}
public void setPriceBonus(int PriceBonus) {
    this.PriceBonus = PriceBonus;
}

private int generation, cash,PriceBonus;
}