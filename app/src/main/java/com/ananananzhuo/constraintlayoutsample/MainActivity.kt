package com.ananananzhuo.constraintlayoutsample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintProperties
import com.ananananzhuo.mvvm.activity.CustomAdapterActivity
import com.ananananzhuo.mvvm.bean.bean.ItemData
import com.ananananzhuo.mvvm.callback.CallData
import com.ananananzhuo.mvvm.callback.Callback

class MainActivity : CustomAdapterActivity() {
    private val layouts = mutableListOf(
        LayoutItem(R.layout.layout_baseline, "基线对齐"),
        LayoutItem(R.layout.layout_cycle, "角度约束"),
        LayoutItem(R.layout.layout_bias, "百分百偏移"),
        LayoutItem(R.layout.layout_gonemargin,"gone margin隐藏时的边距"),
        LayoutItem(R.layout.layout_widget_size,"设置控件尺寸spread撑满水平剩余宽度",desc = "本例中设置撑满水平剩余宽度,竖直高度和ImageView高度一致，必须设置控件左右的约束都是父控件,并且宽度为0才行，如果只设置左约束，是不能撑满屏幕宽度的"),
        LayoutItem(R.layout.layout_percent_width,"控件百分百宽度","使用layout_constraintWidth_percent属性，设置控件宽度是屏幕宽度的50%。注意控件宽度必须为0dp，同时设置左右两个约束"),
        LayoutItem(R.layout.layout_ratio_size,"根据宽高比设置控件尺寸",desc = "设置宽高比为1:2，需要注意的点，我没设置了宽度是200dp，高度必须是0dp才能生效"),
        LayoutItem(R.layout.layout_chain,"将多个控件链式布局",desc = "类似于compose的spackBetween、spaceAround等效果，还可以设置各个控件根据屏幕宽度根据比例设置每个控件的宽度"),
        LayoutItem(R.layout.layout_guideline,"GuideLine辅助线的使用",desc = "辅助线是不可见的，可以用来约束控件，和普通控件使用相同"),
        LayoutItem(R.layout.layout_group,"控件分组后同步显示或隐藏",desc = "通过对group中的控件进行设置显示隐藏可以对group中的一组控件可以同步显示和隐藏，使用constraint_referenced_ids对控件进行分组(本例需要手动更改group中控件的visiblity来设置展示和隐藏)"),
        LayoutItem(0,"placeholder使用,点击图标展示效果",clz = PlaceHolderActivity::class.java),
        LayoutItem(R.layout.layout_flow_wrapmode,"flow_wrapMode实现链约束",desc = "flow_wrapMode有三个选择none、aligned、chain\n\n" +
                "1、none链上的布局水平或竖直排列，超出屏幕部分不展示\n" +
                "2、aligned多行布局item对齐展示，就像方格本一样\n" +
                "3、chain布局水平排列，超出一行的单行换行显示,数量不能撑满屏幕的默认水平均分屏幕展示\n\n" +
                "本例中代码可以通过更改xml中flow_wrapmode来查看三种属性的效果"),
        LayoutItem(R.layout.layout_flow_wrapmode1,"flow_wrapMode链约束中对每一行、第一行、最后一行设置链约束(不过目前测试的几个属性效果很不好)"),
        LayoutItem(R.layout.layout_flow_wrapmode_alignlimit,"流式布局中的对齐约束flow_verticalAlign、flow_horizontalAlign","本例中设置flow_verticalAlign=top顶部对齐\n" +
                "其它对齐方式还有top、bottom、center、baseline"),
        LayoutItem(R.layout.layout_flow_wrapmode_numlimit,"流式布局中的数量约束flow_maxElementsWrap",desc = "flow_maxElementsWrap用来限制单行中的最大数量，本例中我没设置为3"),
        LayoutItem(R.layout.layout_layer,"使用Layer图层设置多个控件的组合背景"),
        LayoutItem(R.layout.layout_imagefilterview,"图片处理器ImageFilterView",desc = "1、roundPercent属性可以设置百分百圆角，1的话直接变成圆形，小于1是圆角\n" +
                "2、altSrc和crossfade搭配使用可以实现滤镜效果\n"),
        LayoutItem(R.layout.layout_mockview,"画出类似原型图的控件"),
        LayoutItem(R.layout.layout_barrier,"屏障（将屏障两侧的view分隔开布局）",desc = "本例中右边的文字部分宽度必须是0dp")

    )

    override fun getAdapterDatas(): MutableList<ItemData> = layouts.map { layoutItem ->
        ItemData(title = layoutItem.title, callback = object : Callback {
            override fun callback(callData: CallData) {
                val intent = if (layoutItem.clz != null){
                    Intent(this@MainActivity,layoutItem.clz)
                }else{
                    Intent(this@MainActivity, ShowLayoutActivity::class.java).apply {
                        putExtra("layoutId", layoutItem.layoutId)
                        putExtra("title", layoutItem.title)
                        putExtra("desc",layoutItem.desc)
                    }
                }
                startActivity(intent)
            }
        })
    }.toMutableList()

    override fun showFirstItem(): Boolean = false
}

data class  LayoutItem<T:Activity>(val layoutId: Int, val title: String,val desc:String="",val clz :Class<T>? = null)