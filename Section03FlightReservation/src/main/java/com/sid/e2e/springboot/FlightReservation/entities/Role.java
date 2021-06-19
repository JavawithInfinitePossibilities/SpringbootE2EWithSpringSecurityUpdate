/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Lenovo
 *
 */
@Entity
public class Role extends AbstractEntity implements GrantedAuthority {

	@Column(name = "NAME")
	private String name;
	@ManyToMany(mappedBy = "role")
	private Set<User> user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String getAuthority() {
		return name;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", user=" + user + "]";
	}

}
