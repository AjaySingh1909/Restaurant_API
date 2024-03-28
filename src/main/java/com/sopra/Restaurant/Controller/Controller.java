package com.sopra.Restaurant.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.Restaurant.Model.Order;
import com.sopra.Restaurant.Model.OrderStatus;
import com.sopra.Restaurant.Service.Services;


@RestController
@RequestMapping("/soprarestaurant")
public class Controller {
	
	@Autowired
	private Services serv;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Order od){
		serv.add_ord(od);
		return new ResponseEntity<>("Order added",HttpStatus.CREATED);
	}
	
	@GetMapping("/getbyid/{orderId}")
	public ResponseEntity<Order> getByOrdID(@PathVariable("orderId") int orderId ){
		Order od=serv.getById(orderId);
		return  new ResponseEntity<>(od,HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> or(@RequestBody OrderStatus or,int orderId){
		Order od=serv.getById(orderId);
		od.setOrd(or);
		serv.upd_ord(od);
		return new ResponseEntity<>("Updated",HttpStatus.OK);
		
	}
	
	@GetMapping("/getbydate/{startDate}/{endDate}")
	public ResponseEntity<List<Order>> getOrderWithinDate(@PathVariable Date startDate, @PathVariable Date endDate ){
		List<Order> lis= serv.getOrderWithinDate(startDate, endDate);
		return new ResponseEntity<List<Order>>(lis, HttpStatus.OK);
	}
	

}
