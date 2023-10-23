package com.kaylr.chat.boardGamesApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kaylr.chat.R


class BoardgameActivity : AppCompatActivity() {
    private lateinit var rvCategories: RecyclerView //RECYCLER_CATEGORIES
    private lateinit var rvGames: RecyclerView //RECYCLER_GAMES
    private lateinit var categoriesAdapter: CategoriesAdapter //RECYCLER_CATEGORIES
    private lateinit var gamesAdapter: GamesAdapter //RECYCLER_GAMES

    private lateinit var fabAddGame: FloatingActionButton

    private val categories = listOf( //RECYCLER_CATEGORIES
        GameCategory.Cooperative,
        GameCategory.Deckbuilding,
        GameCategory.Euro,
        GameCategory.LCG,
        GameCategory.Legacy
    )
    private val games = mutableListOf( //RECYCLER_GAMES
        Game("DeckBuilding Game", GameCategory.Deckbuilding),
        Game("Coop Game", GameCategory.Cooperative),
        Game("Euro Game",GameCategory.Euro),
        Game("LCG Game",GameCategory.LCG),
        Game("Legacy Game",GameCategory.Legacy)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardgame)
        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }
    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories) //RECYCLER_CATEGORIES
        gamesAdapter = GamesAdapter(games) //RECYCLER_GAMES

        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) //RECYCLER_CATEGORIES

        rvGames.layoutManager = LinearLayoutManager(this) //RECYCLER_GAMES

        rvCategories.adapter = categoriesAdapter //RECYCLER_CATEGORIES

        rvGames.adapter = gamesAdapter //RECYCLER_GAMES
    }
    private fun initListeners() { fabAddGame.setOnClickListener{ showDialog() }
    }
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val btnAddGame: Button = dialog.findViewById(R.id.btnAddGame)
        val etGame: EditText = dialog.findViewById(R.id.etGame)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)
        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if(currentGame.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when(selectedRadioButton.text){
                    getString(R.string.dialog_cooperative_category) -> GameCategory.Cooperative
                    getString(R.string.dialog_deckbuilding_category) -> GameCategory.Deckbuilding
                    getString(R.string.dialog_euro_category) -> GameCategory.Euro
                    getString(R.string.dialog_LCG_category) -> GameCategory.LCG
                    else -> GameCategory.Legacy
                }
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()

            }
        }
        dialog.show()
    }
    private fun updateGames(){
        gamesAdapter.notifyDataSetChanged()
    }







}