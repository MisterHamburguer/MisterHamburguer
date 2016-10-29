package domainapp.dom.mister;



import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.eventbus.PropertyDomainEvent;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.util.ObjectContracts;
import org.joda.time.LocalDate;


//import domainapp.dom.mister.Rubro.DeleteDomainEvent;
//import domainapp.dom.mister.Rubro.DescripcionDomainEvent;


@SuppressWarnings("unused")
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mister",
        table = "Articulo"   
	)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="articulo_id")
@javax.jdo.annotations.Version(
//        strategy=VersionStrategy.VERSION_NUMBER,
        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(
            name = "find", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.dom.mister.Articulo "),
        @javax.jdo.annotations.Query(
                name = "busXCodigo", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.Articulo "
                        + "WHERE codigo.startWith(:codigo) "
 ),
    
})
@javax.jdo.annotations.Unique(name="Articulo_codigo_UNQ", members= ("codigo"))
@DomainObject(
		objectType="Articulo"
)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)
@Sequence(name ="codigo", strategy= SequenceStrategy.CONTIGUOUS)
public class Articulo  implements Comparable<Articulo>{
	
	//(valueStrategy = IdGeneratorStrategy.INCREMENT, sequence = "codigo")
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	private int codigo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(final int codigo) {
		this.codigo = codigo;
	}
	
	public static final int NOMBRE_LENGTH = 60;
	
	
	
	public static class DescripcionDomainEvent extends PropertyDomainEvent<Articulo,String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;}
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
	
	private long codBarra;
//	
	
	@MemberOrder(sequence="3")
	@javax.jdo.annotations.Column(allowsNull="false")
	public long getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(final long codBarra) {
		this.codBarra = codBarra;
	}
//	
	private float precioVenta;
	
	@MemberOrder(sequence="4")
	@javax.jdo.annotations.Column(allowsNull="false")
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(final float precioVenta) {
		this.precioVenta = precioVenta;
	}
//	
	private float iva;
	
	
	@MemberOrder(sequence="5")
	@javax.jdo.annotations.Column(allowsNull="false")
	public float getIva() {
		return iva;
	}
	public void setIva(final float iva) {
		this.iva = iva;
	}
	
	
	private float precioCosto;
	
	
	@MemberOrder(sequence="6")
	@javax.jdo.annotations.Column(allowsNull="false")
	public float getPrecioCosto() {
		return precioCosto;
	}
	public void setPrecioCosto(final float precioCosto) {
		this.precioCosto = precioCosto;
	}
	
	private Rubro rubro;
	
	
	@MemberOrder(sequence="7")
	@javax.jdo.annotations.Column(allowsNull="true")
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	
	
	private SubRubro sub_Rubro;
	
	
	@MemberOrder(sequence="8")
	@javax.jdo.annotations.Column(allowsNull="true")
	public SubRubro getSub_Rubro() {
		return sub_Rubro;
	}
	public void setSub_Rubro(SubRubro sub_Rubro) {
		this.sub_Rubro = sub_Rubro;
	}

	private boolean promocion;

	
	@MemberOrder(sequence="9")
	@javax.jdo.annotations.Column(allowsNull="false")

	public boolean isPromocion() {
		return promocion;
	}
	public void setPromocion(boolean promocion) {
		this.promocion = promocion;
	}
//	
	private String observaciones;
	
	@MemberOrder(sequence="10")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(final String observaciones) {
		this.observaciones = observaciones;
	}

	private LocalDate fechaAlta;
	
	
	@MemberOrder(sequence="11")
	@javax.jdo.annotations.Column(allowsNull="false")
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	private Personal personal;
	
	@MemberOrder(sequence="12")
	@javax.jdo.annotations.Column(allowsNull="false")
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
	 this.personal=personal;
	}

	private int id_Proveedor;

	
	@MemberOrder(sequence="13")
	@javax.jdo.annotations.Column(allowsNull="false")
	public int getId_Proveedor() {
		return id_Proveedor;
	}
	public void setId_Proveedor(int id_Proveedor) {
		this.id_Proveedor = id_Proveedor;
	}
	
	
	public static class DeleteDomainEvent extends ActionDomainEvent<Articulo> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;}
    @Action(
            domainEvent = DeleteDomainEvent.class,
            semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE
    )
    public void delete() {
        repositoryService.remove(this);
    }  
	  
	@SuppressWarnings("deprecation")
	@Override
    public int compareTo(final Articulo other) {
        return ObjectContracts.compare(this, other, String.valueOf(codigo));
    }
	
	
	
	 
    @javax.inject.Inject
    RepositoryService repositoryService;
//
//	
	
}
