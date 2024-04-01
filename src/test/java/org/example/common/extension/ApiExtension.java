package org.example.common.extension;

import lombok.SneakyThrows;
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

public class ApiExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    @SneakyThrows
    public void beforeEach(ExtensionContext extensionContext) {
        Optional<Api> annotation = AnnotationSupport.findAnnotation(
                extensionContext.getTestMethod(), Api.class);
        if (annotation.isPresent()) {
            Api repAnnotation = annotation.get();
            Repository repository = new Repository(
                    repAnnotation.name(), repAnnotation.isPrivate()
            );
            new ReposController().createPublicRepository(repository);
        }
    }

    @Override
    @SneakyThrows
    public void afterEach(ExtensionContext extensionContext) {
        Optional<Api> annotation = AnnotationSupport.findAnnotation(
                extensionContext.getTestMethod(), Api.class);
        if (annotation.isPresent()) {
            Api repAnnotation = annotation.get();
            Repository repository = new Repository(
                    repAnnotation.name(), repAnnotation.isPrivate()
            );
            User user = new UserController().getUserData();
            new ReposController().deleteRepositoryHasName(user.getLogin(), repository.getName());
        }
    }
}
