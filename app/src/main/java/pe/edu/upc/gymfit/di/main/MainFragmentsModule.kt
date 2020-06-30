package pe.edu.upc.gymfit.di.main

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import pe.edu.upc.gymfit.fragments.main.account.AccountFragmentFactory
import pe.edu.upc.gymfit.fragments.main.blog.BlogFragmentFactory
import pe.edu.upc.gymfit.fragments.main.create_blog.CreateBlogFragmentFactory
import dagger.Module
import dagger.Provides
import pe.edu.upc.gymfit.fragments.main.bot.ChatBotFragmentFactory
import javax.inject.Named

@Module
object MainFragmentsModule {

    @JvmStatic
    @MainScope
    @Provides
    @Named("AccountFragmentFactory")
    fun provideAccountFragmentFactory(
        viewModelFactory: ViewModelProvider.Factory
    ): FragmentFactory {
        return AccountFragmentFactory(
            viewModelFactory
        )
    }

    @JvmStatic
    @MainScope
    @Provides
    @Named("BlogFragmentFactory")
    fun provideBlogFragmentFactory(
        viewModelFactory: ViewModelProvider.Factory,
        requestOptions: RequestOptions,
        requestManager: RequestManager
    ): FragmentFactory {
        return BlogFragmentFactory(
            viewModelFactory,
            requestOptions,
            requestManager
        )
    }

    @JvmStatic
    @MainScope
    @Provides
    @Named("CreateBlogFragmentFactory")
    fun provideCreateBlogFragmentFactory(
        viewModelFactory: ViewModelProvider.Factory,
        requestManager: RequestManager
    ): FragmentFactory {
        return CreateBlogFragmentFactory(
            viewModelFactory,
            requestManager
        )
    }

    @JvmStatic
    @MainScope
    @Provides
    @Named("ChatBotFragmentFactory")
    fun provideChatBotFragmentFactory(
        viewModelFactory: ViewModelProvider.Factory,
        requestManager: RequestManager
    ): FragmentFactory {
        return ChatBotFragmentFactory(
            viewModelFactory,
            requestManager
        )
    }

}