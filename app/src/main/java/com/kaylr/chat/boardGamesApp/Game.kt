package com.kaylr.chat.boardGamesApp

data class Game (val name:String, val category: GameCategory, var isSelected:Boolean = false)