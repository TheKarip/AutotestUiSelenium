package org.example.common.extension;

import org.example.common.annotation.Api;
import org.example.common.controller.ReposController;
import org.example.common.controller.UserController;
import org.example.common.pojo.Repository;
import org.example.common.pojo.User;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

import java.util.Optional;
import java.util.logging.Logger;

public class ApiExtension implements BeforeEachCallback, AfterEachCallback {

    private static Logger log = Logger.getLogger(ApiExtension.class.getName());

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Optional<Api> annotation = AnnotationSupport.findAnnotation(
                extensionContext.getTestMethod(), Api.class);

        if (annotation.isPresent()) {
            Api repAnnotation = annotation.get();
            Repository repository = new Repository(
                    repAnnotation.name(), repAnnotation.isPrivate()
            );
            log.info("Create repository");

            new ReposController().createPublicRepository(repository);
        }
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        Optional<Api> annotation = AnnotationSupport.findAnnotation(
                extensionContext.getTestMethod(), Api.class);

        if (annotation.isPresent()) {
            Api repAnnotation = annotation.get();
            Repository repository = new Repository(
                    repAnnotation.name(), repAnnotation.isPrivate()
            );
            log.info("Delete repository");
            User user = new UserController().getUserData();
            new ReposController().deleteRepositoryHasName(user.getLogin(), repository.getName());
        }
    }
}
