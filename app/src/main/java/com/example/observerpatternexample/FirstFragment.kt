package com.example.observerpatternexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    private lateinit var nameTextView: TextView
    private val observer = object : Observer {
        override fun update(value: String) {
            nameTextView.text = value
        }
    }

    private val loggingObserver = object : Observer {
        override fun update(value: String) {
            Log.d("log9101", "value $value")
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.goButton).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container, SecondFragment())
                .addToBackStack("SecondFragment")
                .commit()
        }

        nameTextView = view.findViewById(R.id.nameTextView)

    }

    override fun onPause() {
        super.onPause()
        (requireActivity() as MainActivity).observable.removeObserver(observer)
        (requireActivity() as MainActivity).observable.removeObserver(loggingObserver)
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).observable.addObserver(observer)
        (requireActivity() as MainActivity).observable.addObserver(loggingObserver)
    }
}