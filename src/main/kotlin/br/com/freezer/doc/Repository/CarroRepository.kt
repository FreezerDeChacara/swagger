package br.com.freezer.doc.Repository

import br.com.freezer.doc.model.Carro
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CarroRepository: CrudRepository<Carro, String>