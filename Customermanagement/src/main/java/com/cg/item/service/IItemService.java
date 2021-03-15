package com.cg.item.service;

import com.cg.item.entity.Item;

public interface IItemService {
	Item create(double price, String description);
	Item findById(String itemId);
	Item buyItem(String itemId, Long customerId);
}
