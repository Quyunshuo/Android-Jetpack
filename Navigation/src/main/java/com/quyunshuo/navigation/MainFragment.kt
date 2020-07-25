package com.quyunshuo.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import com.quyunshuo.navigation.databinding.ActivityMainBinding
import com.quyunshuo.navigation.databinding.FragmentMainBinding

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/25
 * @Class: MainFragment
 * @Remark:
 */
class MainFragment : Fragment() {

    private val mBinding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        val bundle = SecondFragmentArgs.Builder()
            .setUserName("Quyunshuo")
            .setAge(22)
            .build()
            .toBundle()

        mBinding.mToSecondFragmentBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_mainFragment_to_secondFragment,
                bundle
            )
        )
    }
}