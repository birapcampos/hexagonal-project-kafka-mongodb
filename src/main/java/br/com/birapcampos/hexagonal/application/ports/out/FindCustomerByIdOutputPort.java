package br.com.birapcampos.hexagonal.application.ports.out;

import br.com.birapcampos.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String id);

}
