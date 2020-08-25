Hilt常用注解

1.@HiltAndroidApp
 |--1. 所有使用 Hilt 的 App 必须包含一个使用 @HiltAndroidApp 注解的 Application
 |--2. @HiltAndroidApp 注解将会触发 Hilt 代码的生成，作为应用程序依赖项容器的基类
 |--3. 生成的 Hilt 组件依附于 Application 的生命周期，它也是 App 的父组件，提供其他组件访问的依赖
 |--4. 在 Application 中设置好 @HiltAndroidApp 之后，就可以使用 Hilt 提供的组件了，组件包含Application、Activity、Fragment、View、Service、BroadcastReceiver 等等
 
2.@AndroidEntryPoint
 |--1. Hilt 提供的 @AndroidEntryPoint 注解用于提供 Android 类的依赖（Activity、Fragment、View、Service、BroadcastReceiver）特殊的 Application 使用 @HiltAndroidApp 注解
 |--2. Activity：仅仅支持 ComponentActivity 的子类例如 FragmentActivity、AppCompatActivity 等等
 |--3. Fragment：仅仅支持继承 androidx.Fragment 的 Fragment
 |--4. View
 |--5. Service
 |--6. BroadcastReceiver
 |--Note: 
 |   |--1. 如果使用 @AndroidEntryPoint 在非 ComponentActivity 子类上注解，例如 Activity 则会抛出以下异常: 
 |   |     Activities annotated with @AndroidEntryPoint must be a subclass of androidx.activity.ComponentActivity. (e.g. FragmentActivity, AppCompatActivity, etc.)
 |   |--2. 如果使用 @AndroidEntryPoint 注解 Android 类，必须在它依赖的 Android 类添加同样的注解，
 |   |     例如在 Fragment 中添加 @AndroidEntryPoint 注解，必须在 Fragment 依赖的 Activity 上也添加 @AndroidEntryPoint 注解 , 否则会抛出以下异常:
 |   |     java.lang.IllegalStateException: Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: class com.hi.dhl.hilt.MainActivity

3.@Inject
 |--1.Hilt 需要知道如何从相应的组件中提供必要依赖的实例。使用 @Inject 注解来告诉 Hilt 如何提供该类的实例，它常用于构造函数、非私有字段、方法中

4.@Module
 |--1.常用于创建依赖类的对象(例如第三方库 OkHttp、Retrofit等等)，使用 @Module 注解的类，需要使用 @InstallIn 注解指定 module 的范围
 |--Case:
 |   | 
 |   |  @Module
 |   |  @InstallIn(ApplicationComponent::class)
 |   |  // 这里使用了 ApplicationComponent，因此 NetworkModule 绑定到 Application 的生命周期。
 |   |  object NetworkModule {
 |   |  }

5.@InstallIn
|--1.使用 @Module 注入的类，需要使用 @InstallIn 注解指定 module 的范围，例如使用 @InstallIn(ActivityComponent::class) 注解的 module 会绑定到 activity 的生命周期上
|--2.Hilt 提供了以下组件来绑定依赖与 对应的 Android 类的活动范围
|   |
|   |  Hilt 提供的组件               对应的 Android 类的活动范围
|   |
|   |  ApplicationComponent	        Application
|   |  ActivityRetainedComponent	ViewModel
|   |  ActivityComponent	        Activity
|   |  FragmentComponent	        Fragment
|   |  ViewComponent	            View
|   |  ViewWithFragmentComponent	View annotated with @WithFragmentBindings
|   |  ServiceComponent	            Service
|--Note: 
|   |--1.Hilt 没有为 broadcast receivers 提供组件，因为 Hilt 直接从 ApplicationComponent 注入 broadcast receivers
|   |--2.Hilt 会根据相应的 Android 类生命周期自动创建和销毁生成的组件类的实例，它们的对应关系如下表格所示
|   |   | 
|   |   | Hilt 提供的组件            创建对应的生命周期            销毁对应的生命周期
|   |   | 
|   |   | ApplicationComponent      Application # onCreate()    Application # onDestroy()
|   |   | ActivityRetainedComponent	Activity # onCreate()	    Activity # onDestroy()
|   |   | ActivityComponent	        Activity # onCreate()	    Activity # onDestroy()
|   |   | FragmentComponent	        Fragment # onAttach()	    Fragment # onDestroy()
|   |   | ViewComponent	            View # super()	            View destroyed
|   |   | ViewWithFragmentComponent	View # super()	            View destroyed
|   |   | ServiceComponent	        Service # onCreate()	    Service # onDestroy()

6.@Provides
|--1.它常用于被 @Module 注解标记类的内部的方法，并提供依赖项对象
|   |
|   |  @Module
|   |  @InstallIn(ApplicationComponent::class)
|   |  // 这里使用了 ApplicationComponent，因此 NetworkModule 绑定到 Application 的生命周期。
|   |  object NetworkModule {
|   |  
|   |      /**
|   |       * @Provides 常用于被 @Module 注解标记类的内部的方法，并提供依赖项对象。
|   |       * @Singleton 提供单例
|   |       */
|   |      @Provides
|   |      @Singleton
|   |      fun provideOkHttpClient(): OkHttpClient {
|   |          return OkHttpClient.Builder()
|   |              .build()
|   |      }
|   |  }
|   |
|   |

7.@EntryPoint
|--1. Hilt 支持最常见的 Android 类 Application、Activity、Fragment、View、Service、BroadcastReceiver 等等
|   | 但是您可能需要在Hilt 不支持的类中执行依赖注入，在这种情况下可以使用 @EntryPoint 注解进行创建，Hilt 会提供相应的依赖


如何使用Hilt


