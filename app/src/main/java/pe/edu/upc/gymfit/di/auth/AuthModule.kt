package pe.edu.upc.gymfit.di.auth

import android.content.SharedPreferences
import pe.edu.upc.gymfit.api.auth.OpenApiAuthService
import pe.edu.upc.gymfit.persistence.AccountPropertiesDao
import pe.edu.upc.gymfit.persistence.AuthTokenDao
import pe.edu.upc.gymfit.repository.auth.AuthRepository
import pe.edu.upc.gymfit.repository.auth.AuthRepositoryImpl
import pe.edu.upc.gymfit.session.SessionManager
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.FlowPreview
import retrofit2.Retrofit

@FlowPreview
@Module
object AuthModule{

    @JvmStatic
    @AuthScope
    @Provides
    fun provideOpenApiAuthService(retrofitBuilder: Retrofit.Builder): OpenApiAuthService {
        return retrofitBuilder
            .build()
            .create(OpenApiAuthService::class.java)
    }

    @JvmStatic
    @AuthScope
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AccountPropertiesDao,
        openApiAuthService: OpenApiAuthService,
        preferences: SharedPreferences,
        editor: SharedPreferences.Editor
        ): AuthRepository {
        return AuthRepositoryImpl(
            authTokenDao,
            accountPropertiesDao,
            openApiAuthService,
            sessionManager,
            preferences,
            editor
        )
    }


}









