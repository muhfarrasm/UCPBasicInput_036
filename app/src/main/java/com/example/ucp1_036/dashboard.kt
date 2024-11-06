package com.example.ucp1_036

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Preview(showBackground = true)
@Composable

fun dashboard(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var nohp by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var nohpsv by remember { mutableStateOf("") }
    var jenissv by remember { mutableStateOf("") }

    val listjenis = listOf("Laki-Laki", "Perempuan")
    val Purple200 = Color(0x0e9113)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Headersection()
        Spacer(modifier = Modifier.size(10.dp))
        Text("Yuk lengkapi data dirimu!",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.padding(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),

            value = nama,
            onValueChange = {nama =it},
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama Anda!") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),

            value = nohp,
            onValueChange = {nohp =it},
            label = { Text("No HP") },
            placeholder = { Text("Masukkan No Hp Anda!") }
        )

        Text("Jenis Kelamin",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold

        )
        Row (verticalAlignment = Alignment.Top){

            listjenis.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = jenis == item,
                        onClick = {
                            jenis = item
                        }

                    )
                    Text(item)
                }

            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
            , onClick = {
            namasv = nama
            nohpsv = nohp
            jenissv = jenis
        }){
            Text("Simpan")

        }

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),

                colors = CardDefaults.cardColors(contentColor = Color.White)
        ) {
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(5.dp))
            {
                Text("Nomor Handphone",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold

                )



            }
            //detaildata("No Hp", nohpsv)


            detaildata("Memilih Jenis Kelamin", jenissv)


        }

    }

}

@Composable
fun Headersection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Column {


                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "Halo",
                    color = Color.White
                )

                Text(
                    text = "",
                    color = Color.White
                )

            }
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = R.drawable.images),
                    contentDescription = "lemon",
                    modifier = Modifier
                        .size(50.dp)
                )


            }
        }

    }
}

@Composable
fun detaildata(judul: String, isi: String){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)

        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isi,
                modifier = Modifier.weight(2f))
        }

    }
}