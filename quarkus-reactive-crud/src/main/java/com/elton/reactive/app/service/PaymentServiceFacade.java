/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.app.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.elton.reactive.app.dto.PaymentRequest;
import com.elton.reactive.app.dto.PaymentResponse;
import com.elton.reactive.domain.entity.EPayment;
import com.elton.reactive.domain.usecase.DeletePaymentUseCase;
import com.elton.reactive.domain.usecase.FindPaymentUseCase;
import com.elton.reactive.domain.usecase.SavePaymentUseCase;
import com.elton.reactive.domain.usecase.UpdatePaymentUseCase;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public final class PaymentServiceFacade implements PaymentService {

	private final SavePaymentUseCase savePaymentUseCase;
	private final UpdatePaymentUseCase updatePaymentUseCase;
	private final DeletePaymentUseCase deletePaymentUseCase;
	private final FindPaymentUseCase findPaymentUseCase;

	public PaymentServiceFacade(){
		this.savePaymentUseCase = new SavePaymentUseCase();
		this.updatePaymentUseCase = new UpdatePaymentUseCase();
		this.deletePaymentUseCase = new DeletePaymentUseCase();
		this.findPaymentUseCase = new FindPaymentUseCase();
	}

	@Override
	public Uni<PaymentResponse> save(final PaymentRequest request) {
		return savePaymentUseCase.save(Mapper.requestToEPayment(request))
				.onItem()
				.ifNotNull()
				.transform(Mapper::ePaymentToResponse);
	}

	@Override
	public Uni<PaymentResponse> update(final Long id, final PaymentRequest request) {
		return updatePaymentUseCase.update(id, Mapper.requestToEPayment(request))
				.onItem()
				.ifNotNull()
				.transform(Mapper::ePaymentToResponse);
	}

	@Override
	public Uni<Boolean> delete(final Long id) {
		return deletePaymentUseCase.delete(id);
	}

	@Override
	public Uni<PaymentResponse> getById(final Long id) {
		return findPaymentUseCase.getById(id)
				.onItem()
				.ifNotNull()
				.transform(Mapper::ePaymentToResponse);
	}

	@Override
	public Uni<List<PaymentResponse>> getAll() {
		return null;
	}

	static class Mapper {

		public static EPayment requestToEPayment(final PaymentRequest request){
			Objects.nonNull(request);

			final var e = new EPayment();
			e.setCustomer(request.getCustomer());
			e.setProductItem(request.productItem);
			e.setTotalCost(request.getTotalCost());
			return e;
		}

		public static PaymentResponse ePaymentToResponse(final EPayment ePayment){
			Objects.nonNull(ePayment);

			final var response = new PaymentResponse();
			response.setCreatedAt(ePayment.getCreatedAt());
			response.setUpdatedAt(ePayment.getUpdatedAt());
			response.setId(ePayment.getId());
			response.setCustomer(ePayment.getCustomer());
			response.setProductItem(ePayment.getProductItem());
			response.setTotalCost(ePayment.getTotalCost());
			return response;
		}

		public static List<PaymentResponse> ePaymentToResponse(final List<EPayment> ePayments){
			Objects.nonNull(ePayments);

			return ePayments.stream()
					.map(Mapper::ePaymentToResponse)
					.collect(Collectors.toList());
		}
	}
}