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
package org.apache.isis.extensions.secman.model.dom.permission;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.MemberSupport;
import org.apache.isis.extensions.secman.api.permission.ApplicationPermission;
import org.apache.isis.extensions.secman.api.permission.ApplicationPermission.UpdateRoleDomainEvent;
import org.apache.isis.extensions.secman.api.role.dom.ApplicationRole;
import org.apache.isis.extensions.secman.api.role.dom.ApplicationRoleRepository;

import lombok.RequiredArgsConstructor;

@Action(
        domainEvent = UpdateRoleDomainEvent.class,
        associateWith = "role")
@RequiredArgsConstructor
public class ApplicationPermission_updateRole {

    @Inject private ApplicationRoleRepository<? extends ApplicationRole> applicationRoleRepository;

    private final ApplicationPermission target;

    @MemberSupport
    public ApplicationPermission act(final ApplicationRole applicationRole) {
        target.setRole(applicationRole);
        return target;
    }

    @MemberSupport
    public ApplicationRole default0Act() {
        return target.getRole();
    }

    @MemberSupport
    public Collection<? extends ApplicationRole> choices0Act() {
        return applicationRoleRepository.allRoles();
    }

}
