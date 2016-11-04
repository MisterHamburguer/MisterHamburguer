package domainapp.dom.mister.Proveedor;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.services.eventbus.PropertyDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;

import domainapp.dom.mister.Persona;
import domainapp.dom.mister.Articulo.Articulo;
import domainapp.dom.mister.Personal.PersonalServicio;
import domainapp.dom.mister.Rubro.Rubro;

@SuppressWarnings({ "unused", "serial" })
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mister",
        table = "Proveedor"   
	)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="proveedor_id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER,
//        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(
            name = "leerTodosProv", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.dom.mister.Proveedor "),
         @javax.jdo.annotations.Query(
             name = "traerProveedor", language = "JDOQL",
             value = "SELECT "
            		 + "FROM domainapp.dom.mister.Proveedor "
                     + "WHERE nombreComercial == :mombreComercial"
                     + "|| mombreComercial.indexOf(:mombreComercial) >= 0 ")
})
@javax.jdo.annotations.Unique(name="Proveedor_nombrec_UNQ", members= ("nombreComercial"))

@DomainObject(bounded=true)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)
@Sequence(name ="nombreComercial", strategy= SequenceStrategy.CONTIGUOUS)
	
public class Proveedor implements Comparable<Proveedor> {

	
	public static final int NAME_LENGTH = 40;
    public TranslatableString title() {
        return TranslatableString.tr("{nombre}", "nombre", this.getNombreComercial());
    }
    
    
	public static class DescripcionDomainEvent extends PropertyDomainEvent<Proveedor,String> {
		private static final long serialVersionUID = 1L;
	}
	
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String nombreComercial;
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	@MemberOrder(sequence="2")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String contacto;
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	@MemberOrder(sequence="3")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String direccion;
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@MemberOrder(sequence="4")
	@javax.jdo.annotations.Column(allowsNull="false")
	
	private String telefono;
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@MemberOrder(sequence="5")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String correoElectronico;
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	@MemberOrder(sequence="6")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String cuit;
	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	@MemberOrder(sequence="7")
	@javax.jdo.annotations.Column(allowsNull="false")
    private CondicionIva condicion;
	public CondicionIva getCondicion() {
		return condicion;
	}

	public void setCondicion(CondicionIva condicion) {
		this.condicion = condicion;
	}
	
	@MemberOrder(sequence="8")
	@javax.jdo.annotations.Column(allowsNull="false")
	private Rubro rubro;
	
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	@Override
	public int compareTo(Proveedor o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// inject region
	@javax.inject.Inject
    RepositoryService repositoryService;

	@javax.inject.Inject
    PersonalServicio proveedorService;

}
