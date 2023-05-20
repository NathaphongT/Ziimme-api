// package com.ziimme.websource.utils;

// import com.ziimme.websource.exception.MyHttpException;
// import kong.unirest.HttpResponse;
// import kong.unirest.JsonNode;
// import kong.unirest.Unirest;

// public class HttpUtil {
//     public static String doGet(String url)throws MyHttpException, Exception {
//         HttpResponse<JsonNode> response = Unirest.get(url)
//             .header("accept", "application/json").header("Content-Type", "application/json").asJson();
//             if (response.getStatus() != 200){
//                 throw new MyHttpException(response.getStatus(), response.getBody().toString());
//             }
//         return response.getBody().toString();
//     }

//     public static String doGetAuth(String url, String token) throws MyHttpException, Exception {
//         HttpResponse<JsonNode> response = Unirest.get(url).header("accept", "application/json")
//             .header("Content-Type", "application/json").header("Authorization", token).asJson();
//             if (response.getStatus() != 200) {
//                 throw new MyHttpException(response.getStatus(), response.getBody().toString());
//             }
//         return response.getBody().toString();
//     }

//     public static String doPost(String url, String json)throws MyHttpException, Exception {
//         HttpResponse<JsonNode> response = Unirest.post(url)
//             .header("accept", "application/json").header("Content-Type", "application/json").body(json).asJson();
//             if (response.getStatus() != 200){
//                 throw new MyHttpException(response.getStatus(), response.getBody().toString());
//             }
//         return response.getBody().toString();
//     }

//     public static String doGetGoogleSearch(String url, String Host, String Key)throws MyHttpException, Exception {
//         HttpResponse<JsonNode> response = Unirest.get(url)
//             .header("accept", "application/json")
//             .header("Content-Type", "application/json")
//             .header("X-RapidAPI-Host", Host)
//             .header("X-RapidAPI-Key", Key)
//             .asJson();
//             if (response.getStatus() != 200){
//                 throw new MyHttpException(response.getStatus(), response.getBody().toString());
//             }
//         return response.getBody().toString();
//     }
// }
