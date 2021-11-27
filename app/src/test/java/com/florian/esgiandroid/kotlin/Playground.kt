package com.florian.esgiandroid.kotlin

fun main() {
    println(listOf(1, 2, 3, 4, 5).fold(0) { total, item -> total + item })
    println(listOf(1, 2, 3, 4, 5).foldRight(0) { item, total -> total + item })
    println(listOf(1, 2, 3, 4, 5).fold(1) { mul, item -> mul * item })
    println(listOf(1, 2, 3, 4, 5).foldRight(1) { item, mul -> mul * item })
    println(listOf(0, 1, 2, 3, 4, 5)
        .foldIndexed(0) { index, total, item -> if (index % 2 == 0) (total + item) else total })
    println(listOf(0, 1, 2, 3, 4, 5)
        .foldRightIndexed(0) { index, item, total -> if (index % 2 == 0) (total + item) else total })
}