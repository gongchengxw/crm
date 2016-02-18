/**
 * @author pulem3t
 */
package org.pulem3t.crm.entry;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERITEMS")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ORDER_ID")
	private Long orderId;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	public OrderItem() {
		this.id = System.currentTimeMillis();
	}
	
	public OrderItem(String name, Long companyId, Long productId, Integer quantity, Double price, Double amount) {
		this.id = System.currentTimeMillis();
		this.name = name;
		this.companyId = companyId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public Long getProductId() {
		return productId;
	}
}
