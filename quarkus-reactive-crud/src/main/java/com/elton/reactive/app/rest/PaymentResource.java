/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.app.rest;

import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.elton.reactive.app.dto.PaymentRequest;
import com.elton.reactive.app.service.PaymentService;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Path("/v1/payments")
public class PaymentResource {

	@Inject
	private PaymentService paymentService;

	@POST
	@Path("/save")
	Uni<Response> save(final PaymentRequest request){
		return paymentService.save(request)
				.onItem().transform(response -> Response.ok(response))
				.onItem().transform(Response.ResponseBuilder::build);
	}

	@GET
	@Path("{id}")
	Uni<Response> getById(@PathParam("id") final Long id){
		return paymentService.getById(id)
				.onItem().transform(response -> Response.ok(response))
				.onItem().transform(Response.ResponseBuilder::build);
	}

	@GET
	@Path("/all")
	Uni<Response> getAll(){
		return paymentService.getAll()
				.onItem().transform(response -> Response.ok(response))
				.onItem().transform(Response.ResponseBuilder::build);
	}

	@DELETE
	@Path("{id}")
	Uni<Response> delete(@PathParam("id") final Long id){
		return paymentService.delete(id)
				.onItem().transform(response -> Response.ok(response))
				.onItem().transform(Response.ResponseBuilder::build);
	}

	@PUT
	@Path("{id}")
	public Uni<Response> update(@PathParam("id") final Long id, final PaymentRequest request) {
		Objects.nonNull(request);
		return paymentService.update(id, request)
				.onItem().ifNotNull().transform(entity -> Response.ok(entity).build())
				.onItem().ifNull().continueWith(Response.ok().status(Response.Status.NOT_FOUND)::build);
	}
}