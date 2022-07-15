package ch.sst.Shop.controller;

import ch.sst.Shop.assembler.ProducerAssembler;
import ch.sst.Shop.exception.ProducerNotFoundException;
import ch.sst.Shop.model.Producer;
import ch.sst.Shop.repository.ProducerRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProducerController {

    private final ProducerRepository repository;

    private final ProducerAssembler assembler;

    public ProducerController(ProducerRepository repository, ProducerAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

//    @GetMapping("/producers")
//    @ResponseStatus(HttpStatus.OK)
//    public CollectionModel<EntityModel<Producer>> all(){
//        List<EntityModel<Producer>> customers = repository.findAll().stream()
//                .map(assembler::toModel)
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(customers,
//                linkTo(methodOn(ProducerController.class).all()).withSelfRel());
//    }
    @GetMapping("/producers")
    @ResponseStatus(HttpStatus.OK)
    public List<Producer> all() {
        return repository.findAll();
    }

    @PostMapping("/producers")
    @ResponseStatus(HttpStatus.CREATED)
    public Producer newProducer(@RequestBody Producer newProducer){
        return repository.save(newProducer);
    }

    @GetMapping("/producers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Producer> one(@PathVariable Long id){
        Producer producer = repository.findById(id)
                .orElseThrow(()-> new ProducerNotFoundException(id));

        return assembler.toModel(producer);
    }

    @PutMapping("/producers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producer replaceProducer(@RequestBody Producer newProducer, @PathVariable Long id){
        return repository.findById(id)
                .map(producer -> {
                    producer.setName(newProducer.getName());
                    producer.setStreet(newProducer.getStreet());
                    producer.setCity(newProducer.getCity());
                    producer.setZip(newProducer.getZip());
                    producer.setCountry(newProducer.getCountry());
                    producer.setPhoneNumber(newProducer.getPhoneNumber());
                    producer.setEmail(newProducer.getEmail());
                    return repository.save(producer);
                })
                .orElseGet(()-> {
                    newProducer.setId(id);
                    return repository.save(newProducer);
                });
    }

    @DeleteMapping("/producers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProducer(@PathVariable Long id){
        repository.deleteById(id);
    }
}