package pe.edu.upc.gymfit.repository.main
import pe.edu.upc.gymfit.api.main.OpenApiMainService
import pe.edu.upc.gymfit.api.main.responses.BlogCreateUpdateResponse
import pe.edu.upc.gymfit.di.main.MainScope
import pe.edu.upc.gymfit.models.AuthToken
import pe.edu.upc.gymfit.persistence.BlogPostDao
import pe.edu.upc.gymfit.repository.safeApiCall
import pe.edu.upc.gymfit.session.SessionManager
import pe.edu.upc.gymfit.ui.main.create_blog.state.CreateBlogViewState
import pe.edu.upc.gymfit.util.*
import pe.edu.upc.gymfit.util.SuccessHandling.Companion.RESPONSE_MUST_BECOME_CODINGWITHMITCH_MEMBER
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

@FlowPreview
@MainScope
class CreateBlogRepositoryImpl
@Inject
constructor(
    val openApiMainService: OpenApiMainService,
    val blogPostDao: BlogPostDao,
    val sessionManager: SessionManager
): CreateBlogRepository {

    private val TAG: String = "AppDebug"

    override fun createNewBlogPost(
        authToken: AuthToken,
        title: RequestBody,
        body: RequestBody,
        image: MultipartBody.Part?,
        stateEvent: StateEvent
    ) = flow{

        val apiResult = safeApiCall(IO){
            openApiMainService.createBlog(
                "Token ${authToken.token!!}",
                title,
                body,
                image
            )
        }

        emit(
            object: ApiResponseHandler<CreateBlogViewState, BlogCreateUpdateResponse>(
                response = apiResult,
                stateEvent = stateEvent
            ){
                override suspend fun handleSuccess(resultObj: BlogCreateUpdateResponse): DataState<CreateBlogViewState> {

                    // If they don't have a paid membership account it will still return a 200
                    // Need to account for that

                    if (!resultObj.response.equals(RESPONSE_MUST_BECOME_CODINGWITHMITCH_MEMBER)) {
                        val updatedBlogPost = resultObj.toBlogPost()
                        blogPostDao.insert(updatedBlogPost)
                    }
                    return DataState.data(
                        response = Response(
                            message = resultObj.response,
                            uiComponentType = UIComponentType.Dialog(),
                            messageType = MessageType.Success()
                        ),
                        data = null,
                        stateEvent = stateEvent
                    )
                }
            }.getResult()
        )
    }

}














