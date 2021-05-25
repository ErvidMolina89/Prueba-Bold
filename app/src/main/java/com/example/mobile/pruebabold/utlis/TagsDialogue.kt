package com.example.mobile.pruebabold.utlis

enum class TagsDialogue {
    DialogGeneric
    ;
    fun getTags() : String{
        return when(this){
            DialogGeneric -> "DialogGeneric"
        }
    }
}