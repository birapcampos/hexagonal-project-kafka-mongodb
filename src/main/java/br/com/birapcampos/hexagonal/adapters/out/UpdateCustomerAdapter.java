package br.com.birapcampos.hexagonal.adapters.out;

import br.com.birapcampos.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.birapcampos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.birapcampos.hexagonal.application.core.domain.Customer;
import br.com.birapcampos.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private CustomerRepository customerRepository;
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    public UpdateCustomerAdapter(CustomerRepository customerRepository,
                                 CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
