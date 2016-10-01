package domainapp.dom.mister.Cliente;

import java.util.List;

import org.apache.isis.applib.Identifier;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;

@DomainService(
        nature = NatureOfService.VIEW,
        repositoryFor = Cliente.class
)
@DomainServiceLayout(
        menuOrder = "20"
)
public class Clientes {
	 //region > title
    public TranslatableString title() {
        return TranslatableString.tr("Cliente");
    }
    //endregion

    //region > listAll (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "1")
    public List<Cliente> VerTodos() {
        return repositoryService.allInstances(Cliente.class);
    }
    //endregion
    
  //region > BuscarPorNombre (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "2")
    public List<Cliente> BuscarPorApellido(
            @ParameterLayout(named="apellido")
            final String apellido
    ) {
        return repositoryService.allMatches(
                new QueryDefault<Cliente>(
                        Cliente.class,
                        "busPorApe",
                        "apellido", apellido));
    }
    //endregion
    
    //region > create (action)
    public static class CreateDomainEvent extends ActionDomainEvent<Clientes> {
        @SuppressWarnings("deprecation")
		public CreateDomainEvent(final Clientes source, final Identifier identifier, final Object... arguments) {
            super(source, identifier, arguments);
        }
    }

    @Action(
            domainEvent = CreateDomainEvent.class
    )
    @MemberOrder(sequence = "3")
    public Cliente NuevoCliente(
    		
            final @ParameterLayout(named="Nombre") String nombre,
            final @ParameterLayout(named="Apellido") String apellido,
            final @ParameterLayout(named="Direccion") String direccion,
            final @ParameterLayout(named="Telefono") int telefono,
            final @ParameterLayout(named="Email") String email,
            final @ParameterLayout(named="DNI") int dni,
            final @ParameterLayout(named="Observaciones") String observaciones,
            final @ParameterLayout(named="Empresa") String empresa) 
    {
        final Cliente cliente = repositoryService.instantiate(Cliente.class);
       
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        cliente.setDni(dni);
        cliente.setObservaciones(observaciones);
        cliente.setEmpresa(empresa);
        
        repositoryService.persist(cliente);
        return cliente;
    }

    
    //endregion
    
    @javax.inject.Inject
	public
    RepositoryService repositoryService;

}
