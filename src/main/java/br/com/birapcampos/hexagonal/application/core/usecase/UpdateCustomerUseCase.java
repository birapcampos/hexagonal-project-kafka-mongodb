package br.com.birapcampos.hexagonal.application.core.usecase;

import br.com.birapcampos.hexagonal.application.core.domain.Customer;
import br.com.birapcampos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import br.com.birapcampos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.birapcampos.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdUseCase.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
