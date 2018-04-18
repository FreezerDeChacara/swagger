package br.com.freezer.doc.Repository

import br.com.freezer.doc.model.Fabricante
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FabricanteRepository : CrudRepository<Fabricante, String>