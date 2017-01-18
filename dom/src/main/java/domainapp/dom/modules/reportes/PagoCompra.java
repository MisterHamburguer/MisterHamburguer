package domainapp.dom.modules.reportes;

import java.math.BigDecimal;

	
	import java.util.ArrayList;
	import java.util.List;

	import javax.jdo.annotations.Column;
	import javax.jdo.annotations.IdentityType;
	import javax.jdo.annotations.VersionStrategy;

	import org.apache.isis.applib.IsisApplibModule.ActionDomainEvent;
	import org.apache.isis.applib.annotation.Action;
	import org.apache.isis.applib.annotation.ActionLayout;
	import org.apache.isis.applib.annotation.DomainObject;
	import org.apache.isis.applib.annotation.DomainObjectLayout;
	import org.apache.isis.applib.annotation.MemberOrder;
	import org.apache.isis.applib.annotation.Property;
	import org.apache.isis.applib.annotation.PropertyLayout;
	import org.apache.isis.applib.annotation.SemanticsOf;
	import org.apache.isis.applib.services.i18n.TranslatableString;
	import org.apache.isis.applib.services.repository.RepositoryService;
	import org.apache.isis.applib.util.ObjectContracts;

	
	import domainapp.dom.mister.Provedor.Proveedor;
	import domainapp.dom.mister.Rubro.Rubro;
	import domainapp.dom.modules.reportes.GenerarReporte;
	import domainapp.dom.modules.reportes.PagoCompraReporte;
	import domainapp.dom.mister.NameDomainEvent;
	
	import net.sf.jasperreports.engine.JRException;

	@javax.jdo.annotations.PersistenceCapable(
	        identityType=IdentityType.DATASTORE,
	        schema = "simple",
	        table = "Pago"
	)
	@javax.jdo.annotations.DatastoreIdentity(
	        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
	         column="pagoCliente_id")
	@javax.jdo.annotations.Version(
	        strategy= VersionStrategy.DATE_TIME,
	        column="version")
	@javax.jdo.annotations.Queries({
	    @javax.jdo.annotations.Query(
	            name = "traerTodos", language = "JDOQL",
	            value = "SELECT "
	                    + "FROM domainapp.dom.pagocliente.PagoCliente"),
	    @javax.jdo.annotations.Query(
	            name = "listarPagosPorCliente", language = "JDOQL",
	            value = "SELECT "
	                    + "FROM domainapp.dom.pagoclub.PagoCliente "
	            		+ "WHERE (cliente == :cliente)"),
	    
	})
	@javax.jdo.annotations.Unique(name="PagoCliente_UNQ", members = {"nroTicket"})
	
	@DomainObject(bounded=true)
	@DomainObjectLayout

public class PagoCompra {
		
}

