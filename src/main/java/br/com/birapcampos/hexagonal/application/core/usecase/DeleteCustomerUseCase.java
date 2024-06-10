package br.com.birapcampos.hexagonal.application.core.usecase;

import br.com.birapcampos.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.birapcampos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.birapcampos.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }

}
