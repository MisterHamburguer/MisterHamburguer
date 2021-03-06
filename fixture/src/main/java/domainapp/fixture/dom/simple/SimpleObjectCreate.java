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

package domainapp.fixture.dom.simple;

import org.apache.isis.applib.fixturescripts.FixtureScript;

import domainapp.dom.mister.Rubro.Rubro;
//import domainapp.dom.mister.Rubro.Rubros;

public class SimpleObjectCreate extends FixtureScript {

    //region > name (input)
    private String name;
    /**
     * Name of the object (required)
     */
    public String getName() {
        return name;
    }

    public SimpleObjectCreate setName(final String name) {
        this.name = name;
        return this;
    }
    //endregion


    //region > rubro (output)
    private Rubro rubro;

    /**
     * The created simple object (output).
     * @return
     */
    public Rubro getSimpleObject() {
        return rubro;
    }
    //endregion

    @Override
    protected void execute(final ExecutionContext ec) {

        String name = checkParam("name", ec, String.class);

//        this.rubro = wrap(rubros).create(0, name);

        // also make available to UI
        ec.addResult(this, rubro);
    }

//    @javax.inject.Inject
//    private Rubros rubros;

}
