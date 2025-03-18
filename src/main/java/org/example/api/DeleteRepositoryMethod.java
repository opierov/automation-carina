package org.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/repos/${OWNER}/${REPO}", methodType = HttpMethodType.DELETE)
//https://api.github.com/repos/OWNER/REPO
@SuccessfulHttpStatus(status = HttpResponseStatusType.NO_CONTENT_204)
public class DeleteRepositoryMethod extends AbstractApiMethodV2 {

    public DeleteRepositoryMethod(String owner, String repo) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("OWNER", owner);
        replaceUrlPlaceholder("REPO", repo);
        setHeader("Authorization", "Bearer " + Configuration.getRequired("user_token"));
    }
}
