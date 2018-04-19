package br.com.freezer.doc.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("carro")
@ApiModel("Veículo automotor")
class Carro(
    @ApiModelProperty(
        value = "Identificador único do veículo",
        example = "1",
        required = true,
        allowEmptyValue = false,
        dataType = "Long",
        readOnly = false,
        name = "Id do veículo",
        allowableValues = "range[1, ${Long.MAX_VALUE}]"
    ) @Id val id: Long,
    @ApiModelProperty(
        value = "Placa do veículo",
        example = "DRG8771"
    ) val placa: String,
    @ApiModelProperty(
        example = "2005",
        required = true,
        allowEmptyValue = true,
        dataType = "Integer"
    ) val ano: Int
)