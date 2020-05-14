
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class provinsiItem(
    @SerializedName("attributes")
    val attributess: Attributess
) : Serializable