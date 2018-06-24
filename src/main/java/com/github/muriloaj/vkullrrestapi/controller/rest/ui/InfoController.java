package com.github.muriloaj.vkullrrestapi.controller.rest.ui;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(
        value = "info",
        description = "get info about API",
        tags = "infoI",
        position = 1
)

@RestController
@RequestMapping("/info")
public class InfoController {

    @Value("${version}")
    private String version;

    @ApiOperation(
            value = "Check the integration API version"
    )
    @ApiResponses(
            @ApiResponse(
                    code = 200,
                    message = "version",
                    response = String.class
            )
    )
    @RequestMapping(value = "version", method = RequestMethod.GET)
    public String getVersion() {
        return version;
    }
}
