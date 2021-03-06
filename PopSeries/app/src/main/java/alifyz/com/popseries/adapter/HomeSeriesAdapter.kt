package alifyz.com.popseries.adapter

import alifyz.com.popseries.R
import alifyz.com.popseries.model.SeriesModel
import alifyz.com.popseries.ui.DetailsActivity
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.util.Pair
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.GsonBuilder

class HomeSeriesAdapter(val context: Context, val dataSet: SeriesModel) : RecyclerView.Adapter<HomeSeriesAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val poster = view.findViewById<ImageView>(R.id.poster)
        val card = view.findViewById<CardView>(R.id.cardview)
                .setOnClickListener(this)
        val scrim = view.findViewById<View>(R.id.scrim)
        val title = view.findViewById<TextView>(R.id.series_title)

        override fun onClick(v: View?) {
            val seriesDetail = dataSet.results?.get(adapterPosition)
            val builder = GsonBuilder()
            val gson = builder.create()

            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("data", gson.toJson(seriesDetail))

            val coverImageAnimationSettings = Pair.create(poster as View, "cover_image")
            val coverScrimAnimationSettings = Pair.create(scrim as View, "cover_image")
            val coverTitleAnimationSettings = Pair.create(title as View, "cover_title")

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    context as Activity, coverImageAnimationSettings, coverScrimAnimationSettings, coverTitleAnimationSettings)

            startActivity(context, intent, options.toBundle())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_series, parent, false))
    }

    override fun getItemCount(): Int {
       return dataSet.results!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentShow = dataSet.results?.get(position)
        holder.title.text = currentShow?.name
        val posterUrl = context
                .getString(R.string.base_url_path)
                .plus(currentShow?.posterPath)

        Glide
                .with(context)
                .load(posterUrl)
                .into(holder.poster)

    }
}

