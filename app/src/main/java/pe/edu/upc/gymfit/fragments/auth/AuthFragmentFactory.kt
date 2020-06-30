package pe.edu.upc.gymfit.fragments.auth

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import pe.edu.upc.gymfit.di.auth.AuthScope
import pe.edu.upc.gymfit.ui.auth.*
import pe.edu.upc.gymfit.ui.bot.ChatBotFragment
import javax.inject.Inject

@AuthScope
class AuthFragmentFactory
@Inject
constructor(
    private val viewModelFactory: ViewModelProvider.Factory
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            LauncherFragment::class.java.name -> {
                LauncherFragment(viewModelFactory)
            }

            LoginFragment::class.java.name -> {
                LoginFragment(viewModelFactory)
            }

            RegisterFragment::class.java.name -> {
                RegisterFragment(viewModelFactory)
            }

            ForgotPasswordFragment::class.java.name -> {
                ForgotPasswordFragment(viewModelFactory)
            }

            else -> {
                LauncherFragment(viewModelFactory)
            }
        }


}