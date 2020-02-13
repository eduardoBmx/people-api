package com.people.people.controller

import com.people.people.request.PeopleRequest
import com.people.people.request.PeopleResponse
import com.people.people.service.PeopleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@CrossOrigin
@RequestMapping("/people")
class PeopleController(
    private val peopleService: PeopleService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(
        @RequestBody @Valid peopleRequest: PeopleRequest
    ): PeopleResponse = peopleService.savePeople(peopleRequest)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable("id") id: String
    ) = peopleService.delete(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun edit(
        @PathVariable("id") id: String,
        @RequestBody @Valid peopleRequest: PeopleRequest
    ): PeopleResponse = peopleService.edit(id, peopleRequest)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(
        @PathVariable("id") id: String
    ): PeopleResponse = peopleService.getById(id)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<PeopleResponse> = peopleService.getAll()

}