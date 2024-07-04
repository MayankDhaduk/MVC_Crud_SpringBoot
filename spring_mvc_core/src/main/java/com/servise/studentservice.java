package com.servise;

import java.util.ArrayList;

import com.model.student;

public interface studentservice 
{
	
	public void addorupdate(student st);
	public ArrayList<student> viewalldata();
	public void deletestd(int id);
	public student getbyid(int id);
	
	
	
}
