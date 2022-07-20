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

public final class SavePaymentUseCase {

	private final IPaymentGateway gateway;

	public SavePaymentUseCase(){
		gateway = new PaymentDataProvider();
	}

	public Uni<EPayment> save(final EPayment ePayment) {
		return gateway.save(of(ePayment));
	}

	private EPayment of(final EPayment ePayment){
		// Instantiate ZonedDateTime with Brazil GMT
		ePayment.setCreatedAt(ZonedDateFactory.now(ZonedDateFactory.BR));
		return ePayment;
	}
}