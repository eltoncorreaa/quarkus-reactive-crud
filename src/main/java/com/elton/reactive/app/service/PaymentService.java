/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.app.service;

import java.util.List;

import com.elton.reactive.app.dto.PaymentRequest;
import com.elton.reactive.app.dto.PaymentResponse;

import io.smallrye.mutiny.Uni;

public interface PaymentService {

	/**
	 *
	 * @param request
	 * @return
	 */
	Uni<PaymentResponse> save(final PaymentRequest request);

	/**
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	Uni<PaymentResponse> update(final Long id, PaymentRequest request);

	/**
	 *
	 * @param id
	 * @return
	 */
	Uni<Boolean> delete(final Long id);

	/**
	 *
	 * @param id
	 * @return
	 */
	Uni<PaymentResponse> getById(final Long id);

	/**
	 *
	 * @return
	 */
	Uni<List<PaymentResponse>> getAll();
}
