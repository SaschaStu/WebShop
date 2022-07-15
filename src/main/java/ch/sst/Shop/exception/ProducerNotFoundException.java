package ch.sst.Shop.exception;

public class ProducerNotFoundException extends RuntimeException{

    public ProducerNotFoundException(Long id){
        super("Could not find producer "+id);
    }
}
