package pe.edu.upc.gymfit

import android.app.Application
import pe.edu.upc.gymfit.di.AppComponent
import pe.edu.upc.gymfit.di.DaggerAppComponent
import pe.edu.upc.gymfit.di.auth.AuthComponent
import pe.edu.upc.gymfit.di.main.MainComponent

class BaseApplication : Application(){

    lateinit var appComponent: AppComponent

    private var authComponent: AuthComponent? = null

    private var mainComponent: MainComponent? = null

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    fun releaseMainComponent(){
        mainComponent = null
    }

    fun mainComponent(): MainComponent {
        if(mainComponent == null){
            mainComponent = appComponent.mainComponent().create()
        }
        return mainComponent as MainComponent
    }

    fun releaseAuthComponent(){
        authComponent = null
    }

    fun authComponent(): AuthComponent {
        if(authComponent == null){
            authComponent = appComponent.authComponent().create()
        }
        return authComponent as AuthComponent
    }

    fun initAppComponent(){
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }


}