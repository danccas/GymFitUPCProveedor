package pe.edu.upc.gymfit.repository.main

import pe.edu.upc.gymfit.di.main.MainScope
import pe.edu.upc.gymfit.models.AuthToken
import pe.edu.upc.gymfit.ui.main.create_blog.state.CreateBlogViewState
import pe.edu.upc.gymfit.util.DataState
import pe.edu.upc.gymfit.util.StateEvent
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

@FlowPreview
@MainScope
interface CreateBlogRepository {

    fun createNewBlogPost(
        authToken: AuthToken,
        title: RequestBody,
        body: RequestBody,
        image: MultipartBody.Part?,
        stateEvent: StateEvent
    ): Flow<DataState<CreateBlogViewState>>
}