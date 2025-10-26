import java.io.Serializable;
public abstract class Pieza implements Serializable{
    String nombre;
    String marca;
    double precio;
    String tipo;

    
    public Pieza(String nombre, String marca, double precio, String tipo) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre(){ 
        return nombre; 
    }
    
    public String getMarca(){ 
        return marca;
    }
    
    public double getPrecio(){ 
        return precio; 
    }
    
    public String getTipo(){ 
        return tipo; 
    }

     @Override
    public String toString() {
        return tipo + ": " + nombre + " | Marca: " + marca + " | Precio: $" + precio;
    }
}
