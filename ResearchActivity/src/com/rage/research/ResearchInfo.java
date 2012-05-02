package com.rage.research;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResearchInfo implements Serializable{
	
	private String Title;
	private String Description;
	private int WorkSize;
	private int Number;
	private int Cost;
	
	public ResearchInfo (MyImageButton btn)
	{
		Number = btn.getNumber();
		Title = btn.getTitle();
		Description = btn.getDescription();
		WorkSize = btn.getWorkSize();
		Cost = btn.getCost();
	}

	public int getNumber()
	{
		return Number;
	}
	
	public String getTitle()
	{
		return Title;
	}
	
	public String getDescription()
	{
		return Description;
	}
	
	public int getWorkSize() {
		return WorkSize;
	}
	
	public int getCost()
	{
		return Cost;
	}
	

}
