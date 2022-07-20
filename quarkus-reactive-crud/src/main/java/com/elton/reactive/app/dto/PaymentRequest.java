/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.app.dto;

import java.math.BigDecimal;

public class PaymentRequest {

	private BigDecimal totalCost;
	public String productItem;
	public String customer;

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
}