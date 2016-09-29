package domainapp.dom.mister.Cliente;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.services.repository.RepositoryService;

import domainapp.dom.mister.Persona;

@SuppressWarnings("unused")
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mister",
        table = "Cliente"   
	)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="idcliente")
@javax.jdo.annotations.Version(
//        strategy=VersionStrategy.VERSION_NUMBER,
        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(
            name = "find", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.dom.mister.Cliente "),
                    @javax.jdo.annotations.Query(
                            name = "busPorApe", language = "JDOQL",
                            value = "SELECT "
                                    + "FROM domainapp.dom.mister.Cliente "
                                    + "WHERE apellido.indexOf(:apellido) >= 0 ")
})

@javax.jdo.annotations.Unique(name="Cliente_idcliente_UNQ", members= ("idcliente"))
@DomainObject(
		objectType="Cliente"
)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)
@Sequence(name ="idcliente", strategy= SequenceStrategy.CONTIGUOUS)

public class Cliente extends Persona implements Comparable<Cliente>,Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Persistent 
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
	private int idcliente;	
	@Persistent 
	@MemberOrder(sequence="2")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String observaciones;
	@Persistent 
	@MemberOrder(sequence="3")
	@javax.jdo.annotations.Column(allowsNull="false")
	private String empresa;	
	
	@Persistent
	@MemberOrder(sequence="4")
	@javax.jdo.annotations.Column(allowsNull="false")
	
	
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	@javax.inject.Inject
    RepositoryService repositoryService;

	@Override
	public int compareTo(Cliente arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
