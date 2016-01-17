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
@Table(name = "PRODUCTS")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "COMPANY_ID")
	private Long companyId;
	
	@Column(name = "QUANTITY")
	private Long quantity;
	
	@Column(name = "WEIGHT")
	private Double weight;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "TAGS")
	private String tags;

	
	public Product() {
		this.id = System.currentTimeMillis();
		this.creationDate = new Date();
	}
	
	public Product(String name) {
		this.id = System.currentTimeMillis();
		this.name = name;
		this.creationDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Date getCreationDate() {
		return creationDate;
	}

}
