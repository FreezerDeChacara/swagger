package br.com.freezer.doc.service.report

import br.com.freezer.doc.model.Fabricante
import br.com.freezer.doc.model.report.FabricanteReport
import br.com.freezer.doc.model.report.FabricanteItemReport
import net.sf.jasperreports.engine.JasperCompileManager
import net.sf.jasperreports.engine.JasperExportManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import javax.servlet.http.HttpServletResponse

@Service
class FabricanteReportService(private val resourceLoader: ResourceLoader) {

    private fun getDataSource(lista: List<Fabricante>) = JRBeanCollectionDataSource(

        lista.map { registro ->
            FabricanteItemReport(
                id = registro.id,
                marca = registro.marca,
                anoFundacao = registro.anoFundacao,
                modelos = JRBeanCollectionDataSource(registro.modelos.map { it })
            )
        }
    )

    private fun getPathTemplateFile(template: String) = resourceLoader.getResource("classpath:$template").uri.path

    fun gerarPDF(lista: List<Fabricante>, response: HttpServletResponse) {
        val jasperReport = JasperCompileManager.compileReport(getPathTemplateFile(FABRICANTE_JRXML))

        val dataSource = JRBeanCollectionDataSource(listOf(
            FabricanteReport(
                "Anta",
                getDataSource(lista)
            )
        ))

        val jasperPrint = JasperFillManager.fillReport(
            jasperReport,
            mapOf(
                "titulo" to "Título do relatório do bdv",
                "cliente" to "Testador",
                "data" to OffsetDateTime.now()
            ), // esses são parâmetros que podem ser utilizados dentro do relatório
            dataSource // esse é a fabricantes com os dados pra montar o relatório
        )

        val outputStream = response.outputStream
        response.contentType = "application/pdf";
        response.setHeader("Content-Disposition", "attachment; filename=\"relatorio.pdf\"")

        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream)

        outputStream.flush()
        outputStream.close()
    }

    companion object {
        private const val FABRICANTE_JRXML = "Simple_Blue.jrxml"
    }


}