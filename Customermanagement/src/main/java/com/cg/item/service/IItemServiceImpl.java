package com.cg.item.service;

import java.time.LocalDateTime;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customer.dao.ICustomerDao;
import com.cg.customer.entities.Customer;
import com.cg.item.dao.IItemDao;
import com.cg.item.entity.Item;

@Service
public class IItemServiceImpl implements IItemService {
	//
	IItemDao itemDao;
	
	//
	ICustomerDao customerDao;
	
	//
	@Override
	public Item create(double price, String description) {
		Item item=new Item(createId(), price, description, LocalDateTime.now());
		itemDao.add(item);
		return item;
	}
	
	@Override
	public Item findById(String itemId) {
		Item item=itemDao.findById(itemId);
		return item;
	}
	
	//
	@Override
	public Item buyItem(String itemId, Long customerId) {
		Customer customer = customerDao.findByID(customerId);
		Item item = itemDao.findById(itemId);
		item.setBoughtBy(customer);
		itemDao.update(item);
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		customerDao.update(customer);
		return item;
	}
	
	public String createId() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10;
		for(int i=0;i<length;i++) {
			int index=random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String id=sb.toString();
		return id;
	}
}
