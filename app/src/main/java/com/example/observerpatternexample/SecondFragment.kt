package com.example.observerpatternexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText = view.findViewById<EditText>(R.id.inputEditText)
        view.findViewById<View>(R.id.finishButton).setOnClickListener {
            val text = editText.text.toString()
            (requireActivity() as MainActivity).observable.notifyObservers(text)
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}