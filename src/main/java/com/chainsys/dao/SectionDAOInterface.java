package com.chainsys.dao;



import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.Category;
import com.chainsys.model.Section;

public interface SectionDAOInterface {
	public void insertSection(Section section) throws SQLException;		
	public void update(Section section) throws SQLException;
	public  int findSectionId(String sectionName) throws SQLException;	
	public  List<Section> showAllSection() throws SQLException;	
	public  List<Section> showSectionName(Category category) throws SQLException;
			
}
