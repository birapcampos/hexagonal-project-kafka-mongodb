package br.com.birapcampos.hexagonal.adapters.out.repository.mapper;

import br.com.birapcampos.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.birapcampos.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AddressEntityMapper.class)
public interface CustomerEntityMapper {

    @Mapping(source = "address", target = "addressEntity")
    CustomerEntity toCustomerEntity(Customer customer);
    @Mapping(source = "addressEntity", target = "address")
    Customer toCustomer(CustomerEntity customerEntity);

}
