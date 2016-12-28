package domainapp.dom.mister.Provedor;

import java.util.List;

import org.apache.isis.applib.Identifier;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

import domainapp.dom.mister.Articulo.Articulo;
import domainapp.dom.mister.Personal.Personal;
import domainapp.dom.mister.Personal.PersonalServicio;
import domainapp.dom.mister.Personal.PersonalServicio.CreateDomainEvent;
import domainapp.dom.mister.Rubro.Rubro;

@SuppressWarnings("unused")
@DomainService(
        nature = NatureOfService.VIEW,
        repositoryFor = Proveedor.class
)
@DomainServiceLayout(
        menuOrder = "33",
        named=" Proveedor "
)
public class ProveedorServicio {
	
	public TranslatableString title() {
		return TranslatableString.tr("Proveedor");
	}

    @Action(semantics = SemanticsOf.SAFE
    )
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "33.1")
    public List<Proveedor> listAll() {
        return repositoryService.allInstances(Proveedor.class);
    }
    
    //region > create (action)
    public static class CreateDomainEvent extends ActionDomainEvent<ProveedorServicio> {
	private static final long serialVersionUID = 1L;
		@SuppressWarnings("deprecation")
		public CreateDomainEvent(final ProveedorServicio source, final Identifier identifier, final Object... arguments) {
            super(source, identifier, arguments);
        }
    }

    @Action(
            domainEvent = CreateDomainEvent.class
    )
    @MemberOrder(sequence = "33.2")
    public Proveedor create(
            final @ParameterLayout(named="Nombre Comercial") String nombre,
            final @ParameterLayout(named="Persona de contacto") String contacto,
            final @ParameterLayout(named="Direccion") String direccion,
            final @ParameterLayout(named="Telefono") String telefono,
            final @ParameterLayout(named="Email") @Parameter(regexPattern = RegexValidation.ValidaCorreo.CORREO,
					regexPatternReplacement= "Formato xxxx@xxxxx.xxx.xx " 
            		) String email,
            final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Condicion Iva ") CondicionIva condicion,
            final @ParameterLayout(named="CUIT") @Parameter(regexPattern = RegexValidation.ValidaCuit.CUIT,
					regexPatternReplacement= "Formato 00-00000000-0 " 
            		) String cuit,
            final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Rubro") Rubro rubro		
    		)
    {
        final Proveedor proveedor = repositoryService.instantiate(Proveedor.class);
        
        proveedor.setNombreComercial(nombre);
        proveedor.setContacto(contacto);
        proveedor.setDireccion(direccion);
        proveedor.setTelefono(telefono);
        proveedor.setCorreoElectronico(email);
        proveedor.setCondicion(condicion);
        proveedor.setCuit(cuit);
        proveedor.setRubro(rubro);
        repositoryService.persist(proveedor);
        return proveedor;
    }
   
    
    //endregion
    @javax.inject.Inject
    RepositoryService repositoryService;
}
