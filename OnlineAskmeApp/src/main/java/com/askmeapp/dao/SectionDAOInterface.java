package com.askmeapp.dao;

import java.sql.ResultSet;


import com.askmeapp.model.Section;

public interface SectionDAOInterface {
	public void insertSection(Section section);		
	public void update(String update,int id);
	public void deletedetails(String delete); 
	public  int findSectionId(String sectionName);	
	public  ResultSet showAllSection();	
	public  ResultSet showSectionName(int id);
			
}
