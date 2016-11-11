package domainapp.dom.mister.Personal;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.util.ObjectContracts;

import domainapp.dom.mister.Persona;
import domainapp.dom.mister.Rubro.Rubro;

@SuppressWarnings("unused")
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mister",
        table = "Personal"   
	)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="personal_id")
@javax.jdo.annotations.Version(
//        strategy=VersionStrategy.VERSION_NUMBER,
        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(
            name = "leerTodosPer", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.dom.mister.Personal "),
         @javax.jdo.annotations.Query(
             name = "traerPesonal", language = "JDOQL",
             value = "SELECT "
            		 + "FROM domainapp.dom.mister.Personal "
                     + "WHERE nombre == :mombre"
                     + "|| mombre.indexOf(:mombre) >= 0 ")
})

@javax.jdo.annotations.Unique(name="Personal_nombre_UNQ", members= ("nombre"))

@DomainObject(bounded=true)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)
@Sequence(name ="legajo", strategy= SequenceStrategy.CONTIGUOUS)

public class Personal extends Persona implements Comparable<Personal> {
	
	
	public static final int NAME_LENGTH = 40;


    public TranslatableString title() {
        return TranslatableString.tr("{nombre}", "nombre", this.getApellido()+" "+this.getNombre()+"--"+this.getCategoria());
    }
	private static final long serialVersionUID = 1L;
	
	
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	private int legajo;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	@MemberOrder(sequence="2")
	@javax.jdo.annotations.Column(allowsNull="false")
	private Categoria categoria;
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@ActionLayout(hidden = Where.EVERYWHERE)
    public List<Personal> buscarPersonal(String personal){
    	return repositoryService.allMatches(QueryDefault.create(Personal.class,"leerTodosPer"));
    }
	
	@javax.inject.Inject
    RepositoryService repositoryService;

	@javax.inject.Inject
    PersonalServicio personalService;

	@SuppressWarnings("deprecation")
	@Override
	public int compareTo(final Personal arg0) {
		return ObjectContracts.compare(this, arg0 , "nombre");
	}

	
	
}
