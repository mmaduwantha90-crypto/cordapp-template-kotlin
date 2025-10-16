package com.template.states
import net.corda.core.contracts.ContractState
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party
import java.time.Instant

data class HealthRecordState(
    val patientId: String,
    val title: String,
    val value: String,
    val createdAt: Instant,
    val creator: Party
) : ContractState {
    override val participants: List<AbstractParty> get() = listOf(creator)
}