package ch.sst.Shop.controller;


import ch.sst.Shop.assembler.CartAssembler;
import ch.sst.Shop.exception.CartNotFoundException;
import ch.sst.Shop.model.Cart;
import ch.sst.Shop.repository.CartRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CartController {

    private final CartRepository repository;

    private final CartAssembler assembler;

    public CartController(CartRepository repository, CartAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/carts")
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<EntityModel<Cart>> all(){
        List<EntityModel<Cart>> customers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(customers,
                linkTo(methodOn(CartController.class).all()).withSelfRel());
    }

    @PostMapping("/carts")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart newCart(@RequestBody Cart newCart){
        return repository.save(newCart);
    }

    @GetMapping("/carts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Cart> one(@PathVariable Long id){
        Cart cart = repository.findById(id)
                .orElseThrow(()-> new CartNotFoundException(id));

        return assembler.toModel(cart);
    }

    @PutMapping("/carts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cart replaceCart(@RequestBody Cart newCart, @PathVariable Long id){
        return repository.findById(id)
                .map(cart -> {
                    cart.setTotalPrice(newCart.getTotalPrice());
                    cart.setProductList(newCart.getProductList());
                    return repository.save(cart);
                })
                .orElseGet(()-> {
                    newCart.setId(id);
                    return repository.save(newCart);
                });
    }

    @DeleteMapping("/carts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCart(@PathVariable Long id){
        repository.deleteById(id);
    }
}
