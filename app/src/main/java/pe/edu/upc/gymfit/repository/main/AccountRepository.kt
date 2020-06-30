package pe.edu.upc.gymfit.repository.main

import pe.edu.upc.gymfit.di.main.MainScope
import pe.edu.upc.gymfit.models.AccountProperties
import pe.edu.upc.gymfit.models.AuthToken
import pe.edu.upc.gymfit.ui.main.account.state.AccountViewState
import pe.edu.upc.gymfit.util.DataState
import pe.edu.upc.gymfit.util.StateEvent
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@FlowPreview
@MainScope
interface AccountRepository {

    fun getAccountProperties(
        authToken: AuthToken,
        stateEvent: StateEvent
    ): Flow<DataState<AccountViewState>>

    fun saveAccountProperties(
        authToken: AuthToken,
        email: String,
        username: String,
        stateEvent: StateEvent
    ): Flow<DataState<AccountViewState>>

    fun updatePassword(
        authToken: AuthToken,
        currentPassword: String,
        newPassword: String,
        confirmNewPassword: String,
        stateEvent: StateEvent
    ): Flow<DataState<AccountViewState>>
}