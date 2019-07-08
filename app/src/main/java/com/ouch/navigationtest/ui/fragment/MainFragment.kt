package com.ouch.navigationtest.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ouch.navigationtest.R
import kotlinx.android.synthetic.main.fragment_main.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SplashFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        ThreadUtils.postDelayOnUI(Runnable {
//            Navigation.findNavController(tv_splash).navigate(R.id.action_splashFragment_to_mainFragment)
//        }, 5000)

        tv_main.setOnClickListener {
            Log.e("SplashFragment", "Click")
            val bundle = Bundle()
            bundle.putInt("id", 123)
            bundle.putString("name", "lee")
            Navigation.findNavController(tv_main).navigate(R.id.action_mainFragment_to_detailFragment, bundle)
//            Navigation.createNavigateOnClickListener(R.id.action_splashFragment_to_mainFragment, null)
        }

        bt4.setOnClickListener {
            Navigation.findNavController(bt4).navigate(R.id.action_mainFragment_to_moreFragment)
        }

        tv_bottom.setOnClickListener {
            val intent = Intent()
            intent.data = Uri.parse("https://www.ouchteam.com")
            Navigation.findNavController(tv_bottom).handleDeepLink(intent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SplashFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
