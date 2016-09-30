package domainapp.dom.mister.Personal;

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
import domainapp.dom.mister.Cliente.Cliente;

@SuppressWarnings("unused")
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mister",
        table = "Personal"   
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
                    + "FROM domainapp.dom.mister.Personal "),
})

@javax.jdo.annotations.Unique(name="Personal_legajo_UNQ", members= ("legajo"))
@DomainObject(
		objectType="Personal"
)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)
@Sequence(name ="legajo", strategy= SequenceStrategy.CONTIGUOUS)


public class Personal extends Persona implements Comparable<Personal>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Persistent
	@MemberOrder(sequence="4")
	@javax.jdo.annotations.Column(allowsNull="false")
	private int legajo;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	@javax.inject.Inject
    RepositoryService repositoryService;

	@Override
	public int compareTo(Personal arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

//
	

	
	

	
	
}
