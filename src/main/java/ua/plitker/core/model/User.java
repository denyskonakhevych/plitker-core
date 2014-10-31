package ua.plitker.core.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.solr.client.solrj.beans.Field;

@Entity
public class User implements Searchable {
	
	@Id
	@Field(ID_FIELD)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@Field(USERNAME_FIELD)
	@NotNull
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces.")
	private String username;
	
	//@Field(PASSWORD_FIELD)
	@NotNull
	@Size(min = 6, max = 32, message = "The password must be at least 6 characters long.")
	private String password;	
	
	//@Field(EMAIL_FIELD)
	//@Email
	@NotNull
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Please, provide valid email.")
	private String email;
	
	//@Field(FULLNAME_FIELD)
	@NotNull
	@Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
	private String fullName;
	
	@OneToMany(mappedBy = "author")
	private Collection<Message> messages = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Message> folowed = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "usersIFollow")
	private Collection<User> followers = new ArrayList<>();
	
	//@Field(AVATAR_FIELD)
	private String avatar;
	
	//@Field(DESCRIPTION_FIELD)
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

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	public Collection<Message> getSpittersIFollow() {
		return folowed;
	}

	public void setSpittersIFollow(Collection<Message> spittersIFollow) {
		this.folowed = spittersIFollow;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", fullName=" + fullName
				+ ", spittleList=" + messages + ", spittersIFollow="
				+ folowed + ", followers=" + followers + ", avatar="
				+ avatar + ", description=" + description + "]";
	}

}
