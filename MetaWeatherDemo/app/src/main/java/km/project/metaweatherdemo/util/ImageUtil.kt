package km.project.metaweatherdemo.util

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import km.project.metaweatherdemo.GlideApp
import km.project.metaweatherdemo.R
import java.io.File
import java.util.*

/**
 * 웹 이미지 표시
 */
object ImageUtil {
    /**
     * 기본 Glide Option 가져오기
     */
    private val defaultRequestOptions: RequestOptions
        get() = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)

    fun loadImage(context: Context, url: String?, imageView: ImageView, isAnimation: Boolean = true, isUsingPlaceHolder: Boolean = true) {
        if (url == null || url.isEmpty())
            return

        try {
            GlideApp.with(context).load(url)
                .apply(defaultRequestOptions)
                .apply {
                    if (isUsingPlaceHolder)
                        placeholder(R.drawable.bg_empty)

                    if (isAnimation)
                        transition(DrawableTransitionOptions.withCrossFade())
                    else
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadRoundedImage(context: Context, url: String?, imageView: ImageView, isAnimation: Boolean = true) {
        if (url == null || url.isEmpty())
            return

        try {
            GlideApp.with(context).load(url)
                .apply(defaultRequestOptions.apply {
                    transform(CenterCrop(), RoundedCorners(Util.instance.dpToPixel(context, 4f).toInt()))
                })
                .placeholder(R.drawable.bg_empty_rounded)
                .error(R.drawable.bg_empty_rounded)
                .apply {
                    if (isAnimation)
                        transition(DrawableTransitionOptions.withCrossFade())
                    else
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadLeftRoundedImage(context: Context, url: String?, imageView: ImageView, isAnimation: Boolean = true) {
        if (url == null || url.isEmpty())
            return

        try {
            GlideApp.with(context).load(url)
                .apply(defaultRequestOptions.apply {
                    transform(CenterCrop(), RoundedCornersTransformation(Util.instance.dpToPixel(context, 3f).toInt(), 0, RoundedCornersTransformation.CornerType.LEFT))
                })
                .placeholder(R.drawable.bg_empty_rounded)
                .error(R.drawable.bg_empty_rounded)
                .apply {
                    if (isAnimation)
                        transition(DrawableTransitionOptions.withCrossFade())
                    else
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadRoundedImage(context: Context, file: File?, imageView: ImageView, isAnimation: Boolean = true) {
        try {
            GlideApp.with(context).load(file)
                .apply(defaultRequestOptions.apply {
                    transform(CenterCrop(), RoundedCorners(Util.instance.dpToPixel(context, 4f).toInt()))
                })
                .placeholder(R.drawable.bg_empty_rounded)
                .error(R.drawable.bg_empty_rounded)
                .apply {
                    if (isAnimation)
                        transition(DrawableTransitionOptions.withCrossFade())
                    else
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadImage(context: Context, url: String?, imageView: ImageView, placeholderRid: Int, isAnimation: Boolean = true) {
        if (url == null || url.isEmpty()) {
            imageView.setImageResource(placeholderRid)
            return
        }

        try {
            GlideApp.with(context).load(url)
                .apply(defaultRequestOptions)
                .placeholder(placeholderRid)
                .apply {
                    if (!isAnimation)
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadImage(context: Context, file: File?, imageView: ImageView, isAnimation: Boolean = true) {
        if (file == null)
            return

        try {
            GlideApp.with(context).load(file)
                .apply(defaultRequestOptions)
                .apply {
                    if (!isAnimation)
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadImage(context: Context, uri: Uri?, imageView: ImageView, isAnimation: Boolean = true) {
        if (uri == null)
            return

        try {
            GlideApp.with(context).load(uri)
                .apply(defaultRequestOptions)
                .apply {
                    if (!isAnimation)
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 원형 이미지 가져오기
     */
    fun loadCircleImage(context: Context, uri: String, imageView: ImageView) {
        try {
            GlideApp.with(context).load(uri)
                .apply(defaultRequestOptions.circleCrop())
                .dontAnimate()
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadProfileImage(context: Context, url: String?, imageView: ImageView, isAnimation: Boolean = true) {
        if (url == null || url.isEmpty())
            return

        try {
            GlideApp.with(context).load(url)
                .apply(defaultRequestOptions)
                .apply {
                    if (!isAnimation)
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadImageWithError(context: Context, url: String?, imageView: ImageView, errorRid: Int, isAnimation: Boolean = true) {
        if (url == null || url.isEmpty())
            return

        try {
            GlideApp.with(context).load(url)
                .apply(defaultRequestOptions)
                .error(errorRid)
                .apply {
                    if (!isAnimation)
                        dontAnimate()
                }
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadSellerLogo(context: Context, url: String, imageView: ImageView) {
        try {
            GlideApp.with(context)
                .load(url)
                .fitCenter()
                .override(imageView.height)
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadBlurImage(context: Context, url: String?, imageView: ImageView) {
        if (url == null || url.isEmpty())
            return

        try {
            GlideApp.with(context).load(url)
                .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
                .placeholder(R.drawable.bg_empty)
                .transition(DrawableTransitionOptions.withCrossFade())
                .transform(BlurTransformation(45, 4))
                .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun resourceToUriString(context: Context, resourceID: Int): String {
        val resources = context.resources
        return ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(resourceID) + '/'.toString() + resources.getResourceTypeName(resourceID) + '/'.toString() + resources.getResourceEntryName(resourceID)
    }

    /**
     * 상품 카드 이미지
     */
    fun resizedCardImage(imageUrl: String): String {
        try {
            return Uri.parse(imageUrl).buildUpon()
                .clearQuery()
                .appendQueryParameter("s", "640x420")
                .appendQueryParameter("t", "outside")
                .appendQueryParameter("f", "jpg")
                .build()
                .toString()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return imageUrl
    }

    /**
     * 지역 상세 상단 이미지 / 배너 이미지
     */
    fun resizedWideImage(imageUrl: String): String {
        try {
            return Uri.parse(imageUrl).buildUpon()
                .clearQuery()
                .appendQueryParameter("s", "1024x1024")
                .appendQueryParameter("t", "inside")
                .appendQueryParameter("f", "jpg")
                .build()
                .toString()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return imageUrl
    }

    /**
     * 베스트 셀러 배경 블러 이미지
     */
    fun resizedBlurImage(imageUrl: String): String {
        try {
            return Uri.parse(imageUrl).buildUpon()
                .clearQuery()
                .appendQueryParameter("s", "320x320")
                .appendQueryParameter("t", "inside")
                .appendQueryParameter("f", "jpg")
                .build()
                .toString()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return imageUrl
    }

    /**
     * 이미지의 MimeType 을 가져온다.
     */
    fun getMimeType(activity: Activity, imagePath: String): String {
        val uri = Uri.fromFile(File(imagePath))

        return if (uri.scheme == ContentResolver.SCHEME_CONTENT) {
            activity.contentResolver.getType(uri)
        } else {
            val fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri.toString())
            MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension.toLowerCase(Locale.getDefault()))
        } ?: ""
    }
}
