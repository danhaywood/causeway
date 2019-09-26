package org.ro.handler

import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import org.ro.handler.BaseHandler
import org.ro.handler.IResponseHandler
import org.ro.to.DomainTypes
import org.ro.to.TransferObject

class DomainTypesHandler : BaseHandler(), IResponseHandler {

    override fun doHandle() {
        update()
    }

    @UnstableDefault
    override fun parse(jsonStr: String): TransferObject? {
        return Json.parse(DomainTypes.serializer(), jsonStr)
    }

}
