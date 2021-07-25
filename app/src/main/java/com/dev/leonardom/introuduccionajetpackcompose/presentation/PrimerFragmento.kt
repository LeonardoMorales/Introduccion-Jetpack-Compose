package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.dev.leonardom.introuduccionajetpackcompose.R

class PrimerFragmento : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                NuevoComponible()
            }
        }
    }

}

@Composable
fun NuevoComponible() {
    Text("Hola soy un componible")
}