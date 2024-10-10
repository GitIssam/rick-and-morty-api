package org.mathieu.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import org.mathieu.data.remote.responses.CharacterResponse
import org.mathieu.data.remote.responses.LocationResponse
import org.mathieu.data.remote.responses.PaginatedResponse

internal class LocationAPI(private val client: HttpClient) {

    /**
     * Fetches a list of characters from the API.
     *
     * If the page parameter is not provided, it defaults to fetching the first page.
     *
     * @param page The page number to fetch. If null, the first page is fetched by default.
     * @return A paginated response containing a list of [LocationResponse] for the specified page.
     * @throws HttpException if the request fails or if the status code is not [HttpStatusCode.OK].
     */
    suspend fun getLocations(page: Int?): PaginatedResponse<LocationResponse> = client
        .get("location/") {
            if (page != null)
                url {
                    parameter("page", page)
                }
        }
        .accept(HttpStatusCode.OK)
        .body()

    /**
     * Fetches the details of a character with the given ID from the service.
     *
     * @param id The unique identifier of the character to retrieve.
     * @return The [LocationResponse] representing the details of the character.
     * @throws HttpException if the request fails or if the status code is not [HttpStatusCode.OK].
     */
    suspend fun getCharacter(id: Int): LocationResponse? = client
        .get("character/$id")
        .accept(HttpStatusCode.OK)
        .body()

}
