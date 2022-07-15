package ch.sst.Shop.exception;


public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id){
        super("Could not find customer "+id);
    }
}
