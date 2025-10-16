package com.template.flows

import co.paralleluniverse.fibers.Suspendable
import com.template.contracts.PatientContract
import com.template.states.PatientState
import net.corda.core.flows.*
import net.corda.core.transactions.TransactionBuilder
import java.time.Instant
import java.util.*

@InitiatingFlow
@StartableByRPC
class CreatePatientFlow(
    private val name: String,
    private val address: String,
    private val contact: String
) : FlowLogic<String>() {
    @Suspendable
    override fun call(): String {
        val patientId = UUID.randomUUID().toString()
        val me = ourIdentity
        val notary = serviceHub.networkMapCache.notaryIdentities.first()
        val output = PatientState(patientId, name, address, contact, Instant.now(), me)

        val txBuilder = TransactionBuilder(notary)
            .addOutputState(output)
            .addCommand(PatientContract.Commands.Create(), listOf(me.owningKey))

        txBuilder.verify(serviceHub)
        val stx = serviceHub.signInitialTransaction(txBuilder)
        subFlow(FinalityFlow(stx))
        return patientId
    }
}