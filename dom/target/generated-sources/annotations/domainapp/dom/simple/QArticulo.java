package domainapp.dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QArticulo extends PersistableExpressionImpl<Articulo> implements PersistableExpression<Articulo>
{
    public static final QArticulo jdoCandidate = candidate("this");

    public static QArticulo candidate(String name)
    {
        return new QArticulo(null, name, 5);
    }

    public static QArticulo candidate()
    {
        return jdoCandidate;
    }

    public static QArticulo parameter(String name)
    {
        return new QArticulo(Articulo.class, name, ExpressionType.PARAMETER);
    }

    public static QArticulo variable(String name)
    {
        return new QArticulo(Articulo.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> codigo;
    public final NumericExpression<Integer> DESCRIPCION_LENGTH;
    public final StringExpression descripcion;
    public final NumericExpression<Long> codBarra;
    public final NumericExpression<Float> precioVenta;
    public final NumericExpression<Float> iva;
    public final NumericExpression<Float> precioCosto;
    public final ObjectExpression<domainapp.dom.simple.Articulo.E_Rubro> rubro;
    public final ObjectExpression<domainapp.dom.simple.Articulo.E_SubRubro> sub_Rubro;
    public final BooleanExpression promocion;
    public final StringExpression observaciones;
    public final DateTimeExpression fechaAlta;
    public final NumericExpression<Integer> id_Empleado;
    public final NumericExpression<Integer> id_Proveedor;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;

    public QArticulo(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.codigo = new NumericExpressionImpl<Integer>(this, "codigo");
        this.DESCRIPCION_LENGTH = new NumericExpressionImpl<Integer>(this, "DESCRIPCION_LENGTH");
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.codBarra = new NumericExpressionImpl<Long>(this, "codBarra");
        this.precioVenta = new NumericExpressionImpl<Float>(this, "precioVenta");
        this.iva = new NumericExpressionImpl<Float>(this, "iva");
        this.precioCosto = new NumericExpressionImpl<Float>(this, "precioCosto");
        this.rubro = new ObjectExpressionImpl<domainapp.dom.simple.Articulo.E_Rubro>(this, "rubro");
        this.sub_Rubro = new ObjectExpressionImpl<domainapp.dom.simple.Articulo.E_SubRubro>(this, "sub_Rubro");
        this.promocion = new BooleanExpressionImpl(this, "promocion");
        this.observaciones = new StringExpressionImpl(this, "observaciones");
        this.fechaAlta = new DateTimeExpressionImpl(this, "fechaAlta");
        this.id_Empleado = new NumericExpressionImpl<Integer>(this, "id_Empleado");
        this.id_Proveedor = new NumericExpressionImpl<Integer>(this, "id_Proveedor");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
    }

    public QArticulo(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.codigo = new NumericExpressionImpl<Integer>(this, "codigo");
        this.DESCRIPCION_LENGTH = new NumericExpressionImpl<Integer>(this, "DESCRIPCION_LENGTH");
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.codBarra = new NumericExpressionImpl<Long>(this, "codBarra");
        this.precioVenta = new NumericExpressionImpl<Float>(this, "precioVenta");
        this.iva = new NumericExpressionImpl<Float>(this, "iva");
        this.precioCosto = new NumericExpressionImpl<Float>(this, "precioCosto");
        this.rubro = new ObjectExpressionImpl<domainapp.dom.simple.Articulo.E_Rubro>(this, "rubro");
        this.sub_Rubro = new ObjectExpressionImpl<domainapp.dom.simple.Articulo.E_SubRubro>(this, "sub_Rubro");
        this.promocion = new BooleanExpressionImpl(this, "promocion");
        this.observaciones = new StringExpressionImpl(this, "observaciones");
        this.fechaAlta = new DateTimeExpressionImpl(this, "fechaAlta");
        this.id_Empleado = new NumericExpressionImpl<Integer>(this, "id_Empleado");
        this.id_Proveedor = new NumericExpressionImpl<Integer>(this, "id_Proveedor");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
    }
}
