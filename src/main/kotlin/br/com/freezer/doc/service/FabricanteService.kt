package br.com.freezer.doc.service

import br.com.freezer.doc.Repository.FabricanteRepository
import br.com.freezer.doc.model.Fabricante

class FabricanteService(val fabricanteRepository: FabricanteRepository) {

    fun cadastrarFabricante(fabricante: Fabricante) {
        fabricanteRepository.save(fabricante)
    }

    fun loadAll() =  fabricanteRepository.findAll()
}