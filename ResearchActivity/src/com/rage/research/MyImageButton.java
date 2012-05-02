package com.rage.research;

import java.io.Serializable;

import android.content.Context;
import android.widget.ImageButton;
@SuppressWarnings("serial")
public class MyImageButton extends ImageButton implements Serializable{

	private String Title;
	private String Description;
	private Boolean Researched;
	private int WorkSize;
	private int Number;
	private int Cost;
	private int Type;
	

	public MyImageButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MyImageButton(Context context, String title, String description, Boolean researched, int worksize) {
		super(context);
		// TODO Auto-generated constructor stub
		
		Title = title;
		Description = description;
		Researched = researched;
		WorkSize = worksize;
	}
	
	public MyImageButton(Context context, int number, int type) {
		super(context);
		// TODO Auto-generated constructor stub

		Number = number;
		Type = type;
		Title = "Button #" + number;
		Description = "Hello from" + Title;
		Researched = false;
		WorkSize = 10 * number;
		Cost = 50 * number;
		
		//int strId = getResources().getIdentifier("btn" + Number, "string", "com.rage.research");
		//Title = getResources().getString(strId);
		
		
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
	
	public Boolean getResearched()
	{
		return Researched;
	}
	
	public int getWorkSize() {
		return WorkSize;
	}
	
	public int getCost()
	{
		return Cost;
	}
	
	public int getType()
	{
		return Type;
	}
	
	public void setResearching(Boolean bool)
	{
		Researched = bool;
	}
}
