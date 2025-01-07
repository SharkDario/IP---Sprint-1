package com.example.myapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
//import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    /* getGreeting(): Handles GET requests to /api/greeting and returns a message
    Annotation - Use @Operation to provide detailed information about an endpoint.
    This annotation helps describe the purpose, parameters, and responses of the endpoint.
    summary: A brief summary of the endpoint's functionality
    description: A detailed explanation of what the endpoint does */
    @GetMapping("/api/greeting")
    @Operation(summary = "Get Greeting", description = "Returns a greeting message")
    public String getGreeting() {
        return "Hello World";
    }

    /* submitData(): Handles POST requests to /api/submit and returns the received data
    Annotation - Use @ApiResponse to describe the possible responses from an endpoint.
    This helps define HTTP status codes and their meanings.
    responseCode: The HTTP status code that may be returned.
    description: Description of the response status
    Annotation - Use @RequestBody to define the structure and type of the request body.
    This helps document the expected format and content of the request. */
    @PostMapping("/api/submit")
    @Operation(summary = "Submit Data", description = "Receives data and returns a confirmation message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully received"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid data.")
    })
    public String submitData(@RequestBody String data) {
        return "Data received: " + data;
    }

    /* getUserById(): Handles GET requests to /api/user/{id}
    Annotation - Use @Schema to define schema properties for request bodies and responses.
    This includes data types, formats, and constraints. */
    @GetMapping("/api/user/{id}")
    @Operation(summary = "User ID", description = "Returns the user ID")
    public String getUserById(@Schema(description = "The user's ID", example = "1") @PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    /* search(): Handles GET requests to /api/search with a query parameter and returns search results
    Annotation - Use @Parameter to describe request parameters.
    This includes query parameters, path variables, and header parameters.
     */
    @GetMapping("/api/search")
    @Operation(summary = "Search", description = "Searches for items based on a query parameter.")
    public String search(
            @RequestParam(name = "query", defaultValue = "")
            @Parameter(description = "Search query") String query) {
            return "Search results for: " + query;
    }

    /* I have tried to execute this code (using the import that are commented above), but it returns a null value:
    @PostMapping("/api/submit")
    @Operation(summary = "Submit Data", description = "Receives data and returns a confirmation message.",
            requestBody = @RequestBody(description = "The data to be submitted",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "string", example = "Sample data"))))
    public String submitData(@RequestBody String data) {
        return "Data received: " + data;
    }*/
}
