package br.com.birapcampos.hexagonal.application.core.usecase;

import br.com.birapcampos.hexagonal.application.core.domain.Customer;
import br.com.birapcampos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.birapcampos.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id).orElseThrow(
                () -> new RuntimeException("Customer not found!"));
    }

}
