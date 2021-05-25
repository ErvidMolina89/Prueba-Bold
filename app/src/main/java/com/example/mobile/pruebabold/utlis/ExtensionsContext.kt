@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.example.mobile.pruebabold.utlis

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity

//region dialogos
fun Context.showDialogGeneric(){
    if(!isAValidContextToDisplayMessage(this)){ return }
    if(this !is AppCompatActivity){
        getContextValid(this).showDialogGeneric()
        return
    }
    runOnUiThread {
        DialogGeneric.getInstance().showDialogue(supportFragmentManager, TagsDialogue.DialogGeneric.getTags())
    }
}

private fun isAValidContextToDisplayMessage(contex: Context) : Boolean{
    return contex is AppCompatActivity || contex is ContextWrapper
}

private fun getContextValid(contex : Context) : Context{
    var EndContex : Context = contex
    while((EndContex !is AppCompatActivity) && (EndContex is ContextWrapper)){
        EndContex = (EndContex as ContextWrapper).baseContext
    }
    return EndContex
}
