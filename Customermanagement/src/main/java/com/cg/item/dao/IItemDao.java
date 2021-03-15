package com.cg.item.dao;

import com.cg.item.entity.Item;

public interface IItemDao {
	Item add(Item item);
	Item update(Item item);
	Item findById(String itemId);
}
