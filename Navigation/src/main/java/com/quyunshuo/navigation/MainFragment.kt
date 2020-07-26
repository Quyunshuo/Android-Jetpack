package com.quyunshuo.navigation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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
        mBinding.mToSecondFragmentBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_mainFragment_to_secondFragment,
                SecondFragmentArgs.Builder()
                    .setUserName("Quyunshuo")
                    .setAge(22)
                    .build()
                    .toBundle()
            )
        )
        mBinding.mSendNotificationBtn.setOnClickListener { sendNotification() }
    }

    /**
     * 发送一条通知 通过点击通知进行深层链接跳转行
     */
    private fun sendNotification() {
        activity?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel =
                    NotificationChannel("1", "ChannelName", IMPORTANCE_DEFAULT)
                notificationChannel.description = "description"
                val notificationManager = it.getSystemService(NotificationManager::class.java)
                notificationManager.createNotificationChannel(notificationChannel)
            }
            val notificationCompat = NotificationCompat.Builder(it,"1")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("DeepLinkDemo")
                .setContentText("Hello DeepLink!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(getPendingIntent()) // 设置PendingIntent
                .setAutoCancel(true)
                .build()
            val notificationManagerCompat = NotificationManagerCompat.from(it)
            notificationManagerCompat.notify(8, notificationCompat)
        }
    }

    /**
     * 通过 PendingIntent 设置当通知被单击时需要跳转的 destination 以及传递的参数
     */
    private fun getPendingIntent(): PendingIntent? {
        return activity?.let {
            val bundle = Bundle()
            bundle.putString("params", "测试")
            Navigation.findNavController(it, R.id.mSendNotificationBtn)
                .createDeepLink()
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.secondFragment)
                .setArguments(bundle)
                .createPendingIntent()
        }
    }
}