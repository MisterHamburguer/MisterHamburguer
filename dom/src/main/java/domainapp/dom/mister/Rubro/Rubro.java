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

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.RenderType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.services.eventbus.PropertyDomainEvent;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.util.ObjectContracts;

import domainapp.dom.mister.SubRubro.SubRubro;

@SuppressWarnings("deprecation")
@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
       schema = "mister",
        table = "Rubro"
)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="rubro_id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER,
//       strategy= VersionStrategy.DATE_TIME,
        column="version")
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(
                name = "leerTodos", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.Rubro "),
        @javax.jdo.annotations.Query(
                name = "busPorNom", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.Rubro "
                        + "WHERE nombre == :nombre"
                        + "|| nombre.indexOf(:nombre) >= 0 "),
        @javax.jdo.annotations.Query(
                name = "traerRubro", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.dom.mister.Rubro "
                        + "WHERE nombre == :nombre"
                        + "|| nombre.indexOf(:nombre) >= 0 ")
})
@javax.jdo.annotations.Unique(name="Rubro_nomb_UNQ", members = {"nombre"})
@DomainObject(bounded=true)
@DomainObjectLayout(bookmarking=BookmarkPolicy.AS_ROOT)
public class Rubro implements Comparable<Rubro> {

 
	
	public static final int NAME_LENGTH = 40;


    public TranslatableString title() {
        return TranslatableString.tr("{nombre}", "nombre", this.getNombre());
    }

    public static class DescripcionDomainEvent extends PropertyDomainEvent<Rubro,String> {
    	private static final long serialVersionUID = 1L;
    }   
	/**
	 *  Descripcion del Rublo
	 */
    @javax.jdo.annotations.Column(
            allowsNull="false",
            length = 40
    )
    @Property(
        editing=Editing.ENABLED
    )
   
    @Title(sequence="1")
	@MemberOrder(sequence="1")
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    
   
    
    @MemberOrder(sequence ="2")
    @Persistent(mappedBy = "rubro", dependentElement="false")
    @CollectionLayout(render=RenderType.EAGERLY)
    private SortedSet<SubRubro> subrubro= new TreeSet<SubRubro>();
 
   
    public SortedSet<SubRubro> getSubRubro(){
    	return subrubro;
    }
    public void setSubRubro(final SortedSet<SubRubro> subrubro){
    	this.subrubro=subrubro;
    }
    
    
    @Override
    public int compareTo(final Rubro other) {
        return ObjectContracts.compare(this, other , "nombre");
    }
	@javax.inject.Inject
	public
    RepositoryService repositoryService;
	
	@javax.inject.Inject
    RubroServicio rubroService;

}
