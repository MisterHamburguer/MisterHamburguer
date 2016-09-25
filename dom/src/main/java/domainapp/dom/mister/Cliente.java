package domainapp.dom.mister;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mister",
        table = "Cliente"   
	)

@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")

@javax.jdo.annotations.Queries({
	@javax.jdo.annotations.Query(
        name = "find", language = "JDOQL",
        value = "SELECT "
                + "FROM domainapp.dom.mister.Articulo "),
                
})
@DomainObject(
		objectType="Cliente"
)
@DomainObjectLayout(
		bookmarking=BookmarkPolicy.AS_ROOT
)
@Sequence(name ="nombre", strategy= SequenceStrategy.CONTIGUOUS)
public class Cliente extends Persona implements Comparable<Cliente> {
	
//	@Override
//	public int compareTo(Cliente cliente) {
//		
//		return ObjectContracts.compare(this, cliente, "dni");
//	}
//

	public String title() {
			return getApellido() + ", " + getNombre();
		}
	
	@javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

	@Override
	public int compareTo(Cliente o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
