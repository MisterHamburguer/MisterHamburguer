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
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Persistent 
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String nombre;
	@Persistent
	@MemberOrder(sequence="2")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String direccion;
	@Persistent
	@MemberOrder(sequence="3")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@javax.inject.Inject
    RepositoryService repositoryService;
}
