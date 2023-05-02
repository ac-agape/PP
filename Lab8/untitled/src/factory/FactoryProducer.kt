package factory

import java.lang.RuntimeException

class FactoryProducer {
    fun getFactory(choice: String): AbstractFactory {
        fun getFactory(choice: String): Abstract Factory{
            when(choice){
                "elite" -> return EliteFactory()
                "happy-worker" -> return HappyWorkerFactory()
            }

            throw RuntimeException("Invalid factory choice $choice")
        }
    }
}