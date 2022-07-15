package ch.sst.Shop.controller;

import ch.sst.Shop.assembler.ProductAssembler;
import ch.sst.Shop.exception.ProductNotFoundException;
import ch.sst.Shop.model.Product;
import ch.sst.Shop.repository.ProductRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProductController {

    private final ProductRepository repository;

    private final ProductAssembler assembler;

    public ProductController(ProductRepository repository, ProductAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<EntityModel<Product>> all(){
        List<EntityModel<Product>> customers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(customers,
                linkTo(methodOn(ProductController.class).all()).withSelfRel());
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product newProduct(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Product> one(@PathVariable Long id){
        Product product = repository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));

        return assembler.toModel(product);
    }

    @PutMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return repository.findById(id)
                .map(product -> {
                    product.setShortname(newProduct.getShortname());
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setStock(newProduct.getStock());
                    product.setSpecifications(newProduct.getSpecifications());
                    product.setProducer(newProduct.getProducer());
                    return repository.save(product);
                })
                .orElseGet(()-> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }
}