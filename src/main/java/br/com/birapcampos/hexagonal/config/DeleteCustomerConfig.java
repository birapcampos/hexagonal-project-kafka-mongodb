package br.com.birapcampos.hexagonal.config;

import br.com.birapcampos.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import br.com.birapcampos.hexagonal.application.core.usecase.DeleteCustomerUseCase;
import br.com.birapcampos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {
    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
            ){

        return new DeleteCustomerUseCase(findCustomerByIdUseCase,deleteCustomerByIdAdapter);
    }

}
