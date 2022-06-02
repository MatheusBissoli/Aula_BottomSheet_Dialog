package com.br.usemobile.aula9

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.br.usemobile.aula9.databinding.ActivityBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheetActivity : AppCompatActivity() {

    var binding: ActivityBottomSheetBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//        val myBottomSheet = binding?.myBottomSheet?.root

//        binding?.buttonBottomSheetModal?.setOnClickListener {
////            MyBottomSheetDialogFragment().apply {
////                show(supportFragmentManager, tag)
////            }
//
//            val bottomSheetBehaviour = BottomSheetBehavior.from(myBottomSheet!!)
//            if(bottomSheetBehaviour.state == BottomSheetBehavior.STATE_EXPANDED){
//                bottomSheetBehaviour.state = BottomSheetBehavior.STATE_COLLAPSED
//            } else {
//                bottomSheetBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
//            }
//
//
//        }

//        dialogSimples()
        dialogCustom()
    }


    private fun dialogSimples() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Aula 9")
        builder.setMessage("Android melhor time?")
        builder.setPositiveButton("Claro!", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(
                    this@BottomSheetActivity,
                    "Clicou em Claro!",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        builder.setNegativeButton("sim", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(
                    this@BottomSheetActivity,
                    "Clicou em sim!",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        builder.setNeutralButton("Cancelar", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(
                    this@BottomSheetActivity,
                    "Clicou em cancelar!",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        builder.create().show()
    }

    private fun dialogCustom() {
        val view : View = layoutInflater.inflate(R.layout.custom_dialog, null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        builder.setCancelable(false)
        val alert = builder.create()
        view.findViewById<Button>(R.id.btn_dismiss).setOnClickListener {
            Toast.makeText(
                this@BottomSheetActivity,
                "Dialog fechou!!!",
                Toast.LENGTH_LONG
            ).show()

            alert.dismiss()
        }
        alert.show()
    }

}