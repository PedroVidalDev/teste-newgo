package infrastructure.entities;

public class ErroPersonalizado extends RuntimeException{
    public ErroPersonalizado(String s){
        super(s);
    }
}
