package domainapp.dom.mister;

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
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;

@DomainService(
        nature = NatureOfService.VIEW,
        repositoryFor = Personal.class
)
@DomainServiceLayout(
        menuOrder = "10"
)
public class PersonalServicio {

	 //region > title
    public TranslatableString title() {
        return TranslatableString.tr("Personal");
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
    public List<Personal> listAll() {
        return repositoryService.allInstances(Personal.class);
    }
    //endregion
    
    //region > create (action)
    public static class CreateDomainEvent extends ActionDomainEvent<PersonalServicio> {
        @SuppressWarnings("deprecation")
		public CreateDomainEvent(final PersonalServicio source, final Identifier identifier, final Object... arguments) {
            super(source, identifier, arguments);
        }
    }

    @Action(
            domainEvent = CreateDomainEvent.class
    )
    @MemberOrder(sequence = "3")
    public Personal create(
    		final @ParameterLayout(named="Legajo") int legajo,
            final @ParameterLayout(named="Nombre") String nombre) {
        final Personal personal = repositoryService.instantiate(Personal.class);
        personal.setNombre(nombre);
        personal.setLegajo(legajo);
        repositoryService.persist(personal);
        return personal;
    }

    
    
    
    //endregion
    
    
    
    
    @javax.inject.Inject
	public
    RepositoryService repositoryService;

}
