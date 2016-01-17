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
@Table(name = "VENDORS")
public class Vendor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "ROLE")
	private int role;
	
	public Vendor() {
		this.id = System.currentTimeMillis();
		this.role = 1;
	}
	
	public Vendor(String fn, String ln) {
		this.id = System.currentTimeMillis();
		this.firstName = fn;
		this.lastName = ln;
		this.role = 1;
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

	public int getRole() {
		return role;
	}
	
	public void setRole(int i) {
		this.role = i;
	}
}
