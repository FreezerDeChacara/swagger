package br.com.freezer.doc.model

import io.swagger.annotations.ApiModel
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("carro")
@ApiModel
class Carro(@Id val id: Long, val placa: String, val ano: Int)