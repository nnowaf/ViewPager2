package com.nanyo.belajarlagi14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.nanyo.belajarlagi14.fragment.ProfilFragment
import com.nanyo.belajarlagi14.fragment.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show.*

class MainActivity : AppCompatActivity() {
    private val list: ArrayList<ViewUnsplash> = ArrayList()
    private val profilFragment = ProfilFragment()
    private val settingFragment = SettingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bnvMain.setOnItemSelectedListener {
            val id = it.itemId
            when (id) {
                R.id.miHome -> {
                    prepareData()
                    prepareViewPager()
                }

                R.id.miPerson -> {
                    setCurrentFragment(profilFragment)
                }

                R.id.miSetting -> {
                    setCurrentFragment(settingFragment)
                }
            }

            true
        }

    }
    private fun addData(
        viewsUnsplash: String,
        downloadsUnplash: String,
        featuredUnsplash: String,
        imgUnsplash: String
    ) {
        list.add(ViewUnsplash(viewsUnsplash, downloadsUnplash, featuredUnsplash, imgUnsplash))
    }
    private fun prepareData() {
        addData("24801", "118", "People", "https://bit.ly/3EltgcQ")
        addData("2203", "72", "People", "https://bit.ly/3z6SFDm")
        addData("11826", "101", "People", "https://bit.ly/3En8k5w")
        addData("16439", "137", "People", "https://bit.ly/3AcmGTK")
        addData("1275412", "13688", "Fashion", "https://bit.ly/3zcbWTY")
        addData("5428880", "26375", "Editorial, Wallpapers, Nature", "https://bit.ly/3hz0OKG")
        addData("81462", "412", "Nature", "https://bit.ly/3AgdtcV")
        addData("12758", "93", "Food & Drink", "https://bit.ly/3lpCI6z")
    }

    private fun prepareViewPager() {
        viewPagerMain.adapter = ViewAdapterUnsplash(list)
        viewPagerMain.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPagerMain.beginFakeDrag()
        viewPagerMain.fakeDragBy(-10f)
    }

    private fun setCurrentFragment(fm: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fm)
            commit()
        }
    }


}