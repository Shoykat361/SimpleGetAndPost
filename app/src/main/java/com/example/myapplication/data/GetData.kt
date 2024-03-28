package com.example.myapplication.data

import com.google.gson.annotations.SerializedName


data class GetData(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("old_due")
	val oldDue: String? = null,

	@field:SerializedName("group")
	val group: Int? = null


)
