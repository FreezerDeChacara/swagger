package br.com.freezer.doc.service

import br.com.freezer.doc.Repository.CarroRepository
import br.com.freezer.doc.model.Carro
import org.springframework.stereotype.Service

@Service
class CarroService(private val carroRepository: CarroRepository) {

    fun cadastrarCarro(carro: Carro) {
        carroRepository.save(carro)
    }

    fun loadAll() =  carroRepository.findAll()
}