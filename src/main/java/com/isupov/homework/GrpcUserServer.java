package com.isupov.homework;

import com.isupov.homework.impl.UserServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcUserServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("User Server Started");
        Server server = ServerBuilder
                .forPort(8090)
                .addService(new UserServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
