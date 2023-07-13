package com.example.firebase

data class UserModel(
    var userId:String? = null,
    var userName:String?= null,
    var userContact:Long? = null,
    var userAddress:String? = null,
    var userEmail:String? = null,
    var userPassword:String? = null
)