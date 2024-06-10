package br.com.birapcampos.hexagonal.config;

import br.com.birapcampos.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.birapcampos.hexagonal.adapters.out.UpdateCustomerAdapter;
import br.com.birapcampos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import br.com.birapcampos.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
        FindCustomerByIdUseCase findCustomerByIdUseCase,
        FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
        UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase,
                findAddressByZipCodeAdapter,
                updateCustomerAdapter);
    }
}
