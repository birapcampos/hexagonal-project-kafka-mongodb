package br.com.birapcampos.hexagonal.adapters.out.client.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private String street;
    private String city;
    private String state;
}
