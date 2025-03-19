package org.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${base_url}/repos/${OWNER}/${REPO}", methodType = HttpMethodType.GET)
//https://api.github.com/repos/OWNER/REPO
@ResponseTemplatePath(path = "api/repos/_get.exists/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.NOT_FOUND_404)
public class GetRepositoryExistsMethod extends AbstractApiMethodV2 {

    public GetRepositoryExistsMethod(String owner, String repo) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("OWNER", owner);
        replaceUrlPlaceholder("REPO", repo);
    }
}