package com.example.myapplication.data

import com.google.gson.annotations.SerializedName



data class Posts(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,


	@field:SerializedName("old_due")
	val oldDue: String? = null,

	/*@field:SerializedName("updated_at")
	val updatedAt: String? = null,


	@field:SerializedName("created_at")
	val createdAt: String? = null,*/

	/*@field:SerializedName("id")
	val id: Int? = null,*/

	@field:SerializedName("group")
	val group: String? = null
)
