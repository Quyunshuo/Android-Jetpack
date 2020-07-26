#Navigation 的主要元素

1.Navigation Graph
    这是一种新型的 XML 资源文件,其中包含应用程序所有的页面,以及页面间的关系
2.NavHostFragment
    这是一个特殊的 Fragment,可以认为它是其他 Fragment 的"容器",Navigation Graph 中的 Fragment 正是通过 NavHostFragment 进行展示的
3.NavController
    这是一个 Java/Kotlin 对象,用于在代码中完成 Navigation Graph 中具体的页面切换工作
    
#总结

当你想切换 Fragment 时,使用 NavController 对象,告诉它你想去的 Navigation Graph 中的哪个 Fragment,NavController 会将你想去的 Fragment 展示在 NavHostFragment 中

#注意
1.使用 navigate() 方法跳转其他 Fragment,再 navigateUp() 该 Fragment 出栈并返回上一个界面时,会重走上一个界面的 onCreateView() 和 onViewCreated() 生命周期方法
导致View和数据的初始化代码逻辑会重新执行,每次返回都会刷新页面,并且如果上一页面中初始化逻辑较多,可能会导致返回时有明显卡顿
原因: Navigation 跳转另一 Fragment 时,navigate() 方法源码中使用的是 replace() 方式,并不是 add() hide() show(),这也导致了 Fragment返回时是重新 Create 的