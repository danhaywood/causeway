/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.isis.client.kroviz.ui.panel

import io.kvision.utils.obj
import org.apache.isis.client.kroviz.core.event.ResourceProxy
import org.apache.isis.client.kroviz.to.TObject
import org.apache.isis.client.kroviz.ui.core.ViewManager
import org.apache.isis.client.kroviz.ui.dialog.EventExportDialog
import org.apache.isis.client.kroviz.utils.IconManager
import org.apache.isis.client.kroviz.utils.StringUtils

class DynamicMenuBuilder {

    fun buildObjectMenu(tObject: TObject): dynamic {
        val menu = mutableListOf<dynamic>()
        val actions = tObject.getActions()
        actions.forEach {
            val title = StringUtils.deCamel(it.id)
            val icon = IconManager.find(title)
            val invokeLink = it.getInvokeLink()!!
            val command = { ResourceProxy().fetch(invokeLink) }
            val me = buildMenuEntry(icon, title, command)
            menu.add(me)
        }
        return menu.toTypedArray().asDynamic()
    }

    fun buildTableMenu(table: EventLogTable): dynamic {
        val menu = mutableListOf<dynamic>()

        val export = buildMenuEntry("Export", "Export Events ...", {
            EventExportDialog().open()
        })
        menu.add(export)

        val download = buildMenuEntry("Tabulator Download", "Tabulator Download", {
            this.downLoadCsv(table)
        })
        menu.add(download)

        val bubbleTitle = "Bubble Chart"
        val bubble = buildMenuEntry(bubbleTitle, bubbleTitle, {
            ViewManager.add(bubbleTitle, EventBubbleChart())
        })
        menu.add(bubble)

        val pieTitle = "Pie Chart"
        val pie = buildMenuEntry(pieTitle, pieTitle, {
            ViewManager.add(pieTitle, EventPieChart())
        })
        menu.add(pie)

        return menu.toTypedArray().asDynamic()
    }

    private fun buildMenuEntry(icon: String, title: String, act: dynamic): dynamic {
        val iconName = IconManager.find(icon)
        val l = "<i class='$iconName'></i> $title"
        return obj {
            label = l
            action = act
        }
    }

    private fun downLoadCsv(table: EventLogTable) {
        table.tabulator.downloadCSV("data.csv")
    }

}
