package ch.sst.Shop.controller;


import ch.sst.Shop.assembler.CustomerAssembler;
import ch.sst.Shop.exception.CustomerNotFoundException;
import ch.sst.Shop.model.Customer;
import ch.sst.Shop.repository.CustomerRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    private final CustomerAssembler assembler;

    public CustomerController(CustomerRepository repository, CustomerAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }


    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<EntityModel<Customer>> all(){
        List<EntityModel<Customer>> customers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(customers,
                linkTo(methodOn(CustomerController.class).all()).withSelfRel());
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer newCustomer(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Customer> one(@PathVariable Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(()-> new CustomerNotFoundException(id));

        return assembler.toModel(customer);
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id){
        return repository.findById(id)
                .map(customer -> {
                    customer.setFirstname(newCustomer.getFirstname());
                    customer.setLastname(newCustomer.getLastname());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setPassword(newCustomer.getPassword());
                    customer.setStreet(newCustomer.getStreet());
                    customer.setCity(newCustomer.getCity());
                    customer.setZip(newCustomer.getZip());
                    customer.setCountry(newCustomer.getCountry());
                    return repository.save(customer);
                })
                .orElseGet(()-> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){
        repository.deleteById(id);
    }

}
