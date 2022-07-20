/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.domain.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class EPayment {

	private Long id;
	private BigDecimal totalCost;
	public String productItem;
	public String customer;
	public ZonedDateTime createdAt;
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
}