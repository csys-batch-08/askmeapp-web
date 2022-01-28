package com.chainsys.dao;

import java.sql.ResultSet;
import java.util.List;

import com.chainsys.model.Category;
import com.chainsys.model.Section;

public interface SectionDAOInterface {
	public void insertSection(Section section);		
	public void update(Section section);
	public  int findSectionId(String sectionName);	
	public  List<Section> showAllSection();	
	public  List<Section> showSectionName(Category category);
			
}
