package com.template.flows
import co.paralleluniverse.fibers.Suspendable
import com.template.contracts.HealthRecordContract
import com.template.states.HealthRecordState
import net.corda.core.flows.*
import net.corda.core.transactions.TransactionBuilder
import java.time.Instant

@InitiatingFlow
@StartableByRPC
class AddHealthRecordFlow(
    private val patientId: String,
    private val title: String,
    private val value: String
) : FlowLogic<Unit>() {
    @Suspendable
    override fun call() {
        val me = ourIdentity
        val notary = serviceHub.networkMapCache.notaryIdentities.first()
        val output = HealthRecordState(patientId, title, value, Instant.now(), me)

        val txBuilder = TransactionBuilder(notary)
            .addOutputState(output)
            .addCommand(HealthRecordContract.Commands.Create(), listOf(me.owningKey))

        txBuilder.verify(serviceHub)
        val stx = serviceHub.signInitialTransaction(txBuilder)
        subFlow(FinalityFlow(stx))
    }
}