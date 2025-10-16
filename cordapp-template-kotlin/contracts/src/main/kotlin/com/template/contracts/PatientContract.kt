package com.template.contracts

import net.corda.core.contracts.CommandData
import net.corda.core.contracts.Contract
import net.corda.core.contracts.Requirements.using
import net.corda.core.transactions.LedgerTransaction
import net.corda.core.contracts.Command
import net.corda.core.contracts.ContractState

class PatientContract : Contract {
    companion object {
        const val ID = "com.template.contracts.PatientContract"
    }

    interface Commands : CommandData {
        class Create : Commands
    }

    override fun verify(tx: LedgerTransaction) {
        val command = tx.commands.requireSingleCommand<Commands>()
        when (command.value) {
            is Commands.Create -> requireThat {
                // Add contract verification logic here
                "No inputs should be consumed when creating a patient." using (tx.inputs.isEmpty())
                "There should be one output state." using (tx.outputs.size == 1)
                val outputState = tx.outputsOfType<PatientState>().single()
                "The patient ID must not be empty." using (outputState.patientId.isNotEmpty())
                "The name must not be empty." using (outputState.name.isNotEmpty())
                "The address must not be empty." using (outputState.address.isNotEmpty())
                "The contact must not be empty." using (outputState.contact.isNotEmpty())
            }
        }
    }
}