package com.example.jwt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UsersInfo")
public class Users {
	    
	    @Id
		@Column(name="uid", length=45)
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int uid;
		@Column(name="username", length=30)
		private String username;
		@Column(name="email",length=30)
		private String email;
		@Column(name="password",length=30)
		private String password;
		
	
		
		public Users(int uid, String username, String email, String password) {
			super();
			this.uid = uid;
			this.username = username;
			this.email = email;
			this.password = password;
		}

		public Users() {
		}

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Users [uid=" + uid + ", username=" + username + ", email=" + email + ", password=" + password + "]";
		}
	
	

		
}
