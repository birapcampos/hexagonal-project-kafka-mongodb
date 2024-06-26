package br.com.birapcampos.hexagonal.adapters.out;

import br.com.birapcampos.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public SendCpfValidationAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String cpf) {

        kafkaTemplate.send("tp-cpf-validation",cpf);
    }
}
