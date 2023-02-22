package com.example.observerpatternexample

import android.os.Bundle
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.goButton).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container, SecondFragment())
                .addToBackStack("SecondFragment")
                .commit()
        }

        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)

        (requireActivity() as MainActivity).observable.addObserver(object : Observer {
            override fun update(value: String) {
                nameTextView.text = value
            }
        })
    }
}