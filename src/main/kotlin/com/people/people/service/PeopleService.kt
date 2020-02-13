package com.people.people.service

import com.people.people.entity.People
import com.people.people.repository.PeopleRepository
import com.people.people.request.PeopleRequest
import com.people.people.request.PeopleResponse
import org.springframework.stereotype.Service

@Service
class PeopleService (
    private val peopleRepository: PeopleRepository
){

    fun savePeople(peopleRequest: PeopleRequest): PeopleResponse{
        return peopleRepository.save(peopleRequest.toEntity()).toResponse()
    }

    fun delete(id: String){
        peopleRepository.deleteById(id)
    }

    fun edit(id: String, peopleRequest: PeopleRequest): PeopleResponse{
        val people = peopleRepository.getOne(id)

        return peopleRepository.save(people.copy(name = peopleRequest.name)).toResponse()
    }

    fun getById(id: String): PeopleResponse{
        return peopleRepository.getOne(id).toResponse()
    }

    fun getAll(): List<PeopleResponse>{
        return peopleRepository.findAll().map { it.toResponse() }
    }

    private fun PeopleRequest.toEntity(): People = People(
        name = this.name
    )

    private fun People.toResponse(): PeopleResponse = PeopleResponse(
        id = this.id,
        name = this.name
    )
}