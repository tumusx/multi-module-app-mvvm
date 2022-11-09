package com.github.tumusx.shared

object ValidateSearch {
    var error = ""
    fun onMaxLengthQuery(query: String): String {
        if (query.count() > 20) {
            error = "Não foi possível buscar. É necessário digitar até 20 letras."
            return error
        }

        if (query.isEmpty()) {
            error = "Não foi possível buscar. É necessário digitar"
            return error
        }

        if (query.lowercase().contains("+18") || query.lowercase()
                .contains("porno") || query.lowercase().contains("sex")
        ) {
            error = "Ops... Esse tipo de pesquisa não é permitido aqui!"
            return error
        }

        return ""
    }
}