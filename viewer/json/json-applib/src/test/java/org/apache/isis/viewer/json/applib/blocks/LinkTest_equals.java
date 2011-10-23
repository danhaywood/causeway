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
package org.apache.isis.viewer.json.applib.blocks;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class LinkTest_equals {

    @Test
    public void equalDependsOnMethodAndHref() throws UnsupportedEncodingException {
        Link link = new Link().withHref("http://localhost:8080/objects/ABC:123").withMethod(Method.GET);
        Link link2 = new Link().withHref("http://localhost:8080/objects/ABC:123").withMethod(Method.GET);
        Link link3 = new Link().withHref("http://localhost:8080/objects/ABC:123").withMethod(Method.PUT);
        Link link4 = new Link().withHref("http://localhost:8080/objects/ABC:456").withMethod(Method.GET);
        
        assertThat(link, is(equalTo(link2)));
        assertThat(link, is(not(equalTo(link3))));
        assertThat(link, is(not(equalTo(link4))));
    }

    @Test
    public void equalDoesNotDependsOnMethodAndHref() throws UnsupportedEncodingException {
        Link link = new Link().withHref("http://localhost:8080/objects/ABC:123").withMethod(Method.GET).withRel("something");
        Link link2 = new Link().withHref("http://localhost:8080/objects/ABC:123").withMethod(Method.GET).withRel("else");
        
        assertThat(link, is(equalTo(link2)));
    }

}
