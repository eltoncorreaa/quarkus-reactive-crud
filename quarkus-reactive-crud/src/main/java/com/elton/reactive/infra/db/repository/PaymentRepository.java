/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.infra.db.repository;

import java.time.Duration;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.elton.reactive.infra.db.model.Payment;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
final class PaymentRepository implements IPaymentRepository {

	@Override
	public Uni<Payment> update(final Long id, final Payment payment) {
		return Panache
				.withTransaction(() -> getById(id)
						.onItem().ifNotNull()
						.transform(entity -> {
							entity.setTotalCost(payment.getTotalCost());
							return entity;
						})
						.onFailure().recoverWithNull());
	}

	@Override
	public Uni<Payment> save(final Payment payment) {
		return Panache
				.withTransaction(payment::persist)
				.replaceWith(payment)
				.ifNoItem()
				.after(Duration.ofMillis(10000))
				.fail()
				.onFailure()
				.transform(IllegalStateException::new);
	}

	@Override
	public Uni<List<Payment>> getAll() {
		return listAll(Sort.by("createdAt"))
				.ifNoItem()
				.after(Duration.ofMillis(10000))
				.fail()
				.onFailure()
				.transform(t -> new IllegalStateException());
		//.recoverWithUni(Uni.createFrom().<List<PanacheEntityBase>>item(Collections.EMPTY_LIST));
	}

	@Override
	public Uni<Payment> getById(final Long id) {
		return findById(id);
	}

	@Override
	public Uni<Boolean> delete(final Long id) {
		return Panache.withTransaction(() -> deleteById(id));
	}
}