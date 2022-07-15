package ch.sst.Shop.assembler;

import ch.sst.Shop.controller.ProducerController;
import ch.sst.Shop.model.Producer;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProducerAssembler implements RepresentationModelAssembler<Producer, EntityModel<Producer>> {
    @Override
    public EntityModel<Producer> toModel(Producer producer){
        return EntityModel.of(producer,

                linkTo(methodOn(ProducerController.class).one(producer.getId())).withSelfRel(),
                linkTo(methodOn(ProducerController.class).all()).withRel("customers")
        );
    }
}
