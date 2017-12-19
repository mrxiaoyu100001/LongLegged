# LongLegged
主要应用技术：

 设计理念：一个activity ＋ 多个 fragment的模式，采用MVP的模式高内聚低耦合。

 开源框架： MVP ＋

 设计模式： 调停者模式 ＋ 工厂模式 ＋ 单例模式 ＋ 观察者模式...

 添加大神写的开源库：
 UIAlertView、UIActionSheetView、UIProgressView、TitleBarView、RadiusView 等。

 总结:项目写到这里还是有一些问题，但是基本的框架已经写完了，接下来的工作将是引用rxjava系列的网络请求开源库。
 
 问题： 1.若不及时清理fragment栈中fragment对象项目在rebuilde过程存在一些问题,后期项目整体总结及优化。 2.公用titlebar设置背景图片失败。 3.公用titlebar在沉浸式状态栏中无法设置图片  4.公用titlebar 无法动态设置状态栏属性
 
