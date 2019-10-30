package me.panpf.sketch.sample.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import kotlinx.android.synthetic.main.fragment_share_element_test.*
import me.panpf.sketch.sample.R
import me.panpf.sketch.sample.base.BaseFragment
import me.panpf.sketch.sample.base.BindContentView

@BindContentView(R.layout.fragment_share_element_test)
class ShareElementTestFragment : BaseFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shareTestF_image.options.isCacheInMemoryDisabled = true
        shareTestF_image.displayImage("http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1511/20/c12/15499807_1448016259039_mthumb.jpg")

        shareTestF_image.setOnClickListener {
            val transitionBundle = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), shareTestF_image as View, getString(R.string.share_sample)).toBundle()
            startActivity(Intent(context, ShareTwoActivity::class.java).apply {
                putExtra("image_cache_key", shareTestF_image.optionsKey)
            }, transitionBundle)
        }
    }
}