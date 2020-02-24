package com.jp.submo.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription_menu")
public class SubscriptionMenu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="menu_item_id")
	private long menuItemId;
	
	@Column(name="meal_type_id")
	private int mealTypeId;
	
	@Column(name="dish_id")
	private AllDishes allDishes;
	
	@Column(name="softdeleteflag")
	private byte softdeleteflag;

}
