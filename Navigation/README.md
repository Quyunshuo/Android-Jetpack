#Navigation 的主要元素

1.Navigation Graph
    这是一种新型的 XML 资源文件,其中包含应用程序所有的页面,以及页面间的关系
2.NavHostFragment
    这是一个特殊的 Fragment,可以认为它是其他 Fragment 的"容器",Navigation Graph 中的 Fragment 正是通过 NavHostFragment 进行展示的
3.NavController
    这是一个 Java/Kotlin 对象,用于在代码中完成 Navigation Graph 中具体的页面切换工作
    
#总结

当你想切换 Fragment 时,使用 NavController 对象,告诉它你想去的 Navigation Graph 中的哪个 Fragment,NavController 会将你想去的 Fragment 展示在 NavHostFragment 中