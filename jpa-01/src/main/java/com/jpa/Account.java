package com.jpa;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Account {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	private String password;
	
	//기본 value 타입 매핑 
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	
	private String yes;
	
	//entity 의 객체로 사용하지 않을 필드 설정
	@Transient
	private String no;
	
	//composite value 타입 매핑
	//composite 객체의 컬럼명 오버라이드로 테이블에서 사용
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name="home_street"))
	})
	@Embedded
	Address address;
	
	
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

	
}
