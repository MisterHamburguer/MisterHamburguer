package domainapp.dom.mister;
import java.util.Date;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.Identifier;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;

import domainapp.dom.mister.Articulo.E_SubRubro;
import domainapp.dom.mister.Articulos.CreateDomainEvent;

@DomainService(
        nature = NatureOfService.VIEW,
        repositoryFor = Cliente.class
)
@DomainServiceLayout(
        menuOrder = "30"
)
public class Clientes {
	public TranslatableString title() {
		return TranslatableString.tr("Clientes:");
	}

    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "1")
    public List<Cliente> listAll() {
        return repositoryService.allInstances(Cliente.class);
    }
    //endregion

    //region > findByName (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "2")
    public List<Cliente> BuscarPorNombre(
            @ParameterLayout(named="descripcion")
            final String descripcion
    ) {
        return repositoryService.allMatches(
                new QueryDefault<Cliente>(
                        Cliente.class,
                        "busXNombre",
                        "descripcion", descripcion));
    }
    
    public static class CreateDomainEvent extends ActionDomainEvent<Cliente> {
        public CreateDomainEvent(final Cliente source, final Identifier identifier, final Object... arguments) {
            super(source, identifier, arguments);
        }
    }

    @Action(
            domainEvent = CreateDomainEvent.class
    )
    
    @MemberOrder(sequence = "3")
    public Cliente creaCliente(
  
        final @ParameterLayout(named="Nombre") String nombre, 
        final @ParameterLayout(named="Apellido") String apellido,
        final @ParameterLayout(named="Domicilio") String domicilio,
        final @ParameterLayout(named="Telefono") int telefono,
        final @ParameterLayout(named="Correo Electronico ") String correoelectronico,
        final @ParameterLayout(named="DNI") int dni,
        final @ParameterLayout(named="Id Proveedor") int id_Proveedor) {
    	final Cliente cliente = repositoryService.instantiate(Cliente.class);
    	 cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDomicilio(domicilio);
        cliente.setTelefono(telefono);
        cliente.setCorreoelectronico(correoelectronico);
        cliente.setDni(dni);
              
        repositoryService.persist(cliente);
        return cliente;
    }
    
    @javax.inject.Inject
    RepositoryService repositoryService;
   
    @javax.inject.Inject 
    DomainObjectContainer container;

}
