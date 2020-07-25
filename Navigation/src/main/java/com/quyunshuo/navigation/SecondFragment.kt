package com.quyunshuo.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quyunshuo.navigation.databinding.FragmentSecondBinding

/**
 * @Author: QuYunShuo
 * @Time: 2020/7/25
 * @Class: SecondFragment
 * @Remark:
 */
class SecondFragment : Fragment() {

    private val mBinding by lazy { FragmentSecondBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val userName = MainFragmentArgs.fromBundle(it).userName
            val age = MainFragmentArgs.fromBundle(it).age
            Log.d("qqq", "onViewCreated: $userName $age")
        }
    }
}