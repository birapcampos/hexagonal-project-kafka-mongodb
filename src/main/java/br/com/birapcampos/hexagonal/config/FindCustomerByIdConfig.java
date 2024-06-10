package br.com.birapcampos.hexagonal.config;

import br.com.birapcampos.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.birapcampos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter){

        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

}
