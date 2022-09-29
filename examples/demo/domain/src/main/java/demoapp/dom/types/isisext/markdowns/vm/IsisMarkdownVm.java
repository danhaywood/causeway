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
package demoapp.dom.types.isisext.markdowns.vm;

import javax.inject.Named;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Nature;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.Title;

import lombok.Getter;
import lombok.Setter;

import demoapp.dom._infra.asciidocdesc.HasAsciiDocDescription;
import demoapp.dom.types.isisext.markdowns.holder.IsisMarkdownHolder2;

/* This file was GENERATED by the showcase generator (tooling). Do NOT edit! */
//tag::class[]
@XmlRootElement(name = "root")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Named("demo.IsisMarkdownVm")
@DomainObject(
        nature=Nature.VIEW_MODEL)
@lombok.NoArgsConstructor                                                       // <.>
public class IsisMarkdownVm
        implements HasAsciiDocDescription, IsisMarkdownHolder2 {

//end::class[]
    public IsisMarkdownVm(final org.apache.isis.valuetypes.markdown.applib.value.Markdown initialValue) {
        this.readOnlyProperty = initialValue;
        this.readWriteProperty = initialValue;
    }

//tag::class[]
    @Title(prepend = "org.apache.isis.valuetypes.markdown.applib.value.Markdown view model: ")
    @PropertyLayout(fieldSetId = "read-only-properties", sequence = "1")
    @XmlElement(required = true)                                                // <.>
    @Getter @Setter
    private org.apache.isis.valuetypes.markdown.applib.value.Markdown readOnlyProperty;

    @Property(editing = Editing.ENABLED)                                        // <.>
    @PropertyLayout(fieldSetId = "editable-properties", sequence = "1")
    @XmlElement(required = true)
    @Getter @Setter
    private org.apache.isis.valuetypes.markdown.applib.value.Markdown readWriteProperty;

    @Property(optionality = Optionality.OPTIONAL)                               // <.>
    @PropertyLayout(fieldSetId = "optional-properties", sequence = "1")
    @Getter @Setter
    private org.apache.isis.valuetypes.markdown.applib.value.Markdown readOnlyOptionalProperty;

    @Property(editing = Editing.ENABLED, optionality = Optionality.OPTIONAL)
    @PropertyLayout(fieldSetId = "optional-properties", sequence = "2")
    @Getter @Setter
    private org.apache.isis.valuetypes.markdown.applib.value.Markdown readWriteOptionalProperty;

}
//end::class[]
