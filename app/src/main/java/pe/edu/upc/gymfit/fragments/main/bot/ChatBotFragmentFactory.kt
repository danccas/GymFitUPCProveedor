package pe.edu.upc.gymfit.fragments.main.bot

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import pe.edu.upc.gymfit.di.main.MainScope
import pe.edu.upc.gymfit.ui.bot.ChatBotFragment
import javax.inject.Inject

@MainScope
class ChatBotFragmentFactory
@Inject
constructor(
    private val viewModelFactory: ViewModelProvider.Factory,
    private val requestManager: RequestManager
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            ChatBotFragment::class.java.name -> {
                ChatBotFragment(
                    viewModelFactory,
                    requestManager
                )
            }

            else -> {
                ChatBotFragment(
                    viewModelFactory,
                    requestManager
                )
            }
        }


}