package Model;

public class Cliente {
 private int id;
 private int dni;
 private String nombre;
 private double telefono;
 private String direccion;
 private String razon;

public Cliente (){
	
}

public Cliente(int id, int dni, String nombre, double telefono, String direccion, String razon) {
	super();
	this.id = id;
	this.dni = dni;
	this.nombre = nombre;
	this.telefono = telefono;
	this.direccion = direccion;
	this.razon = razon;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getDni() {
	return dni;
}

public void setDni(int dni) {
	this.dni = dni;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}



public double getTelefono() {
    return telefono;
}

public void setTelefono(double telefono) {
    this.telefono = telefono;
}


public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getRazon() {
	return razon;
}

public void setRazon(String razon) {
	this.razon = razon;
}
 
 
 
 
 
 
 
}
