package com.lucas.viagensconstraint.extensions

fun Int.formataDias(): String{
    return when{
        this > 1 -> "$this dias"
        else -> "$this dia"
    }
}