package edu.project3;

import java.time.OffsetDateTime;

public record LogRecord(String remoteAddress, String remoteUser, OffsetDateTime timeLocal, String request, int status,
                        int bodyBytesSent, String httpReferer, String httpUserAgent) {

}
