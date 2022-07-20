/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.domain.gateway;

import java.util.List;

import com.elton.reactive.domain.entity.EPayment;

import io.smallrye.mutiny.Uni;

public interface IPaymentGateway {

	Uni<EPayment> save(final EPayment ePayment);

	Uni<EPayment> update(final Long id, final EPayment ePayment);

	Uni<Boolean> delete(final Long id);

	Uni<EPayment> getById(final Long id);

	Uni<List<EPayment>> getAll();
}