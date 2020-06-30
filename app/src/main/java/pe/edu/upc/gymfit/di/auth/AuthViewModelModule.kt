package pe.edu.upc.gymfit.di.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pe.edu.upc.gymfit.di.auth.keys.AuthViewModelKey
import pe.edu.upc.gymfit.ui.auth.AuthViewModel
import pe.edu.upc.gymfit.viewmodels.AuthViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @AuthScope
    @Binds
    abstract fun bindViewModelFactory(factory: AuthViewModelFactory): ViewModelProvider.Factory

    @AuthScope
    @Binds
    @IntoMap
    @AuthViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel

}