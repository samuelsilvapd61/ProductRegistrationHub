package com.samuel.exception;

import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.grpc.server.advice.GrpcAdvice;
import org.springframework.grpc.server.advice.GrpcExceptionHandler;

@Slf4j
@GrpcAdvice
public class GrpcExceptionAdvisor {

    @GrpcExceptionHandler(ProductNotFoundException.class)
    public Status handleProductNotFoundException(ProductNotFoundException exception) {
        log.warn("{}", exception.getMessage());
        return Status.NOT_FOUND.withDescription(exception.getMessage());
    }

}
