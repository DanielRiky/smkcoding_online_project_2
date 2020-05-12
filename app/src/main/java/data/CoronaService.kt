package data

import com.example.chalenge2.CoronaIndonesiaItem
import retrofit2.Call
import retrofit2.http. GET
interface CoronaService {
    @GET ( "indonesia" )
    fun getUsers(): Call<List<CoronaIndonesiaItem>>
}