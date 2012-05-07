package com.rage.research;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResearchInfo implements Serializable{
	
	private String Title;
	private String Description;
	private int WorkSize;
	private int Number;
	private int Cost;
	private Boolean Researched;
	private int Type;
	
	public ResearchInfo (MyImageButton btn)
	{
		Number = btn.getNumber();
		Type = btn.getType();
		Title = btn.getTitle();
		Description = btn.getDescription();
		WorkSize = btn.getWorkSize();
		Cost = btn.getCost();
	}
	
	public ResearchInfo(int number, int type, Boolean researched)
	{
		Number = number;
		Type = type;
		Researched = researched;
	}

	public int getNumber()
	{
		return Number;
	}
	
	public int getType()
	{
		return Type;
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
	
	public Boolean getResearched()
	{
		return Researched;
	}
	
	public void setWorkSize(int worksize)
	{
		WorkSize = worksize;
	}
}
