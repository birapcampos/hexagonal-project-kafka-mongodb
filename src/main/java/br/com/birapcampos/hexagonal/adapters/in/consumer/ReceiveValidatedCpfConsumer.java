package br.com.birapcampos.hexagonal.adapters.in.consumer;

import br.com.birapcampos.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import br.com.birapcampos.hexagonal.adapters.in.consumer.message.CustomerMessage;
import br.com.birapcampos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private UpdateCustomerInputPort updateCustomerInputPort;
    private CustomerMessageMapper customerMessageMapper;

    @Autowired
    public ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort,
                                       CustomerMessageMapper customerMessageMapper) {
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.customerMessageMapper = customerMessageMapper;
    }

    @KafkaListener(topics = "tp-cpf-validated",groupId = "birapcampos")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer,customerMessage.zipCode());
    }

}
