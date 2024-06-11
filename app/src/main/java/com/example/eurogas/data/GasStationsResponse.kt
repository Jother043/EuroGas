import com.google.gson.annotations.SerializedName

data class GasStationsResponse(
    @SerializedName("ListaEESSPrecio") val gasStations: List<GasStation>,
    @SerializedName("Fecha") val date: String,
    @SerializedName("Nota") val note: String,
    @SerializedName("ResultadoConsulta") val queryResult: String
)

data class GasStation(
    @SerializedName("C.P.") val postalCode: String,
    @SerializedName("Dirección") val address: String,
    @SerializedName("Horario") val schedule: String,
    @SerializedName("Latitud") val latitude: String,
    @SerializedName("Localidad") val locality: String,
    @SerializedName("Longitud (WGS84)") val longitude: String,
    @SerializedName("Margen") val margin: String,
    @SerializedName("Municipio") val municipality: String,
    @SerializedName("Precio Biodiesel") val biodieselPrice: String,
    @SerializedName("Precio Bioetanol") val bioethanolPrice: String,
    @SerializedName("Precio Gas Natural Comprimido") val compressedNaturalGasPrice: String,
    @SerializedName("Precio Gas Natural Licuado") val liquefiedNaturalGasPrice: String,
    @SerializedName("Precio Gases licuados del petróleo") val petroleumLiquefiedGasesPrice: String,
    @SerializedName("Precio Gasoleo A") val dieselAPrice: String,
    @SerializedName("Precio Gasoleo B") val dieselBPrice: String,
    @SerializedName("Precio Gasoleo Premium") val premiumDieselPrice: String,
    @SerializedName("Precio Gasolina 95 E10") val gasoline95E10Price: String,
    @SerializedName("Precio Gasolina 95 E5") val gasoline95E5Price: String,
    @SerializedName("Precio Gasolina 95 E5 Premium") val premiumGasoline95E5Price: String,
    @SerializedName("Precio Gasolina 98 E10") val gasoline98E10Price: String,
    @SerializedName("Precio Gasolina 98 E5") val gasoline98E5Price: String,
    @SerializedName("Precio Hidrogeno") val hydrogenPrice: String,
    @SerializedName("Provincia") val province: String,
    @SerializedName("Remisión") val remission: String,
    @SerializedName("Rótulo") val label: String,
    @SerializedName("Tipo Venta") val saleType: String,
    @SerializedName("% BioEtanol") val bioethanolPercentage: String,
    @SerializedName("% Éster metílico") val methylEsterPercentage: String,
    @SerializedName("IDEESS") val idEESS: String,
    @SerializedName("IDMunicipio") val idMunicipality: String,
    @SerializedName("IDProvincia") val idProvince: String,
    @SerializedName("IDCCAA") val idCCAA: String
)