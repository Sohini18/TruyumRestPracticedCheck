package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> MENUITEM_LIST = new ArrayList<>();

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);

	@SuppressWarnings({ "unchecked", "resource" })
	public MenuItemDaoCollectionImpl() {
		ApplicationContext apx = new ClassPathXmlApplicationContext("menuitem.xml");
		MENUITEM_LIST = (List<MenuItem>) apx.getBean("menuitem_list");
		LOGGER.debug("MenuItems:{}", MENUITEM_LIST);
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		return MENUITEM_LIST;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		try {
			MenuItem item = getMenuItem(menuItem.getId());
			item.setName(menuItem.getName());
			item.setPrice(menuItem.getPrice());
			item.setActive(menuItem.isActive());
			item.setFreeDelivery(menuItem.isFreeDelivery());
		} catch (MenuItemNotFoundException e) {
			e.getMessage();
		}
	}

	@Override
	public MenuItem getMenuItem(long id) throws MenuItemNotFoundException {
		MenuItem m = null;
		for (MenuItem mi : MENUITEM_LIST) {
			if (id == mi.getId()) {
				m = mi;
			}
		}
		if (m == null) {
			throw new MenuItemNotFoundException("Menu Item Not Found");
		} else {
			return m;
		}

	}

}