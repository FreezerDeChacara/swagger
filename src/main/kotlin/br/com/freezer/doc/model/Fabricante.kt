package br.com.freezer.doc.model

import io.swagger.annotations.ApiModel
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("fabricante")
@ApiModel
class Fabricante(@Id val id: Long, val marca: String)