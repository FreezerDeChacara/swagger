package br.com.freezer.doc.model.report

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource

data class FabricanteReport(
    val cliente: String,
    val fabricantes: JRBeanCollectionDataSource
)