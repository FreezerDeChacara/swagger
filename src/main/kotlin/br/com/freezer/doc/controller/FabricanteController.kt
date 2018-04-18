package br.com.freezer.doc.controller

import br.com.freezer.doc.model.Fabricante
import br.com.freezer.doc.service.FabricanteService
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

@Api("Consulta de fabricante")
@RestController
@RequestMapping("/fabricantes")
class FabricanteController(val fabricanteService: FabricanteService) {

    @ApiOperation("Cadastra")
    @PostMapping
    fun cadastrar(@RequestBody fabricante: Fabricante): ResponseEntity<String> {
        fabricanteService.cadastrarFabricante(fabricante)
        return ResponseEntity.ok("Fabricante cadastrado.")
    }

    @ApiOperation("Altera")
    @PutMapping("/{id}")
    fun altera(
        @PathVariable("id") id: Long,
        @RequestBody fabricante: Fabricante
    ): ResponseEntity<String> {
        return ResponseEntity.ok("Fabricante alterado.")
    }

    @ApiOperation("Delete")
    @DeleteMapping("/id")
    fun delete(@RequestBody id: Long): ResponseEntity<String> {
        return ResponseEntity.ok("Fabricante excluído")
    }

    @ApiOperation("Carregar todos")
    @GetMapping("/loadall")
    fun carregarTodos(): ResponseEntity<List<Fabricante>> {
        return ResponseEntity.ok(fabricanteService.loadAll().toList())
    }

}