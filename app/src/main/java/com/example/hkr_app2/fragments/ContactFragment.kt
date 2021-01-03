package com.example.hkr_app2.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.hkr_app2.R
import com.example.hkr_app2.webAddress


class ContactFragment : Fragment(R.layout.fragment_contact) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnGithub = view.findViewById<Button>(R.id.buttonGithub)
        val btnLi = view.findViewById<Button>(R.id.buttonLi)
        val btnPhone = view.findViewById<Button>(R.id.buttonPhone)
        val btnEmail = view.findViewById<Button>(R.id.buttonEmail)

        btnGithub.setOnClickListener {
            val webFragment = WebFragment()
            val fragmentManager = activity?.supportFragmentManager
            webAddress.address = "https://github.com/Heisaa"
            fragmentManager?.commit {

                setReorderingAllowed(true)
                replace(R.id.fragmentContainerRight, webFragment)
            }
        }

        btnLi.setOnClickListener {
            val webFragment = WebFragment()
            val fragmentManager = activity?.supportFragmentManager
            webAddress.address = "https://linkedin.com"
            fragmentManager?.commit {

                setReorderingAllowed(true)
                replace(R.id.fragmentContainerRight, webFragment)
            }
        }

        btnPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:0123456789")
            startActivity(intent)
        }

        btnEmail.setOnClickListener {
            val addresses = arrayOf("henrik@gmail.com")
            openEmailClient(addresses, "contact")

        }
    }

    private fun openEmailClient(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }

        if (activity?.packageManager?.let { intent.resolveActivity(it) } != null) {
            startActivity(intent)
        }
    }

}