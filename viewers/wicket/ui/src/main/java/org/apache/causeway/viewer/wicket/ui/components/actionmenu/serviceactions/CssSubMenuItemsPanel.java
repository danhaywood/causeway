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
package org.apache.causeway.viewer.wicket.ui.components.actionmenu.serviceactions;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.repeater.RepeatingView;

import org.apache.causeway.viewer.wicket.model.links.MenuablesModel;
import org.apache.causeway.viewer.wicket.ui.components.menuable.MenuablePanelAbstract;
import org.apache.causeway.viewer.wicket.ui.util.Wkt;

import lombok.val;

/**
 * Panel containing a list of {@link CssMenuItem}s acting as submenus of a
 * parent {@link CssMenuItem}.
 */
class CssSubMenuItemsPanel
extends MenuablePanelAbstract {

    private static final long serialVersionUID = 1L;

    public CssSubMenuItemsPanel(final String id, final List<CssMenuItem> subMenuItems) {
        super(id, new MenuablesModel(subMenuItems));
        setRenderBodyOnly(true);

        val repeatingView = Wkt.add(this, new RepeatingView(getId()));

        menuablesModel().streamMenuables(CssMenuItem.class)
        .forEach(cssMenuItem->{
            val menuItemMarkup = new WebMarkupContainer(repeatingView.newChildId());
            repeatingView.add(menuItemMarkup);
            cssMenuItem.addTo(menuItemMarkup);
        });

    }

}
