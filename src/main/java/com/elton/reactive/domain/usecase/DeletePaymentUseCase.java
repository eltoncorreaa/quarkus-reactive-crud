/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.domain.usecase;

import com.elton.reactive.domain.gateway.IPaymentGateway;
import com.elton.reactive.infra.dataprovider.PaymentDataProvider;

import io.smallrye.mutiny.Uni;

public final class DeletePaymentUseCase {

	private final IPaymentGateway gateway;

	public DeletePaymentUseCase(){
		gateway = new PaymentDataProvider();
	}

	public Uni<Boolean> delete(final Long id) {
		return gateway.delete(id);
	}
}