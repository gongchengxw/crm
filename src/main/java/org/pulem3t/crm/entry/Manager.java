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
@Table(name = "MANAGERS")
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "ROLE")
	private String role;

	@Column(name = "CREATION_DATE")
	private Date creationDate;	
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "FAX")
	private String fax;
	
	@Column(name = "LAST_VISIT")
	private Date lastVisit;
	
	public Manager() {
		this.id = System.currentTimeMillis();
		this.role = "manager";
		this.creationDate = new Date();
	}
	
	public Manager(String fn, String ln) {
		this.id = System.currentTimeMillis();
		this.firstName = fn;
		this.lastName = ln;
		this.role = "manager";
		this.creationDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}
