package com.people.people.request

import javax.validation.constraints.NotNull

data class PeopleRequest(
    @field:NotNull
    val name: String? = null
)

data class PeopleResponse(
    @field:NotNull
    val id: String? = null,

    @field:NotNull
    val name: String? = null

)