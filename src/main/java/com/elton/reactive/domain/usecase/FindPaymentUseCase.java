/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.domain.usecase;

import java.util.List;

import com.elton.reactive.domain.entity.EPayment;
import com.elton.reactive.domain.gateway.IPaymentGateway;
import com.elton.reactive.infra.dataprovider.PaymentDataProvider;

import io.smallrye.mutiny.Uni;

public final class FindPaymentUseCase {

	private final IPaymentGateway gateway;

	public FindPaymentUseCase(){
		gateway = new PaymentDataProvider();
	}

	public Uni<EPayment> getById(final Long id) {
		return gateway.getById(id);
	}

	public Uni<List<EPayment>> getAll() {
		return gateway.getAll();
	}
}