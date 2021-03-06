package domainapp.dom.mister.Articulo;


import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.Identifier;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.LabelPosition;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.RenderType;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

import domainapp.dom.mister.Personal.Personal;
import domainapp.dom.mister.Personal.PersonalServicio;
import domainapp.dom.mister.Provedor.Proveedor;
import domainapp.dom.mister.Rubro.Rubro;
import domainapp.dom.mister.SubRubro.SubRubro;


@SuppressWarnings("unused")
@DomainService(
        nature = NatureOfService.VIEW,
        repositoryFor = Articulo.class
)
@DomainServiceLayout(
        menuOrder = "20",
        named=" Articulos "
)
public class ArticuloServicio {
		public TranslatableString title() {
			return TranslatableString.tr("Articulo");
		}
	
	    @Action(
	            semantics = SemanticsOf.SAFE
	    )
	    @ActionLayout(
	            bookmarking = BookmarkPolicy.AS_ROOT
	    )
	    @MemberOrder(sequence = "30.1")
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
	    @MemberOrder(sequence = "30.2")
	    public List<Articulo> BuscarPorNombre(
	            @ParameterLayout(named="nombre")
	            final String nombre
	    ) {
	        return repositoryService.allMatches(
	                new QueryDefault<Articulo>(
	                        Articulo.class,
	                        "busXNombre",
	                        "nombre", nombre));
	    }
	    
	    public static class CreateDomainEvent extends ActionDomainEvent<ArticuloServicio> {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("deprecation")
			public CreateDomainEvent(final ArticuloServicio source, final Identifier identifier, final Object... arguments) {
	            super(source, identifier, arguments);
	        }
	    }

	    @Action(
	            domainEvent = CreateDomainEvent.class
	    )
	    
	    @MemberOrder(sequence = "30.3")
	    public Articulo creaArticulo(
	        final @ParameterLayout(named="Codigo") int codigo,
	        final @ParameterLayout(named="Nombre") String nombre, 
	        final @ParameterLayout(named="Codigo Barra") long codBarra,
	        final @ParameterLayout(named="Precio Venta") float precioVenta,
	        final @ParameterLayout(named="Iva ") float iva,
	        final @ParameterLayout(named="Precio Costo") float precioCosto,
	        final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Rubro") Rubro rubro,
	        final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Sub Rubro") SubRubro sub_Rubro,
	        final @ParameterLayout(named="Promocion") boolean promocion,
	        final @ParameterLayout(named="Activo") boolean activo,
	        final @ParameterLayout(named="Observaciones") String observaciones,
	        final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Fecha Alta") LocalDate fechaAlta,
	        final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Personal ") Personal personal,
	        final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named=" Proveedor") Proveedor proveedor) {

	    	final Articulo articulo = repositoryService.instantiate(Articulo.class);
	        articulo.setCodigo(codigo);
	        articulo.setNombre(nombre);
	        articulo.setCodBarra(codBarra);
	        articulo.setPrecioVenta(precioVenta);
	        articulo.setIva(iva);
	        articulo.setPrecioCosto(precioCosto);
	        articulo.setRubro(rubro);
	        articulo.setSub_Rubro(sub_Rubro);
	        articulo.setPromocion(promocion);
	        articulo.setActivo(activo);
	        articulo.setObservaciones(observaciones);
	        articulo.setFechaAlta(fechaAlta);
	        articulo.setPersonal(personal);
	        articulo.setProveedor(proveedor);
	        repositoryService.persist(articulo);
	        return articulo;
	    }
	    
	    
	  //endregion
	    @Action(
	            semantics = SemanticsOf.SAFE
	    )
	    @ActionLayout(
	            bookmarking = BookmarkPolicy.AS_ROOT
	    )
	    @MemberOrder(sequence = "30.4")
	    public List<Combo> listaAll() {
	        return repositoryService.allInstances(Combo.class);
	    }
	  //endregion

	    @Action(
	            domainEvent = CreateDomainEvent.class
	    )
	    
	    @MemberOrder(sequence = "30.5")
	    public Combo creaCombo(
	        
	        final @ParameterLayout( named="Nombre") String nombre, 
	        final @ParameterLayout( named="Precio Venta",multiLine=4 ) float precioVenta,
	        final @ParameterLayout(named="Activo") boolean activo,
	        final @ParameterLayout(named="Observaciones") String observaciones,
	        final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Fecha Alta") LocalDate fechaAlta,
	        final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Personal ") Personal personal 
			){
	    	final Combo combo = repositoryService.instantiate(Combo.class);
	        combo.setNombre(nombre);
	        combo.setPrecioVenta(precioVenta);
	        combo.setActivo(activo);
	        combo.setObservaciones(observaciones);
	        combo.setFechaAlta(fechaAlta);
	        combo.setPersonal(personal);
	        repositoryService.persist(combo);
	        return combo;
	    }
	    
	    //EndRegion
	    
	    
	 	    
	    @Action(
	            domainEvent = CreateDomainEvent.class
	    )
	    
	    @MemberOrder(sequence = "30.6")
	    public ComboArticulo cargaCombo(
	        
	            final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Combo") Combo combo,
	            final @Parameter(optionality=Optionality.OPTIONAL) @ParameterLayout(named="Articulo ") Articulo articulo,
	            final @ParameterLayout(named =" Cantidad ") int cantidad
			){
	    	final ComboArticulo comboart = repositoryService.instantiate(ComboArticulo.class);
	    	comboart.setArticulo(articulo);
	    	comboart.setCombo(combo);
	    	comboart.setCantidad(cantidad);
	    	repositoryService.persist(comboart);
	        return comboart;
	    }
    
	    //EndRegion
	    @Action(
	            semantics = SemanticsOf.SAFE
	    )
	    @ActionLayout(
	            bookmarking = BookmarkPolicy.AS_ROOT
	    )
	    @MemberOrder(sequence = "30.7")
	    public List<ComboArticulo> listComboArt() {
	        return repositoryService.allInstances(ComboArticulo.class);
	    }	    
	    
	    @MemberOrder(sequence ="30.8")
	    @Persistent(mappedBy = "Combo", dependentElement="false")
	    @CollectionLayout(render=RenderType.EAGERLY)
	    private SortedSet<ComboArticulo> comboar= new TreeSet<ComboArticulo>();
	 
	   
	    public SortedSet<ComboArticulo> getComboArticulo(){
	    	return comboar;
	    }
	    public void setcomboArticulo(final SortedSet<ComboArticulo> comboar){
	    	this.comboar=comboar;
	    }
	    
	    @ActionLayout(hidden=Where.EVERYWHERE)
	    public List<Personal> buscarPersonal(String pr){
	 		return repositoryService.allMatches(QueryDefault.create(Personal.class,"traerPersonal","nombre",pr));
	 	}
	    
	    @ActionLayout(hidden=Where.EVERYWHERE)
	    public List<Proveedor> buscarProveedor(String pro){
	 		return repositoryService.allMatches(QueryDefault.create(Proveedor.class,"traerProveedor","nombre",pro));
	 	}
	  //region > injected services
	    @javax.inject.Inject
	 	PersonalServicio PersonalService;
	    
	    @javax.inject.Inject
	    RepositoryService repositoryService;
}
