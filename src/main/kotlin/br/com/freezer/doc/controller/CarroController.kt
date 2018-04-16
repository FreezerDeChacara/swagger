package br.com.freezer.doc.controller

import br.com.freezer.doc.model.Carro
import br.com.freezer.doc.service.CarroService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("Consulta de carros")
@RestController
@RequestMapping("/carros")
class CarroController(val carroService: CarroService) {

    @ApiOperation("Cadastra")
    @PostMapping
    fun cadastrar(@RequestBody carro: Carro): ResponseEntity<String>  {
        carroService.cadastrarCarro(carro)
        return ResponseEntity.ok("Veículo cadastrado.")
    }

    @ApiOperation("Altera")
    @PutMapping("/{id}")
    fun altera(
        @PathVariable("id") id: Long,
        @RequestBody carro: Carro
    ): ResponseEntity<String> {
        return ResponseEntity.ok("Veículo alterado.")
    }

    @ApiOperation("Delete")
    @DeleteMapping("/id")
    fun delete(@RequestBody id: Long): ResponseEntity<String> {
        return ResponseEntity.ok("Veículo excluído")
    }

    @ApiOperation("Carregar todos")
    @GetMapping("/loadall")
    fun carregarTodos(): ResponseEntity<List<Carro>> {
        return ResponseEntity.ok(carroService.loadAll().toList())
    }

}