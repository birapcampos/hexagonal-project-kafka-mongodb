package br.com.birapcampos.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {
    void delete(String id);
}
