package com.newsapp.adapter

import android.app.ActionBar
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newsapp.R
import com.newsapp.domain.Article
import com.newsapp.utils.inflate
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.row_news.view.*



/**
 * The News adapter to show list of news.
 */
class NewsArticlesAdapter(
    private val listener: (Article) -> Unit
) : RecyclerView.Adapter<NewsArticlesAdapter.NewsHolder>() {

    /**
     * List of news articles
     */
    private var newsArticles: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsHolder(parent.inflate(R.layout.row_news))

    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) =
        newsHolder.bind(newsArticles[position], listener)

    override fun getItemCount() = newsArticles.size


    @GlideModule
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */



        fun bind(newsArticle: Article, listener: (Article) -> Unit) = with(itemView) {


            tvNewsItemTitle.text = newsArticle.title
            tvNewsAuthor.text = newsArticle.description
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)
            //tvListItemDateTime.text = newsArticle.publishedAt

            var url : String = newsArticle.imageHref
            if(!url.isNullOrBlank() && url.startsWith("http://")){
                url = url.replace("http://", "https://")
            }

            Glide.with(context).
                asBitmap()
                .load(url)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.img_test_one)
                        .error(R.drawable.img_test_one)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(ivNewsImage)
            setOnClickListener { listener(newsArticle) }
        }

    }

    /**
     * Swap with new data set and update the UI
     */
    fun replaceItems(items: List<Article>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}