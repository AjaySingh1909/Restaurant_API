package com.sopra.Restaurant.Model;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Restaurant_Orders")
public class Order {
	
	@Id
	int orderId;
	
	@Nonnull
	String items;
	
	@Nonnull
	int price;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	@Enumerated(EnumType.ORDINAL)
	private OrderStatus ord;
	
	

}
