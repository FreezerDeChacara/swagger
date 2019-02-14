package br.com.freezer.doc.model

import io.swagger.annotations.ApiModelProperty

data class Modelo(
    @ApiModelProperty(
        example = "350Z"
    )
    val nome: String
)