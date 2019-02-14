package br.com.freezer.doc.service

import br.com.freezer.doc.Repository.FabricanteRepository
import br.com.freezer.doc.model.Fabricante
import br.com.freezer.doc.service.report.FabricanteReportService
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletResponse


@Service
class FabricanteService(
    private val fabricanteRepository: FabricanteRepository,
    private val fabricanteReportService: FabricanteReportService
) {

    fun cadastrarFabricante(fabricante: Fabricante) {
        fabricanteRepository.save(fabricante)
    }

    fun loadAll() = fabricanteRepository.findAll()

    fun gerarPDF(response: HttpServletResponse) {
        fabricanteReportService.gerarPDF(fabricanteRepository.findAll().toList(), response)
    }

    fun atualizarFabricante(fabricante: Fabricante) {
        fabricanteRepository.save(fabricante)
    }

}