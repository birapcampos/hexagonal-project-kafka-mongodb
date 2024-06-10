package br.com.birapcampos.hexagonal.adapters.out;

import br.com.birapcampos.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.birapcampos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.birapcampos.hexagonal.application.core.domain.Customer;
import br.com.birapcampos.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private CustomerRepository customerRepository;
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    public FindCustomerByIdAdapter(CustomerRepository customerRepository,
                                   CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
