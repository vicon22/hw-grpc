package com.isupov.homework;

import com.isupov.homework.impl.ExpenseServiceImpl;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class GrpcExpenseServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Expense Server Started");
        Server server = ServerBuilder
                .forPort(8085)
                .addService(new ExpenseServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();

        server.start();
        server.awaitTermination();
    }
}
