package com.example.retrofituses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofituses.entity.CRUDCevap
import com.example.retrofituses.entity.KisilerCevap
import com.example.retrofituses.retrofit.ApiUtils
import com.example.retrofituses.retrofit.KisilerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var kdaoi : KisilerDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kdaoi = ApiUtils.getKisilerdaoInterface()

        //tumKisilerGoster()
        //kayit()
        //sil()
        //guncelle()
        ara()
    }

    fun tumKisilerGoster(){

        kdaoi.tumkisiler().enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>) {
                val kisilerListesi = response.body().kisiler

                for(k in kisilerListesi){
                    Log.e("************","************")
                    Log.e("kişi_id",k.kisi_id.toString())
                    Log.e("kişi_ad",k.kisi_ad)
                    Log.e("kişi_tel",k.kisi_tel)

                }
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {}
        })
    }

    fun kayit(){
        kdaoi.kisiEkle("Bakitgul","1723").enqueue(object :Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                Log.e("Başarı",response.body().success.toString())
                Log.e("Mesaj",response.body().message)
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })
    }

    fun sil(){
        kdaoi.kisiSil(1293).enqueue(object :Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                Log.e("Başarı",response.body().success.toString())
                Log.e("Mesaj",response.body().message)
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })
    }

    fun guncelle(){
        kdaoi.kisiGuncelle(1294,"Bakitgul Fatma Birlik","17231623").enqueue(object :Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                Log.e("Başarı",response.body().success.toString())
                Log.e("Mesaj",response.body().message)
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })
    }

    fun ara(){

        kdaoi.kisiAra("t").enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>) {
                val kisilerListesi = response.body().kisiler

                for(k in kisilerListesi){
                    Log.e("************","************")
                    Log.e("kişi_id",k.kisi_id.toString())
                    Log.e("kişi_ad",k.kisi_ad)
                    Log.e("kişi_tel",k.kisi_tel)

                }
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {}
        })
    }
}