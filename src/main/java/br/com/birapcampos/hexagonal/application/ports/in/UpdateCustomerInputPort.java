package br.com.birapcampos.hexagonal.application.ports.in;

import br.com.birapcampos.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
