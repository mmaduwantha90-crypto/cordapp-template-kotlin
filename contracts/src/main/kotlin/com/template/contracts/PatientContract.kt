package com.template.contracts
import net.corda.core.contracts.CommandData
import net.corda.core.contracts.Contract
import net.corda.core.transactions.LedgerTransaction

class PatientContract : Contract {
    interface Commands : CommandData { class Create : Commands }
    override fun verify(tx: LedgerTransaction) { /* no rules for demo */ }
}