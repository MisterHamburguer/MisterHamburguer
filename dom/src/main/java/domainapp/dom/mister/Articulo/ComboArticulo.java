package domainapp.dom.mister.Articulo;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberGroupLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.services.eventbus.PropertyDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.util.ObjectContracts;

import domainapp.dom.mister.Articulo.Combo.DescripcionDomainEvent;
import domainapp.dom.mister.Rubro.RubroServicio;

@SuppressWarnings("unused")
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mister",
        table = "ComboArticulo"   
	)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="comboArt_id")
@javax.jdo.annotations.Version(
//        strategy=VersionStrategy.VERSION_NUMBER,
        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(
            name = "ListaTodoComboArt", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.dom.mister.ComboArticulo "),
})
//@javax.jdo.annotations.Unique(name="ComboArt_id_UNQ", members= ("comboArt_id"))

@DomainObject(bounded=true)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)

@Sequence(name ="comboArt_id", strategy= SequenceStrategy.CONTIGUOUS)
public class ComboArticulo {
	public static final int NOMBRE_LENGTH = 40;
	
//	public TranslatableString title() {
//	        return TranslatableString.tr("{nombre}", "nombre", this.getNombre() );
//	    }
	public static class DescripcionDomainEvent extends PropertyDomainEvent<ComboArticulo,String> {
		private static final long serialVersionUID = 1L;
	}
	
	@MemberOrder(sequence="1")
    @javax.jdo.annotations.Column(allowsNull="true")
	@Property(
        domainEvent = DescripcionDomainEvent.class
    )
	private Combo combo;
	public Combo getCombo() {
		return combo;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	@MemberOrder(sequence="2")
    @javax.jdo.annotations.Column(allowsNull="true" )
    @Property(
        domainEvent = DescripcionDomainEvent.class
    )
	private Articulo articulo;
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	@MemberOrder(sequence="3")
    @javax.jdo.annotations.Column(allowsNull="false" )
	private int cantidad;
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
//	@Override
//	public int compareTo(final ComboArticulo o) {
//		return ObjectContracts.compare(this, o, String.valueOf());
//	}
	
	
	@javax.inject.Inject
    RepositoryService repositoryService;
	
	@javax.inject.Inject
    RubroServicio comboArticuloService;
}
