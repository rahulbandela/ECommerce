package com.tap.userdao;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDao {
	
	public void addMenu(Menu menu);
	public Menu getMenu(int id);
	public List<Menu> getAll();
	public void updateMenu(Menu menu);
	public void removeMenu(int id);
	
}
