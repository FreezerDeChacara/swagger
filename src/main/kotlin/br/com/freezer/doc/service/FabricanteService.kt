package br.com.freezer.doc.service

import br.com.freezer.doc.Repository.FabricanteRepository
import br.com.freezer.doc.model.Fabricante
import org.springframework.stereotype.Service

@Service
class FabricanteService(private val fabricanteRepository: FabricanteRepository) {

    fun cadastrarFabricante(fabricante: Fabricante) {
        fabricanteRepository.save(fabricante)
    }

    fun loadAll() =  fabricanteRepository.findAll()
}