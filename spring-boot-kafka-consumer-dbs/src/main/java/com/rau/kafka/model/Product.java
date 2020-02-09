package com.rau.kafka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // by default AUTO
	@Column(nullable = false, unique = true)
	private Integer id;

	@Column(name = "PRODUCT_ID")
	private Long productId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PRICE")
	private Double price;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}



}
