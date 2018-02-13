package fr.dwaps.model.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.mindrot.jbcrypt.BCrypt;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstname;
	private String lastname;
	private String pseudo;
	@Transient
	private String password;
	@Column(name="hash")
	private String hashedPassword;
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Embedded
	private Address address;
	
	public User() {}
	public User(String firstname, String lastname, Date birthday, String pseudo, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.pseudo = pseudo;
		this.setPassword(password);
	}
	
	public boolean checkPassword(String p) {
		return BCrypt.checkpw(p, this.getHashedPassword());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
