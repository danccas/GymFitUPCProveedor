package pe.edu.upc.gymfit.di.main

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import pe.edu.upc.gymfit.api.main.OpenApiMainService
import pe.edu.upc.gymfit.persistence.AccountPropertiesDao
import pe.edu.upc.gymfit.persistence.AppDatabase
import pe.edu.upc.gymfit.persistence.BlogPostDao
import pe.edu.upc.gymfit.repository.main.AccountRepository
import pe.edu.upc.gymfit.repository.main.AccountRepositoryImpl
import pe.edu.upc.gymfit.repository.main.BlogRepositoryImpl
import pe.edu.upc.gymfit.repository.main.CreateBlogRepositoryImpl
import pe.edu.upc.gymfit.session.SessionManager
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.FlowPreview
import retrofit2.Retrofit
import javax.inject.Singleton

@FlowPreview
@Module
object MainModule {

    @JvmStatic
    @MainScope
    @Provides
    fun provideOpenApiMainService(retrofitBuilder: Retrofit.Builder): OpenApiMainService {
        return retrofitBuilder
            .build()
            .create(OpenApiMainService::class.java)
    }

    @JvmStatic
    @MainScope
    @Provides
    fun provideAccountRepository(
        openApiMainService: OpenApiMainService,
        accountPropertiesDao: AccountPropertiesDao,
        sessionManager: SessionManager
    ): AccountRepository {
        return AccountRepositoryImpl(openApiMainService, accountPropertiesDao, sessionManager)
    }

    @JvmStatic
    @MainScope
    @Provides
    fun provideBlogPostDao(db: AppDatabase): BlogPostDao {
        return db.getBlogPostDao()
    }

    @JvmStatic
    @MainScope
    @Provides
    fun provideBlogRepository(
        openApiMainService: OpenApiMainService,
        blogPostDao: BlogPostDao,
        sessionManager: SessionManager
    ): BlogRepositoryImpl {
        return BlogRepositoryImpl(openApiMainService, blogPostDao, sessionManager)
    }

    @JvmStatic
    @MainScope
    @Provides
    fun provideCreateBlogRepository(
        openApiMainService: OpenApiMainService,
        blogPostDao: BlogPostDao,
        sessionManager: SessionManager
    ): CreateBlogRepositoryImpl {
        return CreateBlogRepositoryImpl(openApiMainService, blogPostDao, sessionManager)
    }

}

















