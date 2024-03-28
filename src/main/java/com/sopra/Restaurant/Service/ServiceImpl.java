package com.sopra.Restaurant.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.Restaurant.Model.Order;
import com.sopra.Restaurant.Repository.Repo;

@Service
public class ServiceImpl implements Services {
	
	@Autowired
	private Repo repo;

	@Override
	public Order add_ord(Order od) {
		return repo.save(od);
	}

	@Override
	public void upd_ord(Order od) {
		 repo.save(od);
		
	}

	@Override
	public Order getById(int orderId) {
		Optional<Order> op=repo.findById(orderId);
		return op.get();
	}

	@Override
	public List<Order> getOrderWithinDate(Date startDate, Date endDate) {
		List<Order> lis=repo.getOrdersWithinDate(startDate, endDate);
		return lis;
	}

}
