package com.erselankhan.jetpackcomposeutils.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

fun urlToBitmap(
    scope: CoroutineScope,
    imageURL: String,
    context: Context,
    onSuccess: (bitmap: Bitmap) -> Unit,
    onError: (error: Throwable) -> Unit
) {
    var bitmap: Bitmap? = null
    val loadBitmap = scope.launch(Dispatchers.IO) {
        val loader = ImageLoader(context)
        val request = ImageRequest.Builder(context)
            .data(imageURL)
            .allowHardware(false)
            .build()
        val result = loader.execute(request)
        if (result is SuccessResult) {
            bitmap = (result.drawable as BitmapDrawable).bitmap
        } else if (result is ErrorResult) {
            cancel(result.throwable.localizedMessage ?: "ErrorResult", result.throwable)
        }
    }
    loadBitmap.invokeOnCompletion { throwable ->
        bitmap?.let {
            onSuccess(it)
        } ?: throwable?.let {
            onError(it)
        } ?: onError(Throwable("Undefined Error"))
    }
}