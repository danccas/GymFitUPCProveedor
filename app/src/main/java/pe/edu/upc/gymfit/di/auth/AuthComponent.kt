package pe.edu.upc.gymfit.di.auth

import pe.edu.upc.gymfit.ui.auth.*
import dagger.Subcomponent

@AuthScope
@Subcomponent(
    modules = [
        AuthModule::class,
        AuthViewModelModule::class,
        AuthFragmentsModule::class
    ])
interface AuthComponent {

    @Subcomponent.Factory
    interface Factory{

        fun create(): AuthComponent
    }

    fun inject(authActivity: AuthActivity)

}
