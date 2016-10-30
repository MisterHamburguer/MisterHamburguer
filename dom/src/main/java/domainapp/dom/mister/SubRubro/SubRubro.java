package domainapp.dom.mister.SubRubro;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.eventbus.PropertyDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.util.ObjectContracts;

import domainapp.dom.mister.Rubro.Rubro;
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
       schema = "mister",
        table = "SubRubro"
)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="subrubro_id")
@javax.jdo.annotations.Version(
       strategy=VersionStrategy.VERSION_NUMBER,
//        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(
                name = "findSB", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.SubRubro "),
        @javax.jdo.annotations.Query(
                name = "busPorDesSb", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.SubRubro "
                        + "WHERE nombre.indexOf(:nombre) >= 0 "),
        @javax.jdo.annotations.Query(
                name = "listaTodo", language = "JDOQL",
                value = "SELECT "
                + "FROM domainapp.dom.mister.SubRubro ")   
})
@javax.jdo.annotations.Unique(name="SubRubro_nombre_UNQ", members = {"nombre","rubro"})
@DomainObject(bounded=true)
@DomainObjectLayout(bookmarking=BookmarkPolicy.AS_ROOT)
public class SubRubro implements Comparable<SubRubro>{
	
	public TranslatableString title() {
        return TranslatableString.tr("{nombre}", "nombre",this.getNombre());
    }
	
	public static class DescripcionDomainEvent extends PropertyDomainEvent<SubRubro,String> {

		private static final long serialVersionUID = 1L;
		
	}
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(
            allowsNull="false"            
    )
    @Property(
        domainEvent = DescripcionDomainEvent.class,
        editing=Editing.ENABLED
    )
    @Title(sequence="1")
	private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    
    
    @MemberOrder(sequence="2")
    @javax.jdo.annotations.Column(allowsNull="false")
    @Property(editing= Editing.ENABLED)
    private Rubro rubro;
    public Rubro getRubro(){
    	return rubro;
    }
    public void setRubro(final Rubro rubro){
    	this.rubro=rubro;
    }
    
    
    @SuppressWarnings("deprecation")
	@Override
    public int compareTo(final SubRubro other) {
        return ObjectContracts.compare(this, other,"nombre");
    }
 

	@SuppressWarnings("unused")
	@javax.inject.Inject
    private RepositoryService repositoryService;

}
