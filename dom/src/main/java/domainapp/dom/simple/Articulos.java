package domainapp.dom.simple;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
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
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;

import domainapp.dom.simple.Articulo.E_Rubro;
import domainapp.dom.simple.Articulo.E_SubRubro;
import domainapp.dom.simple.SimpleObjects.CreateDomainEvent;

@DomainService(
        nature = NatureOfService.VIEW,
        repositoryFor = Articulo.class
)
@DomainServiceLayout(
        menuOrder = "20"
)
public class Articulos {
		public TranslatableString title() {
			return TranslatableString.tr("Articulos :");
		}
	
	    @Action(
	            semantics = SemanticsOf.SAFE
	    )
	    @ActionLayout(
	            bookmarking = BookmarkPolicy.AS_ROOT
	    )
	    @MemberOrder(sequence = "1")
	    public List<Articulo> listAll() {
	        return repositoryService.allInstances(Articulo.class);
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
	    public List<Articulo> findByCodigo(
	            @ParameterLayout(named="Codigo")
	            final int codigo
	    ) {
	        return repositoryService.allMatches(
	                new QueryDefault<Articulo>(
	                        Articulo.class,
	                        "ListarPorCodigo",
	                        "Codigo", codigo));
	    }
	    
	    public static class CreateDomainEvent extends ActionDomainEvent<Articulos> {
	        public CreateDomainEvent(final Articulos source, final Identifier identifier, final Object... arguments) {
	            super(source, identifier, arguments);
	        }
	    }

	    @Action(
	            domainEvent = CreateDomainEvent.class
	    )
	    
	    @MemberOrder(sequence = "3")
	    public Articulo creaArticulo(
	        final @ParameterLayout(named="Codigo") int codigo,
	        final @ParameterLayout(named="Descripcion") String descripcion, 
	        final @ParameterLayout(named="Codigo Barra") long codBarra,
	        final @ParameterLayout(named="Precio Venta") float precioVenta,
	        final @ParameterLayout(named="Iva ") float iva,
	        final @ParameterLayout(named="Precio Costo") float precioCosto,
	        final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Rubro") E_Rubro rubro,
	        final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Sub Rubro") E_SubRubro sub_Rubro,
	        final @ParameterLayout(named="Promocion") boolean promocion,
	        final @ParameterLayout(named="Observaciones") String observaciones,
	        final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Fecha Alta") Date fechaAlta) {
	    	final Articulo articulo = repositoryService.instantiate(Articulo.class);
	        articulo.setCodigo(codigo);
	        articulo.setDescripcion(descripcion);
	        articulo.setCodBarra(codBarra);
	        articulo.setPrecioVenta(precioVenta);
	        articulo.setIva(iva);
	        articulo.setPrecioCosto(precioCosto);
	        articulo.setRubro(rubro);
	        articulo.setSub_Rubro(sub_Rubro);
	        articulo.setPromocion(promocion);
	        articulo.setObservaciones(observaciones);
	        articulo.setFechaAlta(fechaAlta);
	        repositoryService.persist(articulo);
	        return articulo;
	    }
	    
	    @javax.inject.Inject
	    RepositoryService repositoryService;
}
