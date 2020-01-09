# Agile
a agile android framework for MVP.
一个Android高效框架，提供公共框架、方法，进行敏捷开发。

最新v0.3.42:重构部分代码，统一方法调用，提升安全性</br>

    v0.3.39:重构框架部分内容，优化代码</br>
    v0.3.33:</br>
    v0.3.32:</br>
    v0.3.31:</br>
	1.优化调整</br>
    v0.3.30:</br>
    	1.新增FTP和Socket功能模块</br>
    	2.调整api对外提供依赖包（只有RoundCornerDialogHelper、RecorderManager、MediaPicker三个）</br>

已重构架构，规范命名，引入Kotlin
1.Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
2.Add the dependency
```
dependencies {
	        implementation 'com.github.MingYueChunQiu:Agile:最新版本'
	}
```

3.现在自已应用的application中添加
```
//框架配置信息，可以配置，也可以不配置使用库的默认值
AgileFrameConfigure configure = new AgileFrameConfigure.Builder()
                .setNetworkConfig(new AgileNetworkConfig.Builder()
                        .setConnectNetTimeout(20)
                        .setReadNetTimeout(20)
                        .setWriteNetTimeout(20)
                        .build())
                .build();
//这句一定要有，否则有些功能会无法实现
Agile.init(this);
Agile.setConfigure(configure);
Agile.debug(true);//设置是否启动调试模式
```
4.使用MVP
所有MVP相关的类都在base包下，可以选择具体的M、V、P层进行继承，跟界面有关的类都在ui包下，可以选择对应的activity、fragment、dialogFragment进行继承。

(1).base包下:

```
view:		
		IBaseView
	  	----IBaseStatusView
	     	    ----IBaseNetView
		    
		IViewAttachPresenter<P>
	
presenter:	
		IBasePresenter
		----BaseAbstractPresenter
		    ----BaseStatusViewPresenter
		        ----BaseNetPresenter
			    ----BaseCountDownPresenter（具体业务Presenter）
	        ----engine
		    ----IBasePresenterEngine
		    
model:		
		IBaseModel
		----BaseAbstractModel
		    ----BaseNetModel
		        ----BaseTokenNetModel
		
		part 
		----IBaseModelPart
		    ----BaseAbstractModelPart
		    
		dao
		----IBaseDao<C extends IBaseDao.ModelDaoCallback>
		
		----local
		    ----IBaseLocalDao<C extends IBaseDao.ModelDaoCallback>
		        ----BaseAbstractLocalDao<C extends IBaseDao.ModelDaoCallback>
			
		----remote
		    ----IBaseRemoteDao<C extends IBaseDao.ModelDaoCallback>
		        ----BaseAbstractRemoteDao<C extends IBaseDao.ModelDaoCallback>
			    ----BaseAbstractNetworkDao<C extends IBaseDao.ModelDaoCallback>
			        ----BaseAbstractRetrofitDao<C extends IBaseDao.ModelDaoCallback>
			
		----operation
		    ----IBaseDaoOperation
		    ----local
		        ----IBaseLocalDaoOperation
			    ----BaseAbstractLocalDaoOperation<T>
		    ----remote
		        ----IBaseRemoteDaoOperation
			    ----BaseAbstractRemoteDaoOperation<T>
			        ----RetrofitCallDaoOperation
				
onMenuItemClickListener:
		IBaseListener
		----ICountDownListener（具体业务接口）
```

(2).ui包下:

```
activity:	
		BaseActivity
		----BaseFullImmerseScreenActivity
		    ----BasePresenterActivity
		        ----BaseNetPresenterActivity
		            ----BaseToolbarPresenterActivity
	        	        ----WebViewActivity（具体业务实现）
					
fragment:	
		BaseFragment
		----BasePresenterFragment
		    ----BaseNetPresenterFragment
		        ----BaseToolbarPresenterFragment
			
dialogFragment:	
		BaseDialogFragment
		----BasePresenterDialogFragment
		    ----BaseNetPresenterDialogFragment
		
bottomSheetDialogFragment:	
		BaseBSDialogFragment
		----BasePresenterBSDialogFragment
		    ----BaseNetPresenterBSDialogFragment
```

(3).feature包下:

目前暂时提供如下功能：&nbsp;</br>
        remote远程包下：1.FTP处理</br>
                       2.Socket处理</br>
	json包：提供了对json的相关处理</br>
	loading：提供了加载Fragment的功能</br>
	logmanager：提供了日志功能</br>
	playermanager：提供了播放视频的相关功能</br>
	
5.具体内容后续会进行补充
