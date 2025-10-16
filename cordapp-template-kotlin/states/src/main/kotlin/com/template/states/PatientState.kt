package com.template.states

import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.identity.AbstractParty
import net.corda.core.serialization.CordaSerializable
import java.time.Instant

@CordaSerializable
@BelongsToContract(PatientContract::class)
data class PatientState(
    val patientId: String,
    val name: String,
    val address: String,
    val contact: String,
    val timestamp: Instant,
    val owner: AbstractParty
) : ContractState {
    override val participants: List<AbstractParty> = listOf(owner)
}