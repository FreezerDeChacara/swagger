package br.com.freezer.doc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DocApplication

fun main(args: Array<String>) {
    SpringApplication.run(DocApplication::class.java, *args)
}
