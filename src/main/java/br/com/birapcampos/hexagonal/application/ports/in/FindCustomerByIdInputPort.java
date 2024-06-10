package br.com.birapcampos.hexagonal.application.ports.in;

import br.com.birapcampos.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
