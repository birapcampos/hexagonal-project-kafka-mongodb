package br.com.birapcampos.hexagonal.adapters.out;

import br.com.birapcampos.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import br.com.birapcampos.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import br.com.birapcampos.hexagonal.application.core.domain.Address;
import br.com.birapcampos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    private AddressResponseMapper addressResponseMapper;

    @Autowired
    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient,
                                       AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
