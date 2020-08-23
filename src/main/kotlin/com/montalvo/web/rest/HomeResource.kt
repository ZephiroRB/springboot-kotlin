package com.montalvo.web.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeResource {

    @GetMapping("/")
    fun index() = "Hola Mundo"

    @GetMapping("/hello/{name}")
    fun get(@PathVariable name: String) = "Hello, $name"
}