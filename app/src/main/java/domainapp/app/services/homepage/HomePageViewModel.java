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
package domainapp.app.services.homepage;

import java.util.List;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.HomePage;
import org.apache.isis.applib.annotation.ViewModel;

import domainapp.dom.mister.Rubro.Rubro;
import domainapp.dom.mister.Cliente.Cliente;
import domainapp.dom.mister.Cliente.ClienteServicio;
import domainapp.dom.mister.Personal.Personal;
import domainapp.dom.mister.Personal.PersonalServicio;
import domainapp.dom.mister.Provedor.Proveedor;
import domainapp.dom.mister.Provedor.ProveedorServicio;




@ViewModel
public class HomePageViewModel {

	 //region > titulo del Homepage
    public String title() {
        return "Consola de Administracion";
    }
    //endregion

    @HomePage()
    @CollectionLayout(named="Listado Clientes")
    public List<Cliente> getClientes() {
    return clienteServicio.VerTodos();
     }
    
    @HomePage()
    @CollectionLayout(named="Listado Proveedores")
    public List<Proveedor> getProveedores() {
    return proveedorServicio.listAll();
    }
    
    @HomePage()
    @CollectionLayout(named="Listado Personal")
    public List<Personal> getPersonals() {
    return personalServicio.listAll();
    }

    //region > injected services

    @javax.inject.Inject
    domainapp.dom.mister.Rubro.RubroServicio rubroServicio;

    @javax.inject.Inject
    domainapp.dom.mister.Cliente.ClienteServicio clienteServicio;
    
    @javax.inject.Inject
    domainapp.dom.mister.Provedor.ProveedorServicio proveedorServicio;
    
    @javax.inject.Inject
    domainapp.dom.mister.Personal.PersonalServicio personalServicio;
    
    //endregion
}
