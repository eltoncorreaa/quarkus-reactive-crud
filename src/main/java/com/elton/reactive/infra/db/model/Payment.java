/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.infra.db.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
@Table(name = "payment")
public class Payment extends PanacheEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id", nullable = false, length = 15)
	private Long id;

	@Column(name = "total_cost", nullable = false, scale = 18, precision = 8)
	private BigDecimal totalCost;

	@Column(name = "product_item", nullable = false, length = 255)
	public String productItem;

	@Column(name = "customer", nullable = false, length = 255)
	public String customer;

	@JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
	@CreationTimestamp
	public ZonedDateTime createdAt;

	@JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
	@UpdateTimestamp
	public ZonedDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(final BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(final ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getProductItem() {
		return productItem;
	}

	public void setProductItem(final String productItem) {
		this.productItem = productItem;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(final String customer) {
		this.customer = customer;
	}
}
