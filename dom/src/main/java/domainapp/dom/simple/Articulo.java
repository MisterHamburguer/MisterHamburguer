package domainapp.dom.simple;

import java.util.Date;

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

import domainapp.dom.simple.SimpleObject.DeleteDomainEvent;
import domainapp.dom.simple.SimpleObject.NameDomainEvent;


@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        table = "Articulo"   
	)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
//        strategy=VersionStrategy.VERSION_NUMBER,
        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(
            name = "find", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.dom.simple.Articulo "),
        @javax.jdo.annotations.Query(
                name = "findByCodigo", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.simple.Articulo "
                        + "WHERE descripcion.startWith(:descripcion) "
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
	
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, sequence = "codigo")
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	private int codigo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(final int codigo) {
		this.codigo = codigo;
	}
	
	public static final int DESCRIPCION_LENGTH = 60;
	
	
	
	public static class DescripcionDomainEvent extends PropertyDomainEvent<Articulo,String> {}
    @javax.jdo.annotations.Column(
            allowsNull="false",
            length = DESCRIPCION_LENGTH
    )
    @Property(
        domainEvent = DescripcionDomainEvent.class
    )
	private String descripcion;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	
	private long codBarra;
//	
	@Persistent
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
	@Persistent
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
	
	@Persistent
	@MemberOrder(sequence="5")
	@javax.jdo.annotations.Column(allowsNull="false")
	public float getIva() {
		return iva;
	}
	public void setIva(final float iva) {
		this.iva = iva;
	}
	
	
	private float precioCosto;
	
	@Persistent
	@MemberOrder(sequence="6")
	@javax.jdo.annotations.Column(allowsNull="false")
	public float getPrecioCosto() {
		return precioCosto;
	}
	public void setPrecioCosto(final float precioCosto) {
		this.precioCosto = precioCosto;
	}
	
	private E_Rubro rubro;
	
	@Persistent
	@MemberOrder(sequence="7")
	@javax.jdo.annotations.Column(allowsNull="false")
	public E_Rubro getRubro() {
		return rubro;
	}
	public void setRubro(E_Rubro rubro) {
		this.rubro = rubro;
	}
	
	
	private E_SubRubro sub_Rubro;
	
	@Persistent
	@MemberOrder(sequence="8")
	@javax.jdo.annotations.Column(allowsNull="false")
	public E_SubRubro getSub_Rubro() {
		return sub_Rubro;
	}
	public void setSub_Rubro(E_SubRubro sub_Rubro) {
		this.sub_Rubro = sub_Rubro;
	}

	private boolean promocion;

	@Persistent
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
	
	@Persistent
	@MemberOrder(sequence="10")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(final String observaciones) {
		this.observaciones = observaciones;
	}

	private Date fechaAlta;
	
	@Persistent
	@MemberOrder(sequence="11")
	@javax.jdo.annotations.Column(allowsNull="false")
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
//	private int id_Empleado;
//	private int id_Proveedor;
//	public int getId_Empleado() {
//		return id_Empleado;
//	}
//	public void setId_Empleado(int id_Empleado) {
//		this.id_Empleado = id_Empleado;
//	}
//	public int getId_Proveedor() {
//		return id_Proveedor;
//	}
//	public void setId_Proveedor(int id_Proveedor) {
//		this.id_Proveedor = id_Proveedor;
//	}
	
	
	public static class DeleteDomainEvent extends ActionDomainEvent<Articulo> {}
    @Action(
            domainEvent = DeleteDomainEvent.class,
            semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE
    )
    public void delete() {
        repositoryService.remove(this);
    }  
	  
	@Override
    public int compareTo(final Articulo other) {
        return ObjectContracts.compare(this, other, "codigo");
    }
	
	public enum E_Rubro{
		bebidas,postres,comida;
		
	}
	public enum E_SubRubro {
		Con_Gas,Sin_Gas,alcohol;
	}
	 
    @javax.inject.Inject
    RepositoryService repositoryService;
//
//	
	
}
