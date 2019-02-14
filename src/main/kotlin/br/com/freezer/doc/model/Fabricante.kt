package br.com.freezer.doc.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("fabricante")
@ApiModel
data class Fabricante(
    @ApiModelProperty(
        example = "1",
        position = 1
    ) @Id val id: Long,
    @ApiModelProperty(
        example = "Nissan",
        position = 2
    ) val marca: String,
    @ApiModelProperty(
        example = "1981",
        position = 3
    ) val anoFundacao: String,
    @ApiModelProperty(
        example = "[{\"nome\":\"Skyline\"},{\"nome\":\"GTR\"},{\"nome\":\"350Z\"}]",
        position = 4
    ) val modelos: List<Modelo>
)