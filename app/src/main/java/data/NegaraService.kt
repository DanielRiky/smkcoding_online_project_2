package data

import coronaNegaraItem



import retrofit2.Call
import retrofit2.http. GET
interface NegaraService {
    @GET ( " " )
    fun getNegara(): Call<List<coronaNegaraItem>>
}