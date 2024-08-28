package com.prueba.docker.pruebadocker.infra;

import lombok.NonNull;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.InternetProtocol;
import org.testcontainers.utility.DockerImageName;

public class MyGenericContainer  extends GenericContainer<MyGenericContainer> {

    public MyGenericContainer(String dockerImageName) {
        super(dockerImageName);
    }

    public MyGenericContainer addFixedExposedPorts(int hostPort, int containerPort) {
        super.addFixedExposedPort(hostPort, containerPort);
        return this;
    }
}
