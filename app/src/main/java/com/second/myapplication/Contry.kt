package com.second.myapplication

data class Contry(
    val name: String,
    val capital: String,
    val population: Long,
    val area: Long,
    val languages: List<Languages>,
    val flag: String
) {

}

data class Languages(
    val name: String
)