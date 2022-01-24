package com.chainsys.dao;

import java.sql.ResultSet;

import com.chainsys.model.Section;

public interface SectionDAOInterface {
	public void insertSection(Section section);		
	public void update(String update,int id);
	public  int findSectionId(String sectionName);	
	public  ResultSet showAllSection();	
	public  ResultSet showSectionName(int id);
			
}
