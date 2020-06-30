package pe.edu.upc.gymfit.di.main

import pe.edu.upc.gymfit.ui.main.MainActivity
import dagger.Subcomponent


@MainScope
@Subcomponent(
    modules = [
        MainModule::class,
        MainViewModelModule::class,
        MainFragmentsModule::class
    ])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory{

        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)

}







