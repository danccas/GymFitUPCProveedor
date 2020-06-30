package pe.edu.upc.gymfit.fragments.main.create_blog

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import pe.edu.upc.gymfit.di.main.MainScope
import pe.edu.upc.gymfit.ui.main.account.AccountFragment
import pe.edu.upc.gymfit.ui.main.blog.BlogFragment
import pe.edu.upc.gymfit.ui.main.blog.UpdateBlogFragment
import pe.edu.upc.gymfit.ui.main.blog.ViewBlogFragment
import pe.edu.upc.gymfit.ui.main.create_blog.CreateBlogFragment
import javax.inject.Inject

@MainScope
class CreateBlogFragmentFactory
@Inject
constructor(
    private val viewModelFactory: ViewModelProvider.Factory,
    private val requestManager: RequestManager
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            CreateBlogFragment::class.java.name -> {
                CreateBlogFragment(viewModelFactory, requestManager)
            }

            else -> {
                CreateBlogFragment(viewModelFactory, requestManager)
            }
        }


}