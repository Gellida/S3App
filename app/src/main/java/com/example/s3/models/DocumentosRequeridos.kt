package com.example.s3.models

data class DocumentosRequeridos (
    val documentos: Array<String>
        ) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DocumentosRequeridos

        if (!documentos.contentEquals(other.documentos)) return false

        return true
    }

    override fun hashCode(): Int {
        return documentos.contentHashCode()
    }
}