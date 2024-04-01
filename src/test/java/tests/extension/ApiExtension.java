package tests.extension;

import lombok.SneakyThrows;
import object.controller.ReposController;
import object.controller.UserController;
import common.annotation.Api;
import object.pojo.Repository;
import object.pojo.User;
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
