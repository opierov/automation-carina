package org.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/user/repos", methodType = HttpMethodType.POST)
//https://api.github.com/user/repos
@RequestTemplatePath(path = "api/repos/_post/rq.json")
@ResponseTemplatePath(path = "api/repos/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostRepositoryMethod extends AbstractApiMethodV2 {

    public PostRepositoryMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        setHeader("Authorization", "Bearer " + Configuration.getRequired("user_token"));
    }
}