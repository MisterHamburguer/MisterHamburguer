package domainapp.dom.mister.Articulo;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.services.eventbus.PropertyDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.util.ObjectContracts;
import org.joda.time.LocalDate;

import domainapp.dom.mister.Articulo.Articulo.DescripcionDomainEvent;
import domainapp.dom.mister.Personal.Personal;
@SuppressWarnings("unused")
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mister",
        table = "Combo"   
	)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="combo_id")
@javax.jdo.annotations.Version(
//        strategy=VersionStrategy.VERSION_NUMBER,
        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(
            name = "find", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.dom.mister.Combo "),
        @javax.jdo.annotations.Query(
                name = "busXNombre", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.Combo "
                        + "WHERE nombre.indexOf(:nombre)  >= 0 "
 ),
 		@javax.jdo.annotations.Query(
 				name = "traerCombo", language = "JDOQL",
 				value = "SELECT "
                 + "FROM domainapp.dom.mister.Combo "
                 + "WHERE nombre == :nombre"
                 + "|| nombre.indexOf(:nombre) >= 0 ")
    
})
@javax.jdo.annotations.Unique(name="Combo_nom_UNQ", members= ("nombre"))

//@DomainObject(
//		objectType="Combo"
//)
@DomainObject(bounded=true)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)
@Sequence(name ="nombre", strategy= SequenceStrategy.CONTIGUOUS)
public class Combo implements Comparable<Combo> {
	
	public static final int NOMBRE_LENGTH = 40;
	
	public TranslatableString title() {
        return TranslatableString.tr("{nombre}", "nombre", this.getNombre());
    }
	
	public static class DescripcionDomainEvent extends PropertyDomainEvent<Combo,String> {
		private static final long serialVersionUID = 1L;
	}
	
	@MemberOrder(sequence="1")
    @javax.jdo.annotations.Column(
            allowsNull="false",
            length = NOMBRE_LENGTH
    )
    @Property(
        domainEvent = DescripcionDomainEvent.class
    )
	private String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	
	private float precioVenta;
	
	@MemberOrder(sequence="2")
	@javax.jdo.annotations.Column(allowsNull="false")
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(final float precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
	private boolean activo;
	@MemberOrder(sequence="3")
	@javax.jdo.annotations.Column(allowsNull="false")

	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean nombre) {
		this.activo = nombre;
	}
	
	private String observaciones;
	
	@MemberOrder(sequence="4")
	@javax.jdo.annotations.Column(allowsNull="true")
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(final String observaciones) {
		this.observaciones = observaciones;
	}

	private LocalDate fechaAlta;
	
	
	@MemberOrder(sequence="5")
	@javax.jdo.annotations.Column(allowsNull="false")
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	private Personal personal;
	
	@MemberOrder(sequence="6")
	@javax.jdo.annotations.Column(allowsNull="false")
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
	 this.personal=personal;
	}
	
	
	
	@Override
	public int compareTo(final Combo o) {
		return ObjectContracts.compare(this, o, String.valueOf(nombre));
	}
	
	@javax.inject.Inject
    RepositoryService repositoryService;
	

}
