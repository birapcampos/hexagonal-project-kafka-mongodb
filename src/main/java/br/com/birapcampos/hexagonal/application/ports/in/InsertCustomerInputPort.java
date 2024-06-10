package br.com.birapcampos.hexagonal.application.ports.in;

import br.com.birapcampos.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);

}
