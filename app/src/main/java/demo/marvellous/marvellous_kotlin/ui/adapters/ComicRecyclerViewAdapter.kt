package demo.marvellous.marvellous_kotlin.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import demo.marvellous.marvellous_kotlin.R
import demo.marvellous.marvellous_kotlin.core.model.Comic
import demo.marvellous.marvellous_kotlin.presenters.ComicsPresenter

/**
 * Created by leslied on 25/03/2018.
 */
class ComicRecyclerViewAdapter (private val context : Context,
                                private val comicPresenter : ComicsPresenter) :RecyclerView.Adapter<ComicRecyclerViewAdapter.ViewHolder>() {

    private var comicsList : List<Comic> = ArrayList<Comic>();
    fun setData(comicList : List<Comic>){
        this.comicsList = comicList;
        this.notifyDataSetChanged();
    }


    override fun getItemCount(): Int {
        return this.comicsList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val comic : Comic = this.comicsList.get(position);
        holder?.comicItem = comic;
        holder?.titleTextView?.setText(comic.title);

        Picasso.with(this.context).load(comic.thumbnail?.path + "." + comic.thumbnail?.extension).into(holder?.comicImageView);

        /**
         * On favourite Item clicked.
         */
        holder?.favouriteImageView?.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                comicPresenter.onFavouriteButtonClicked(v, comicsList.get(position));
            }
        })

        /**
         * On Item clicked.
         */
        holder?.comicContainer?.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                comicPresenter.onComicItemClicked(comicsList.get(position).resourceURI.toString());
            }
        })

        if(comic.prices?.size == 0) {
            holder?.priceTextView?.visibility = View.GONE;
        } else {
            holder?.priceTextView?.visibility = View.VISIBLE;
            holder?.priceTextView?.setText(comic.prices?.get(0)?.price);
        }

        if(comic.issueNumber.isNullOrEmpty()) {
            holder?.issueTextView?.setText(String.format(context.getString(R.string.issue_fmt), 0));
        } else {
            holder?.issueTextView?.setText(String.format(context.getString(R.string.issue_fmt), comic.issueNumber));
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.card_comic, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder( val mView: View): RecyclerView.ViewHolder(mView) {
        val comicContainer : View
        val titleTextView : TextView
        val issueTextView : TextView
        val priceTextView : TextView
        val comicImageView : ImageView
        val favouriteImageView : ImageView
        val seriesImageView : ImageView
        val availableImageView : ImageView

        var comicItem:Comic? = null

        init{
            comicContainer = mView.findViewById(R.id.comicContainer);
            titleTextView = mView.findViewById<TextView>(R.id.comicTitle) as TextView
            issueTextView = mView.findViewById<TextView>(R.id.comicIssue) as TextView
            priceTextView = mView.findViewById<TextView>(R.id.comicPrintPrice) as TextView
            favouriteImageView = mView.findViewById(R.id.btnFavourite)
            seriesImageView = mView.findViewById(R.id.btnSeries)
            availableImageView = mView.findViewById(R.id.btnAvailable)
            comicImageView = mView.findViewById<ImageView>(R.id.comicCover) as ImageView
        }

        public override fun toString():String {
            return super.toString() + " '" + titleTextView.text + "'"
        }
    }


}