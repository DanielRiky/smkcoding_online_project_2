package data

import com.example.chalenge2.CoronaIndonesiaItem
import retrofit2.Call
import retrofit2.http. GET
interface ProvinsiService {
    @GET ( "indonesia/provinsi" )
    fun getUsers(): Call<List<CoronaIndonesiaItem>>
}