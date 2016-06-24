package domainapp.dom.simple;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.services.repository.RepositoryService;


@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "simple",
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
                name = "findByCodigo", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.simple.Articulo "),
    
})
@javax.jdo.annotations.Unique(name="Articulo_name_UNQ", members= ("codigo"))
@DomainObject(
		objectType="Articulo"
)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)
@Sequence(name ="codigo", strategy= SequenceStrategy.CONTIGUOUS)
public class Articulo  {
	
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, sequence = "codigo")
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	
	private int codigo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
//	private String descripcion;
	
//	@Persistent
//	@MemberOrder(sequence="2")
//	@javax.jdo.annotations.Column(allowsNull="false")
//	public String getDescripcion() {
//		return descripcion;
//	}
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//	
//	private int barra;
//	
//	@Persistent
//	@MemberOrder(sequence="3")
//	@javax.jdo.annotations.Column(allowsNull="false")
//	public int getBarra() {
//		return barra;
//	}
//	public void setBarra(int barra) {
//		this.barra = barra;
//	}
//	
//	private float precioVenta;
//	@Persistent
//	@MemberOrder(sequence="4")
//	@javax.jdo.annotations.Column(allowsNull="false")
//	public float getPrecioVenta() {
//		return precioVenta;
//	}
//	public void setPrecioVenta(float precioVenta) {
//		this.precioVenta = precioVenta;
//	}
//	
//	private int iva;
//	@Persistent
//	@MemberOrder(sequence="5")
//	@javax.jdo.annotations.Column(allowsNull="false")
//	public int getIva() {
//		return iva;
//	}
//	public void setIva(int iva) {
//		this.iva = iva;
//	}
//	
//	
//	private float precioCosto;
//	
//	@Persistent
//	@MemberOrder(sequence="6")
//	@javax.jdo.annotations.Column(allowsNull="false")
//	public float getPrecioCosto() {
//		return precioCosto;
//	}
//	public void setPrecioCosto(float precioCosto) {
//		this.precioCosto = precioCosto;
//	}
//	
//	//private Rubro rubro;
//	//private Sub_Rubro sub_Rubro;
//	private boolean promocion;
//
//	public boolean isPromocion() {
//		return promocion;
//	}
//	public void setPromocion(boolean promocion) {
//		this.promocion = promocion;
//	}
//	
//	private String observaciones;
//	@Persistent
//	@MemberOrder(sequence="7")
//	@javax.jdo.annotations.Column(allowsNull="false")
//	
//	public String getObservaciones() {
//		return observaciones;
//	}
//	public void setObservaciones(String observaciones) {
//		this.observaciones = observaciones;
//	}
//	private Date fechaAlta;
//	@Persistent
//	@MemberOrder(sequence="8")
//	@javax.jdo.annotations.Column(allowsNull="false")
//	public Date getFechaAlta() {
//		return fechaAlta;
//	}
//	public void setFechaAlta(Date fechaAlta) {
//		this.fechaAlta = fechaAlta;
//	}
//	private int id_Empleado;
//	private int id_Proveedor;
//	
//	
//	
//	
//	
//	
//	
////	public Rubro getRubro() {
////		return rubro;
////	}
////	public void setRubro(Rubro rubro) {
////		this.rubro = rubro;
////	}
////	public Sub_Rubro getSub_Rubro() {
////		return sub_Rubro;
////	}
////	public void setSub_Rubro(Sub_Rubro sub_Rubro) {
////		this.sub_Rubro = sub_Rubro;
////	}
////	
//	
//	
//	
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
	
	
	
//	  @javax.inject.Inject
//	    RepositoryService repositoryService;

	
	
}
