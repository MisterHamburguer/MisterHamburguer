package domainapp.dom.mister;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Version;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.services.repository.RepositoryService;


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class Persona implements Serializable {
	
	 
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String nombre;

		
	@MemberOrder(sequence="2")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String apellido;
	@Persistent 
	@MemberOrder(sequence="3")
	@javax.jdo.annotations.Column(allowsNull="false")
	private int telefono;
	@Persistent 
	@MemberOrder(sequence="4")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String email;
	@Persistent 
	@MemberOrder(sequence="5")
	@javax.jdo.annotations.Column(allowsNull="false")
	private int dni;
	@Persistent
	@MemberOrder(sequence="6")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String direccion;
	@Persistent
	@MemberOrder(sequence="7")
	@javax.jdo.annotations.Column(allowsNull="false")
	
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
		

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	@javax.inject.Inject
    RepositoryService repositoryService;


}
