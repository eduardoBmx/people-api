package com.people.people.entity

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
data class People(
    @Id
    val id: String? = UUID.randomUUID().toString(),
    @NotNull
    val name: String? = null
)