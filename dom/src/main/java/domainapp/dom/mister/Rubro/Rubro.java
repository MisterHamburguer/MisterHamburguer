/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package domainapp.dom.mister.Rubro;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.eventbus.PropertyDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
       schema = "mister",
        table = "Rubro"
)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
//        strategy=VersionStrategy.VERSION_NUMBER,
        strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(
                name = "find", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.Rubro "),
        @javax.jdo.annotations.Query(
                name = "busPorDes", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.Rubro "
                        + "WHERE descripcion.indexOf(:descripcion) >= 0 ")
})
@javax.jdo.annotations.Unique(name="Rubro_des_UNQ", members = {"descripcion"})
@DomainObject
public class Rubro implements Comparable<Rubro>,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int NAME_LENGTH = 40;


    public TranslatableString title() {
        return TranslatableString.tr("Object: {name}", "descripcion", getDescripcion());
    }

    @Persistent
	@MemberOrder(sequence="1")
	@javax.jdo.annotations.Column(allowsNull="false")
    private int codigo;
    	

    public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
    
	public static class DescripcionDomainEvent extends PropertyDomainEvent<Rubro,String> {}
    @javax.jdo.annotations.Column(
            allowsNull="false",
            length = NAME_LENGTH
    )
    @Property(
        domainEvent = DescripcionDomainEvent.class
    )
    @Persistent
	@MemberOrder(sequence="2")
    private String descripcion;
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

//    public TranslatableString validateDescripcion(final String descripcion) {
//        return descripcion != null && descripcion.contains("!")? TranslatableString.tr("Exclamation mark is not allowed"): null;
//    }



//    public static class DeleteDomainEvent extends ActionDomainEvent<Rubro> {}
//    @Action(
//            domainEvent = DeleteDomainEvent.class,
//            semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE
//    )
//    public void delete() {
//        repositoryService.remove(this);
//    }



    @Override
    public int compareTo(final Rubro other) {
    	int salida=this.descripcion.compareTo(other.getDescripcion());
        return salida;
    }
 

	@javax.inject.Inject
    RepositoryService repositoryService;

}
