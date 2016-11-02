package domainapp.dom.mister.SubRubro;

import java.util.List;

import org.apache.isis.applib.Identifier;
import org.apache.isis.applib.IsisApplibModule.ActionDomainEvent;
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
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;

import domainapp.dom.mister.Rubro.Rubro;
import domainapp.dom.mister.Rubro.RubroServicio;

@DomainService(
        nature = NatureOfService.VIEW,
        repositoryFor = SubRubro.class
)
@DomainServiceLayout(
        menuOrder = "12",
        named =" Sub Rubros "
)
public class SubRubroService {
	public TranslatableString title() {
        return TranslatableString.tr("SubRubros");
    }
	
	@Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
    		cssClassFa="fa fa-list",
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "12.1")
    public List<SubRubro> listAllSubRubro() {
        return repositoryService.allInstances(SubRubro.class);
    }
    //region > findByDescripcion (action)
	
	
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
    		cssClassFa="fa fa-list",
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "12.2")
    public List<SubRubro> BuscarPorNombre(
            @ParameterLayout(named="nombre|")
            final String nombreSb
    ) {
        return repositoryService.allMatches(
                new QueryDefault<SubRubro>(
                        SubRubro.class,
                        "busPorDesSb",
                        "nombre", nombreSb));
    }
    //endregion

    //region > create (action)
    public static class CreateDomainEvent extends ActionDomainEvent<SubRubroService> {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		public CreateDomainEvent(final SubRubroService source, final Identifier identifier, final Object... arguments) {
            super(source, identifier, arguments);
        }
    }

    @Action(
            domainEvent = CreateDomainEvent.class
    )
    @ActionLayout(cssClassFa="fa fa-plus-square"
    )
    @MemberOrder(sequence = "12.3")
    public SubRubro createSub(
          @ParameterLayout(named="Descripcion")final String nombre,
          @ParameterLayout(named ="Rubro") final Rubro rubro){
        final SubRubro sbrubro = repositoryService.instantiate(SubRubro.class);
        sbrubro.setNombre(nombre);
        sbrubro.setRubro(rubro);
        repositoryService.persist(sbrubro);
        return sbrubro;
    }

    
    //endregion
   @ActionLayout(hidden=Where.EVERYWHERE)
   public List<Rubro> buscarRubro(String rb){
		return repositoryService.allMatches(QueryDefault.create(Rubro.class,"traerRubro","nombre",rb));
	}
  
   @ActionLayout(hidden = Where.EVERYWHERE)
   public List<SubRubro> buscarSubRubro(String subrubro){
   	return repositoryService.allMatches(QueryDefault.create(SubRubro.class,"leerTodos"));
   }
   //region > injected services
   @javax.inject.Inject
	RubroServicio rubroService;
   
   @javax.inject.Inject
	RepositoryService repositoryService;
    
 
    //endregion
   
}
