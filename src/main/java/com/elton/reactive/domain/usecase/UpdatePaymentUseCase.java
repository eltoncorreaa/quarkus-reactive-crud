/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.domain.usecase;

import com.elton.reactive.cross.ZonedDateFactory;
import com.elton.reactive.domain.entity.EPayment;
import com.elton.reactive.domain.gateway.IPaymentGateway;
import com.elton.reactive.infra.dataprovider.PaymentDataProvider;

import io.smallrye.mutiny.Uni;

public final class UpdatePaymentUseCase {

	private final IPaymentGateway gateway;

	public UpdatePaymentUseCase(){
		gateway = new PaymentDataProvider();
	}

	public Uni<EPayment> update(final Long id, final EPayment ePayment) {
		return gateway.update(id, of(ePayment));
	}

	private EPayment of(final EPayment ePayment){
		// Instantiate ZonedDateTime with Brazil GMT
		ePayment.setUpdatedAt(ZonedDateFactory.now(ZonedDateFactory.BR));
		return ePayment;
	}
}