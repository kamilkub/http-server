package org.http;


import org.http.configuration.HttpServer;


public class Application {

    public static void main(String[] args) {
        HttpServer.runServer();
    }
}

//
//    private Map<String, String> collectHeaders(List<String> requestLines) throws InvalidHttpRequestException {
//
//        List<String[]> headers = collectHeaderPretenders(requestLines);
//        List<String[]> validHeaders = collectValidHeaders(headers);
//
//
//        if (validHeaders.isEmpty()) {
//            throw new InvalidHttpRequestException();
//        }
//
//        Map<String, String> headersHolder = new HashMap<>();
//
//        validHeaders.forEach(headersKV -> {
//            String hName = headersKV[0];
//            String hValue = headersKV[1];
//            headersHolder.put(hName, hValue);
//        });
//
//        return headersHolder;
//    }
//
//    private List<String[]> collectHeaderPretenders(List<String> requestLines) {
//        return requestLines.stream()
//                .filter(requestLine -> requestLine.contains(":"))
//                .map(requestLine -> requestLine.split(":"))
//                .filter(splitHeader -> splitHeader.length == HEADER_NAME_VALUE_LENGTH)
//                .collect(Collectors.toUnmodifiableList());
//    }
//
//    private List<String[]> collectValidHeaders(List<String[]> headersKeyValue) {
//        return headersKeyValue.stream()
//                .filter(splitHeader -> Arrays.stream(HttpStandardHeaders.values())
//                        .anyMatch(headerName -> headerName.val().equalsIgnoreCase(splitHeader[0])))
//                .collect(Collectors.toUnmodifiableList());
//    }
//
//    private HttpRequestMethod collectHttpMethod(List<String> requestLines) {
//        String httpRequestBegin = requestLines.get(0).toLowerCase();
//
//        return Arrays.stream(HttpRequestMethod.values())
//                .filter(httpMethod -> httpRequestBegin.contains(httpMethod.getValue().toLowerCase()))
//                .findFirst()
//                .orElse(null);
//    }