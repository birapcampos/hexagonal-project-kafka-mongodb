package br.com.birapcampos.hexagonal.application.ports.out;

import br.com.birapcampos.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
        Address find(String zipCode);
}
