package br.com.freezer.doc.model.report

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource

data class FabricanteItemReport(
    val id: Long,
    val marca: String,
    val anoFundacao: String,
    val modelos: JRBeanCollectionDataSource
)