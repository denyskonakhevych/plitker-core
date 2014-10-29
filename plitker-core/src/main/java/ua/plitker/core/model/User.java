package ua.plitker.core.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces.")
	private String username;
	
	@NotNull
	@Size(min = 6, max = 32, message = "The password must be at least 6 characters long.")
	private String password;	
	
	@Email
	@NotNull
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Please, provide valid email.")
	private String email;
	
	@NotNull
	@Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
	private String fullName;
	
	@OneToMany(mappedBy = "author")
	private Collection<Message> spittleList = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Message> spittersIFollow = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "usersIFollow")
	private Collection<User> followers = new ArrayList<>();
	
	private String avatar;
	
	@Size(max = 140)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Collection<Message> getSpittleList() {
		return spittleList;
	}

	public void setSpittleList(Collection<Message> spittleList) {
		this.spittleList = spittleList;
	}

	public Collection<Message> getSpittersIFollow() {
		return spittersIFollow;
	}

	public void setSpittersIFollow(Collection<Message> spittersIFollow) {
		this.spittersIFollow = spittersIFollow;
	}

	public Collection<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Collection<User> followers) {
		this.followers = followers;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", fullName=" + fullName
				+ ", spittleList=" + spittleList + ", spittersIFollow="
				+ spittersIFollow + ", followers=" + followers + ", avatar="
				+ avatar + ", description=" + description + "]";
	}

}
