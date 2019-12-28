/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.patientservice.client.dmscore.api;

import com.bytatech.patientservice.client.dmscore.model.Error;
import com.bytatech.patientservice.client.dmscore.model.RatingBody;
import com.bytatech.patientservice.client.dmscore.model.RatingEntry;
import com.bytatech.patientservice.client.dmscore.model.RatingPaging;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-27T16:47:46.546+05:30[Asia/Kolkata]")

@Api(value = "Ratings", description = "the Ratings API")
public interface RatingsApi {

    @ApiOperation(value = "Create a rating", nickname = "createRating", notes = "Create a rating for the node with identifier **nodeId**", response = RatingEntry.class, tags={ "ratings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful response", response = RatingEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **ratingBodyCreate** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**nodeId** does not exist "),
        @ApiResponse(code = 405, message = "Cannot rate a node of this type"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/ratings",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<RatingEntry> createRating(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "For myRating the type is specific to the rating scheme, boolean for the likes and an integer for the fiveStar." ,required=true )  @Valid @RequestBody RatingBody ratingBody,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Delete a rating", nickname = "deleteRating", notes = "Deletes rating **ratingId** from node **nodeId**.", tags={ "ratings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful response"),
        @ApiResponse(code = 400, message = "Invalid parameter: unknown rating scheme specified "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**nodeId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/ratings/{ratingId}",
        produces = "application/json", 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteRating(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "The identifier of a rating.",required=true) @PathVariable("ratingId") String ratingId);


    @ApiOperation(value = "Get a rating", nickname = "getRating", notes = "Get the specific rating **ratingId** on node **nodeId**.", response = RatingEntry.class, tags={ "ratings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = RatingEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: unknown rating scheme specified "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**nodeId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/ratings/{ratingId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<RatingEntry> getRating(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "The identifier of a rating.",required=true) @PathVariable("ratingId") String ratingId,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "List ratings", nickname = "listRatings", notes = "Gets a list of ratings for node **nodeId**.", response = RatingPaging.class, tags={ "ratings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = RatingPaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems** or **skipCount** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**nodeId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/ratings",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<RatingPaging> listRatings(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);

}