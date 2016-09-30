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
        repositoryFor = Rubro.class
)
@DomainServiceLayout(
        menuOrder = "10"
)
public class Rubros {

    //region > title
    public TranslatableString title() {
        return TranslatableString.tr("Rubro");
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
    public List<Rubro> listAll() {
        return repositoryService.allInstances(Rubro.class);
    }
    //endregion

    //region > findByDescripcion (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "2")
    public List<Rubro> BuscarPorDescripcion(
            @ParameterLayout(named="descripcion")
            final String descripcion
    ) {
        return repositoryService.allMatches(
                new QueryDefault<Rubro>(
                        Rubro.class,
                        "busPorDes",
                        "descripcion", descripcion));
    }
    //endregion

    //region > create (action)
    public static class CreateDomainEvent extends ActionDomainEvent<Rubros> {
        public CreateDomainEvent(final Rubros source, final Identifier identifier, final Object... arguments) {
            super(source, identifier, arguments);
        }
    }

    @Action(
            domainEvent = CreateDomainEvent.class
    )
    @MemberOrder(sequence = "3")
    public Rubro create(
    		final @ParameterLayout(named="Codigo") int codigo,
            final @ParameterLayout(named="Descripcion") String descripcion) {
        final Rubro rubro = repositoryService.instantiate(Rubro.class);
        rubro.setDescripcion(descripcion);
        rubro.setCodigo(codigo);
        repositoryService.persist(rubro);
        return rubro;
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
	public
    RepositoryService repositoryService;

    //endregion
}
