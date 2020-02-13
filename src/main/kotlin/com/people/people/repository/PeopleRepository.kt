package com.people.people.repository

import com.people.people.entity.People
import org.springframework.data.jpa.repository.JpaRepository

interface PeopleRepository: JpaRepository<People, String> {
}