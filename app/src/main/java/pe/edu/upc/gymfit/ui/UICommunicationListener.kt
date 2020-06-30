package pe.edu.upc.gymfit.ui

import pe.edu.upc.gymfit.util.Response
import pe.edu.upc.gymfit.util.StateMessageCallback

interface UICommunicationListener {

    fun onResponseReceived(
        response: Response,
        stateMessageCallback: StateMessageCallback
    )

    fun displayProgressBar(isLoading: Boolean)

    fun expandAppBar()

    fun hideSoftKeyboard()

    fun isStoragePermissionGranted(): Boolean
}