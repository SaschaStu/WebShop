package ch.sst.Shop.assembler;

import ch.sst.Shop.controller.CartController;
import ch.sst.Shop.model.Cart;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CartAssembler implements RepresentationModelAssembler<Cart, EntityModel<Cart>> {
    @Override
    public EntityModel<Cart> toModel(Cart cart){
        return EntityModel.of(cart,

                linkTo(methodOn(CartController.class).one(cart.getId())).withSelfRel(),
                linkTo(methodOn(CartController.class).all()).withRel("customers")
        );
    }
}
