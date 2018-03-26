package demo.marvellous.marvellous_kotlin.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import demo.marvellous.marvellous_kotlin.R
import demo.marvellous.marvellous_kotlin.core.model.Comic
import demo.marvellous.marvellous_kotlin.presenters.ComicsPresenter
import demo.marvellous.marvellous_kotlin.presenters.impl.ComicsPresenterImpl
import demo.marvellous.marvellous_kotlin.ui.adapters.ComicRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), ComicsPresenter.View {

    private lateinit var comicRecyclerViewAdapter : ComicRecyclerViewAdapter;
    private lateinit var comicPresenter : ComicsPresenter;
    private var mColumnCount = 2


    override fun showError(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onComicList(comicList: List<Comic>) {
        comicRecyclerViewAdapter.setData(comicList);
    }

    override fun onFavouriteButtonClicked(v: View?, comicItem: Comic) {
        Toast.makeText(this,"Toggle Favourite for " + comicItem.title, Toast.LENGTH_SHORT).show();
    }

    override fun onComicItemClicked(reference: String) {
        Toast.makeText(this,reference, Toast.LENGTH_SHORT).show();
    }

    override fun onNoComicsFound() {
        Toast.makeText(this,getString(R.string.msg_no_comics_found),Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        swipeRefreshLayout?.setRefreshing(true);
    }

    override fun hideProgress() {
        swipeRefreshLayout?.setRefreshing(false);
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        comicPresenter = ComicsPresenterImpl(this)

        comicRecyclerViewAdapter = ComicRecyclerViewAdapter(this,comicPresenter);

        listComics.adapter = comicRecyclerViewAdapter;

        swipeRefreshLayout?.setOnRefreshListener{
            comicPresenter.fetchAllComics();
        }


    }

    override fun onResume() {
        super.onResume()
        comicPresenter.resume()
        updateUI(listComics)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateUI(view : View){
        // Set the adapter
        if (view is RecyclerView) {
            mColumnCount = resources.getInteger(R.integer.columnCount)
            if (mColumnCount <= 1) {
                view.layoutManager = LinearLayoutManager(this)
            } else {
                view.layoutManager = GridLayoutManager(this, mColumnCount)
            }
        }
    }
}
