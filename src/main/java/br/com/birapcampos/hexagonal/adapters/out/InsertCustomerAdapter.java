package br.com.birapcampos.hexagonal.adapters.out;

import br.com.birapcampos.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.birapcampos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.birapcampos.hexagonal.application.core.domain.Customer;
import br.com.birapcampos.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private CustomerRepository customerRepository;
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    public InsertCustomerAdapter(
            CustomerRepository customerRepository,
                                 CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
