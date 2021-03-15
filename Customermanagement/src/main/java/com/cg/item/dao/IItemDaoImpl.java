package com.cg.item.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.item.entity.Item;

@Repository
public class IItemDaoImpl implements IItemDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Item add(Item item) {
		
		entityManager.persist(item);
		return item;
	}
	
	@Override 
	public Item update(Item item) {
		
		item = entityManager.merge(item);
		return item;
	}
	
	@Override
	public Item findById(String itemId) {
		
		Item item = entityManager.find(Item.class, itemId);
		return item;
	}
}
