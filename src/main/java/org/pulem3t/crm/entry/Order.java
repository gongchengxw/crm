/**
 * @author pulem3t
 */
package org.pulem3t.crm.entry;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	
	@Column(name = "MANAGER_ID")
	private Long managerId;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@Column(name = "DELIVERY_ADDRESS")
	private String deliveryAddress;
	
	public Order() {
		this.id = System.currentTimeMillis();
		this.creationDate = new Date();
	}
	
	public Order(Long customerId, Long managerId, Double amount, String deliveryAddress) {
		this.id = System.currentTimeMillis();
		this.customerId = customerId;
		this.managerId = managerId;
		this.amount = amount;
		this.deliveryAddress = deliveryAddress;
		this.creationDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}
