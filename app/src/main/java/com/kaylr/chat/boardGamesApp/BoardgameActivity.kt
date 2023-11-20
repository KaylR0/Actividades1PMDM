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
        categoriesAdapter = CategoriesAdapter(categories){ position -> onCategorySelected(position) } //RECYCLER_CATEGORIES
        gamesAdapter = GamesAdapter(games) { position -> onGameSelected(position) }//RECYCLER_GAMES

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
                val currentCategory: GameCategory =
                    when(selectedRadioButton.text){
                    getString(R.string.dialog_cooperative_category) -> GameCategory.Cooperative //si su texto es el de la String indicada, le asigna la categoría correspondiente
                    getString(R.string.dialog_deckbuilding_category) -> GameCategory.Deckbuilding
                    getString(R.string.dialog_euro_category) -> GameCategory.Euro
                    getString(R.string.dialog_LCG_category) -> GameCategory.LCG
                    else -> GameCategory.Legacy
                }
                //a la lista (dataclass) games le añadimos un juego pasandole el nombre de "currentGame" y la categoria de "currentCategory"
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()

            }
        }
        dialog.show()
    }
    private fun updateGames(){

        val selectedCategories: List<GameCategory> = categories.filter { it.isSelected }
        val newGames = games.filter { selectedCategories.contains(it.category) }
        gamesAdapter.games = newGames

        //notificamos un cambio hecho a la lista (dataclass)games y gamesAdapter
        gamesAdapter.notifyDataSetChanged()
    }

    private fun onGameSelected(position:Int){
        games[position].isSelected = !games[position].isSelected
        updateGames()
    }
    private fun onCategorySelected(position:Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateGames()
    }

}