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
@Table(name = "ADMINS")
public class Admin implements Serializable {

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
	
	public Admin() {
		this.id = System.currentTimeMillis();
		this.firstName = "";
		this.lastName = "";
		this.role = "admin";
		this.creationDate = new Date();
	}
	
	public Admin(String fn, String ln) {
		this.id = System.currentTimeMillis();
		this.firstName = fn;
		this.lastName = ln;
		this.role = "admin";
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

	public Date getCreationDate() {
		return creationDate;
	}
}
