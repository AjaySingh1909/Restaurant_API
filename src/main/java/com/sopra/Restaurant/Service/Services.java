package com.sopra.Restaurant.Service;

import java.sql.Date;
import java.util.List;

import com.sopra.Restaurant.Model.Order;

public interface Services {
	
	public Order add_ord(Order od);
	
	public void upd_ord(Order od);
	
	public Order getById(int orderId);

	public List<Order> getOrderWithinDate(Date startDate, Date endDate);
}
