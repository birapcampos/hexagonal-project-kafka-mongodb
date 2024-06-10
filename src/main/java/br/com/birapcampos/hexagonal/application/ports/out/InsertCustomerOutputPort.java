package br.com.birapcampos.hexagonal.application.ports.out;

import br.com.birapcampos.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
        void insert(Customer customer);
}
