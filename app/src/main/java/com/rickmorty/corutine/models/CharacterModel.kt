package com.rickmorty.corutine.models

import java.io.Serializable

data class CharacterModel(
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val image: String?
): Serializable