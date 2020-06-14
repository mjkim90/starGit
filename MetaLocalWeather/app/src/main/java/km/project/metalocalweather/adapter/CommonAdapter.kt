package km.project.metalocalweather.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import km.project.metalocalweather.GlideApp
import km.project.metalocalweather.R

@BindingAdapter("imgUrl")
fun setImageUrl(view: ImageView, url: String?) {
    url?.let {
        GlideApp.with(view.context.applicationContext)
                .load(url)
                .fitCenter()
                .error(R.drawable.error_placeholder)
                .into(view)
    }
}