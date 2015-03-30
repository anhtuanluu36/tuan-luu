/**
 * 
 */
package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author TuanLA
 *
 */

@Entity
@Table(name = "User")  
public class User {
	
	private Integer userId;
    private String userName;
    private String password;
    private String role;
    private Long version;
    
	/**
	 * @return the userId
	 */
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_user_user_id")
	@SequenceGenerator(name="seq_user_user_id", sequenceName="seq_user_user_id")
    @Column(name = "UserID") 
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	@Column(name = "UserName")
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	@Column(name = "Password")
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	@Column(name = "Role")
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the version
	 */
	
	@Version
	public Long getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
}
