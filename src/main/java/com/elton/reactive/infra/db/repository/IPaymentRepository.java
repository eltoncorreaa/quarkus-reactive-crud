/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.infra.db.repository;

import java.util.List;

import com.elton.reactive.infra.db.model.Payment;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

public interface IPaymentRepository extends PanacheRepository<Payment> {

	Uni<Payment> update(final Long id, final Payment payment);

	Uni<Payment> save(final Payment payment);

	Uni<List<Payment>> getAll();

	Uni<Payment> getById(final Long id);

	Uni<Boolean> delete(final Long id);
}