package br.com.birapcampos.hexagonal.adapters.out;

import br.com.birapcampos.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.birapcampos.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    private CustomerRepository customerRepository;

    @Autowired
    public DeleteCustomerByIdAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
