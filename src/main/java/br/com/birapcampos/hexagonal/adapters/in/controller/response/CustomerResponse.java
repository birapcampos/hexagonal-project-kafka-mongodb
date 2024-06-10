package br.com.birapcampos.hexagonal.adapters.in.controller.response;

import br.com.birapcampos.hexagonal.adapters.out.client.response.AddressResponse;

public record CustomerResponse(
        String name,
        AddressResponse address,
        String cpf,
        Boolean isValidCpf

) {}
