package com.rage.research;

import java.io.Serializable;

import android.content.Context;
import android.widget.ImageButton;
@SuppressWarnings("serial")
public class MyImageButton extends ImageButton implements Serializable{

	private String Title;
	private String Description;
	private int Research;
	static private int NOT_RESEARCHED = 0;
	static private int CURRENT_RESEARCHED = 1;
	static private int RESEARCHED = 2;
	private int WorkSize;
	private int Number;
	private int Cost;
	private int Type;
	
	public MyImageButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MyImageButton(Context context, String title, String description, int research, int worksize, int number, int type, int cost) {
		super(context);
		// TODO Auto-generated constructor stub
		Number = number;
		Type = type;
		Cost = cost;
		Title = title;
		Description = description;
		Research = research;
		WorkSize = worksize;
	}
	
	public MyImageButton(Context context, int number, int type) {
		super(context);
		// TODO Auto-generated constructor stub

		Number = number;
		Type = type;
		Title = "Button #" + number + " activated";
		Description = "Hello from" + Title;
		Research = NOT_RESEARCHED;
		WorkSize = 10 * number + 100;
		Cost = 100 * number + 100;
		
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
	
	public int getResearch()
	{
		return Research;
	}
	
	public Boolean getResearched()
	{
		if (Research == RESEARCHED)
		return true;
		else return false;
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
	
	public void setResearch(int research)
	{
		Research = research;
	}
}
