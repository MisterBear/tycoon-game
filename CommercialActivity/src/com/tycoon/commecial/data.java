package com.tycoon.commecial;

import java.io.Serializable;
@SuppressWarnings("serial") //with this annotation we are going to hide compiler warning
public class data implements Serializable {

public data(int cash,int generation,int DurationBonus,int PriceBonus,int ValumeBonus)
	{
	this.DurationBonus=DurationBonus;
	this.PriceBonus=PriceBonus;
	this.ValumeBonus=ValumeBonus;
    this.Cash=cash;
    this.Generation=generation;
    }

public int getCash() {
    return Cash;
}
public void setCash(int Cash) {

    this.Cash = Cash;
}

public int getDurationBonus() {
    return DurationBonus;
}
public void setDurationBonus(int DurationBonus) {
    this.DurationBonus = DurationBonus;
}

public int getPriceBonus() {
    return Generation;
}
public void setPriceBonus(int PriceBonus) {
    this.PriceBonus = PriceBonus;
}
public int getValumeBonus() {
    return ValumeBonus;
}
public void setValumeBonus(int ValumeBonus) {
    this.ValumeBonus = ValumeBonus;
}
public int getgeneration() {
    return Generation;
}
public void setgeneration(int generation) {
    this.Generation = generation;
}
private int Generation,Cash,DurationBonus,PriceBonus,ValumeBonus;
}