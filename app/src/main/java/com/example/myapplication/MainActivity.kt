package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: MainBinding

    // private lateinit var adapter: PostAdapter
    private lateinit var name: EditText
    private lateinit var address: EditText
    private lateinit var phone: EditText
    private lateinit var oldDue: EditText
    private lateinit var customerSpineer: EditText
    private lateinit var saveButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinnerItem: Spinner
    private lateinit var spinnerData: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        name = findViewById(R.id.nameInputEt)
        address = findViewById(R.id.addressInputEt)
        phone = findViewById(R.id.phoneInputEt)
        oldDue = findViewById(R.id.dueinputDueEt)
        saveButton = findViewById(R.id.saveBtn)
        spinnerItem = findViewById(R.id.spinner)
        //recyclerView = findViewById(R.id.recyclerViewXml)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        val group = arrayOf("Select Client Group", 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val arrayAdapter =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, group)
        spinnerItem.adapter = arrayAdapter
        spinnerItem.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                for (x in group) {
                    Log.d("SpinnerValue", "$x")
                }
                Log.d("SpinnnerItemSelect", "${spinnerItem.toString()}")
                Toast.makeText(this@MainActivity, "item clicked", Toast.LENGTH_SHORT).show()
                spinnerData = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "not clicked", Toast.LENGTH_SHORT).show()
            }

        }
        //viewModel.pushPost("Shoykat","Dhanmondhi","01789321809","500","2")
        /*viewModel.pushPost(1,1,"hello this ","wwwfergthyjuyhtgrfd")
        viewModel.myPushResponse.observe(this) {response->
            //Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
            Log.d("mainactivity","${response.body()}")
            Log.d("mainactivity","${response.code()}")
            if (response.isSuccessful){
                Toast.makeText(this, "${response.code()}", Toast.LENGTH_SHORT).show()
            }

        }*/
        //Validation

        saveButton.setOnClickListener {
            val uname = name.text.toString()
            val useraddress = address.text.toString()
            val userphone = phone.text.toString()
            val useroldDue = oldDue.text.toString()
            //val groupItem = spinnerData
            //Log.d("CheckOriginGroup Item","$groupItem")
            Log.d("CheckOriginGroupSoinnneeeerData", "$spinnerData")
            if (uname.isBlank() || useraddress.isBlank() || userphone.isBlank() || spinnerData.isBlank() || spinnerData == "Select Client Group") {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // All fields are filled, proceed with saving the data
                viewModel.pushPost(uname, useraddress, userphone, useroldDue, spinnerData)

                Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_SHORT).show()
                name.text.clear()
                address.text.clear()
                phone.text.clear()
                oldDue.text.clear()
                spinnerItem.setSelection(0)
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

            /*  viewModel.pushPost(name,address,phone,oldDue,group)
            Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_SHORT).show()*/

        }


        /*viewModel.myPushResponse.observe(this) { response ->
            Log.d("MainActivity", "${response.body()}")
            Log.d("MainActivity", "${response.code()}")

            // Check if the response is successful
            if (response.isSuccessful) {
                // Display response data in EditText fields
                *//*val post = response.body()
                etUserId.setText(post?.userId.toString())
                etId.setText(post?.id.toString())
                etTitle.setText(post?.title)
                etBody.setText(post?.body)*//*
                Log.d("checkSaha","${response.body()?.name}")
                Log.d("checkSaha","${response.body()?.group}")
                Log.d("checkSaha","${response.body()?.oldDue}")
                Log.d("checkSaha","${response.body()?.address}")
                name.text.clear()
                phone.text.clear()
                address.text.clear()
                oldDue.text.clear()

                Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_SHORT).show()
            } else {
                // Show error message if request is not successful
                Toast.makeText(this, "Failed to load data: ${response.message()}", Toast.LENGTH_SHORT).show()
            }
        }*/
        /*viewModel.posts.observe(this) { datas ->
            for (data in datas) {
                println(data.id)
                println(data.title)

            }

        }*/
        /*adapter = PostAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter*/

        /*viewModel.getDatas .observe(this, Observer {

            adapter.setData(it)
        })*/

        /*viewModel.posts.observe(this, Observer {Data->
            *//*for (x in Data){
                Log.d("MyGetData","${x.name}")
                Log.d("MyGetData","${x.group}")
                Log.d("MyGetData","${x.oldDue}")
            }*//*

        })*/

    }
}




