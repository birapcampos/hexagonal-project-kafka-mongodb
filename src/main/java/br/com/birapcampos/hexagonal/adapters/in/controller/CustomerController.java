package br.com.birapcampos.hexagonal.adapters.in.controller;

import br.com.birapcampos.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.birapcampos.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.birapcampos.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.birapcampos.hexagonal.application.core.domain.Customer;
import br.com.birapcampos.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.birapcampos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.birapcampos.hexagonal.application.ports.in.InsertCustomerInputPort;
import br.com.birapcampos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private InsertCustomerInputPort insertCustomerInputPort;
    private CustomerMapper customerMapper;

    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    private UpdateCustomerInputPort updateCustomerInputPort;
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    @Autowired
    public CustomerController(InsertCustomerInputPort insertCustomerInputPort,
                              CustomerMapper customerMapper,
                              FindCustomerByIdInputPort findCustomerByIdInputPort,
                              UpdateCustomerInputPort updateCustomerInputPort,
                              DeleteCustomerByIdInputPort deleteCustomerByIdInputPort) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.customerMapper = customerMapper;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerByIdInputPort=deleteCustomerByIdInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer,customerRequest.zipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id,
                                       @Valid @RequestBody CustomerRequest customerRequest){

        Customer customer = customerMapper.toCustomer(customerRequest)      ;
        customer.setId(id);
        updateCustomerInputPort.update(customer,customerRequest.zipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
