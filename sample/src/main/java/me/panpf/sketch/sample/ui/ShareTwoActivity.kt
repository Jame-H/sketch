package me.panpf.sketch.sample.ui

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_share_element_test.*
import me.panpf.javaxkt.util.requireNotNull
import me.panpf.sketch.sample.R
import me.panpf.sketch.sample.base.BaseActivity
import me.panpf.sketch.sample.base.BindContentView
import me.panpf.sketch.state.MemoryCacheStateImage
import me.panpf.sketch.uri.UriModel
import me.panpf.sketch.util.SketchUtils

@BindContentView(R.layout.activity_share_element_test)
class ShareTwoActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        shareTestA_image.options.isCacheInMemoryDisabled = true
        val url = "http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1511/20/c12/15499807_1448016259039_mthumb.jpg"
        val imageCacheKey = intent.getStringExtra("image_cache_key")
        val uriModel = UriModel.match(this, url).requireNotNull()
//        shareTestA_image.isZoomEnabled = true
        val memoryCacheKey = SketchUtils.makeRequestKey(url, uriModel, imageCacheKey)
        shareTestA_image.options.loadingImage = MemoryCacheStateImage(memoryCacheKey, null)
        shareTestA_image.displayImage(url)
    }
}