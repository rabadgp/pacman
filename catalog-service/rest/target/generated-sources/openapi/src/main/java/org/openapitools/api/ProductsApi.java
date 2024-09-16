/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ProductResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-06T16:27:15.248881+02:00[Europe/Madrid]")
@Validated
@Tag(name = "products", description = "Catalog products")
public interface ProductsApi {

    /**
     * GET /products
     *
     * @param category Product category (required)
     * @param metrics List of metrics code (required)
     * @param weights List of metrics weights (optional)
     * @return Successful operation (status code 200)
     *         or No content (status code 204)
     *         or Bad request (status code 400)
     */
    @Operation(
        operationId = "findProductByCategoryAndMetrics",
        tags = { "Products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "400", description = "Bad request")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products",
        produces = { "application/json" }
    )
    ResponseEntity<List<ProductResponseDTO>> findProductByCategoryAndMetrics(
        @NotNull @Parameter(name = "category", description = "Product category", required = true) @Valid @RequestParam(value = "category", required = true) String category,
        @NotNull @Parameter(name = "metrics", description = "List of metrics code", required = true) @Valid @RequestParam(value = "metrics", required = true) List<String> metrics,
        @Parameter(name = "weights", description = "List of metrics weights") @Valid @RequestParam(value = "weights", required = false) List<Double> weights
    );

}
