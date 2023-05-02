package factory

import chain.CEOHandler
import chain.ExecutiveHandler
import chain.Handler
import chain.ManagerHandler
import java.lang.RuntimeException

class EliteFactory : AbstractFactory() {
    override fun getHandler(handler: String) : Handler {
        when(handler){
            "ceo" -> return CEOHandler()
            "executive" -> return ExecutiveHandler()
            "manager" -> return ManagerHandler()
        }

        throw RuntimeException("Invalid handler $handler")
    }
}