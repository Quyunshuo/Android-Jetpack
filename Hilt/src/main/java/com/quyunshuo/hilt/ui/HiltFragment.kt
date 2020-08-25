package com.quyunshuo.hilt.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.quyunshuo.hilt.R
import com.quyunshuo.hilt.testclass.GitHubService
import com.quyunshuo.hilt.testclass.HiltSimple
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HiltFragment : Fragment() {

    @Inject
    lateinit var mHiltSimple: HiltSimple

    @Inject
    lateinit var mGitHubService: GitHubService

    private val mMainScope by lazy { MainScope() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hilt_fragment_layout, container, false)
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHiltSimple.doSomething()
        mMainScope.launch {
            flow {
                emit(mGitHubService.getGitHubUserInfo("Quyunshuo"))
            }.catch {
                Log.d("qqq", "onViewCreated: ${Log.getStackTraceString(it)}")
            }.collectLatest {
                Log.d("qqq", "onViewCreated: $it")
            }
        }
    }
}