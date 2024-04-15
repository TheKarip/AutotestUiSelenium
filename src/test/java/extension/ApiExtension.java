package extension;

import annotation.Api;
import lombok.SneakyThrows;
import api.controller.ReposController;
import api.controller.UserController;
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
            new ReposController().createPublicRepository(Repository.builder()
                    .name(repAnnotation.name()).isPrivate(repAnnotation.isPrivate()).build());
        }
    }

    @Override
    @SneakyThrows
    public void afterEach(ExtensionContext extensionContext) {
        Optional<Api> annotation = AnnotationSupport.findAnnotation(
                extensionContext.getTestMethod(), Api.class);
        if (annotation.isPresent()) {
            Api repAnnotation = annotation.get();
            User user = new UserController().getUserData();
            new ReposController().deleteRepositoryHasName(user.getLogin(), Repository.builder()
                    .name(repAnnotation.name()).build().getName());
        }
    }
}
