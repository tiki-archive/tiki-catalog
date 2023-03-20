/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.l0_index.features.latest.index;

import com.mytiki.l0_index.utilities.Constants;
import com.mytiki.spring_rest_api.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = IndexController.PATH_CONTROLLER)
public class IndexController {
    public static final String PATH_CONTROLLER = ApiConstants.API_LATEST_ROUTE + "index";

    private final IndexService service;

    public IndexController(IndexService service) {
        this.service = service;
    }

    @Operation(operationId = Constants.PROJECT_DASH_PATH +  "-index-post",
            summary = "Index Block", description = "Inform the service to index a block",
            security = @SecurityRequirement(name = "l0Storage"))
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void post(@RequestBody IndexAO body) {
        service.index(body);
    }
}
