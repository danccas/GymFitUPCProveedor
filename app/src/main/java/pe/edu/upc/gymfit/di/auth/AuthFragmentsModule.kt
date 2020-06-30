package pe.edu.upc.gymfit.di.auth

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import pe.edu.upc.gymfit.fragments.auth.AuthFragmentFactory
import dagger.Module
import dagger.Provides

@Module
object AuthFragmentsModule {

    @JvmStatic
    @AuthScope
    @Provides
    fun provideFragmentFactory(
        viewModelFactory: ViewModelProvider.Factory
    ): FragmentFactory {
        return AuthFragmentFactory(
            viewModelFactory
        )
    }

}