package com.sopra.Restaurant.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sopra.Restaurant.Model.Order;


@Repository
public interface Repo extends JpaRepository<Order, Integer>{

	@Query(nativeQuery = true, value="Select * from Restaurant_Orders where date between ? and ?")
	List<Order> getOrdersWithinDate(Date startDate, Date endDate);
}
