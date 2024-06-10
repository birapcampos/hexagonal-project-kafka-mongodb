package br.com.birapcampos.hexagonal.adapters.out.client;

import br.com.birapcampos.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name="FindAddressByZipCodeClient",
        url = "${birapcampos.client.address.url}"
)
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable ("zipCode") String zipCode);
}
