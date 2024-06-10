package br.com.birapcampos.hexagonal.adapters.out.repository.mapper;

import br.com.birapcampos.hexagonal.adapters.out.repository.entity.AddressEntity;
import br.com.birapcampos.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressEntityMapper {
    AddressEntity toAddressEntity(Address address);
    Address toAddress(AddressEntity addressEntity);
}
