package pe.edu.upc.gymfit.ui.main.account.state

import android.os.Parcelable
import pe.edu.upc.gymfit.models.AccountProperties
import kotlinx.android.parcel.Parcelize

const val ACCOUNT_VIEW_STATE_BUNDLE_KEY = "pe.edu.upc.gymfit.ui.main.account.state.AccountViewState"

@Parcelize
class AccountViewState(

    var accountProperties: AccountProperties? = null

) : Parcelable