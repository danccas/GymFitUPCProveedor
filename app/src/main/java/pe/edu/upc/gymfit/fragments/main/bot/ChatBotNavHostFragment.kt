package pe.edu.upc.gymfit.fragments.main.bot

import android.content.Context
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import pe.edu.upc.gymfit.ui.main.MainActivity

class ChatBotNavHostFragment : NavHostFragment(){

    override fun onAttach(context: Context) {
        childFragmentManager.fragmentFactory =
            (activity as MainActivity).chatBotFragmentFactory
        super.onAttach(context)
    }

    companion object{

        const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"

        @JvmStatic
        fun create(
            @NavigationRes graphId: Int = 0
        ): ChatBotNavHostFragment {
            var bundle: Bundle? = null
            if(graphId != 0){
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, graphId)
            }
            val result =
                ChatBotNavHostFragment()
            if(bundle != null){
                result.arguments = bundle
            }
            return result
        }
    }
}
