package pe.edu.upc.gymfit.di

import android.app.Application
import pe.edu.upc.gymfit.di.auth.AuthComponent
import pe.edu.upc.gymfit.di.main.MainComponent
import pe.edu.upc.gymfit.session.SessionManager
import pe.edu.upc.gymfit.ui.BaseActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        SubComponentsModule::class
    ]
)
interface AppComponent  {

    val sessionManager: SessionManager

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(baseActivity: BaseActivity)

    fun authComponent(): AuthComponent.Factory

    fun mainComponent(): MainComponent.Factory

}








