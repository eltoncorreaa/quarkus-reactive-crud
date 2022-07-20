/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.infra.dataprovider;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.elton.reactive.domain.entity.EPayment;
import com.elton.reactive.domain.gateway.IPaymentGateway;
import com.elton.reactive.infra.db.model.Payment;
import com.elton.reactive.infra.db.repository.IPaymentRepository;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public final class PaymentDataProvider implements IPaymentGateway {

	@Inject
	private IPaymentRepository repository;

	@Override
	public Uni<EPayment> save(final EPayment ePayment) {
		return repository.save(Mapper.ePaymentToPayment(ePayment))
				.onItem()
				.ifNotNull()
				.transform(Mapper::paymentToePayment);
	}

	@Override
	public Uni<EPayment> update(final Long id, final EPayment ePayment) {
		return repository.update(id, Mapper.ePaymentToPayment(ePayment))
				.onItem()
				.ifNotNull()
				.transform(Mapper::paymentToePayment);
	}

	@Override
	public Uni<Boolean> delete(final Long id) {
		return repository.delete(id);
	}

	@Override
	public Uni<EPayment> getById(final Long id) {
		return repository.getById(id)
				.onItem()
				.ifNotNull()
				.transform(Mapper::paymentToePayment);
	}

	@Override
	public Uni<List<EPayment>> getAll() {
		return repository.getAll()
				.onItem()
				.ifNotNull()
				.transform(Mapper::paymentToePayment);
	}

	static class Mapper {

		public static Payment ePaymentToPayment(final EPayment ePayment){
			Objects.nonNull(ePayment);

			final var p = new Payment();
			p.setTotalCost(ePayment.getTotalCost());
			p.setCreatedAt(ePayment.getCreatedAt());
			p.setUpdatedAt(ePayment.getUpdatedAt());
			p.setCustomer(ePayment.getCustomer());
			p.setProductItem(ePayment.getProductItem());
			return p;
		}

		public static EPayment paymentToePayment(final Payment payment){
			Objects.nonNull(payment);

			final var e = new EPayment();
			e.setTotalCost(payment.getTotalCost());
			e.setCreatedAt(payment.getCreatedAt());
			e.setUpdatedAt(payment.getUpdatedAt());
			e.setCustomer(payment.getCustomer());
			e.setProductItem(payment.getProductItem());
			return e;
		}

		public static List<EPayment> paymentToePayment(final List<Payment> payments){
			Objects.nonNull(payments);
			return payments.stream()
					.map(Mapper::paymentToePayment)
					.collect(Collectors.toList());
		}
	}
}