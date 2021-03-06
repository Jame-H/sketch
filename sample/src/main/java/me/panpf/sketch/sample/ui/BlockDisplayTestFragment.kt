package me.panpf.sketch.sample.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_pager_tab.*
import me.panpf.adapter.pager.FragmentArrayPagerAdapter
import me.panpf.sketch.sample.AssetImage
import me.panpf.sketch.sample.R
import me.panpf.sketch.sample.base.BaseFragment
import me.panpf.sketch.sample.base.BindContentView
import me.panpf.sketch.sample.bean.Image
import me.panpf.sketch.sample.item.TitleTabFactory

/**
 * 大图页面，用来展示Sketch显示大图的能力
 */
@BindContentView(R.layout.fragment_pager_tab)
class BlockDisplayTestFragment : BaseFragment() {

    private var fragmentAdapter: FragmentArrayPagerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity ?: return

        if (fragmentAdapter == null) {
            val hugeAssetImageNames = AssetImage.HUGE_IMAGES
            val fragments = arrayOfNulls<androidx.fragment.app.Fragment>(hugeAssetImageNames.size)
            for (w in hugeAssetImageNames.indices) {
                val url = hugeAssetImageNames[w]
                fragments[w] = ImageFragment.build(Image(url, url), null, true)
            }
            fragmentAdapter = FragmentArrayPagerAdapter(childFragmentManager, fragments)
        }
        pager_pagerTabFragment_content.adapter = fragmentAdapter

        tab_pagerTabFragment_tabs.setTabViewFactory(TitleTabFactory(arrayOf("WORLD", "QMSHT", "CWB", "CARD"), activity))
        tab_pagerTabFragment_tabs.setViewPager(pager_pagerTabFragment_content)
    }
}
