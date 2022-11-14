package com.sdy.bbbb.test;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

@Component
public class Test2 {
    public void call() throws Exception {
        // 1. URL을 만들기 위한 StringBuilder.
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088/4644556a44616e6639346c4c4a4175/xml/citydata"); /*URL*/
        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
        urlBuilder.append("/"+"1");
        urlBuilder.append("/"+"5");
        urlBuilder.append("/"+"광화문·덕수궁");

//        urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=4644556a44616e6639346c4c4a4175"); /*인증키*/
//        urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML 또는 JSON*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//        urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]", "UTF-8") + "=" + URLEncoder.encode("가나", "UTF-8")); /*한글 국가명*/
//        urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]", "UTF-8") + "=" + URLEncoder.encode("GH", "UTF-8")); /*ISO 2자리코드*/
        // 3. URL 객체 생성.
        URL url = new URL(urlBuilder.toString());
        String url2 = url.toString();
        System.out.println(url2);
        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.

        Document documentInfo;
        documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url2);
        documentInfo.getDocumentElement().normalize();
//        documentInfo.getDocumentElement().getElementsByTagName("CITYDATA");
        //Root: HRDNet
        System.out.println("Root: " + documentInfo.getDocumentElement());
        System.out.println(documentInfo.getDocumentElement().getElementsByTagName("LIVE_PPLTN_STTS").item(0).getChildNodes().item(0).getNodeValue());

        //태그접근
        Element root = documentInfo.getDocumentElement();
        NodeList nList = root.getElementsByTagName("LIVE_PPLTN_STTS").item(0).getChildNodes();
        System.out.println(nList.item(0));
        System.out.println(nList.item(0).getNodeValue());
        System.out.println(nList.item(0).getNodeName());


//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        // 5. 통신을 위한 메소드 SET.
//        conn.setRequestMethod("GET");
//        // 6. 통신을 위한 Content-type SET.
//        conn.setRequestProperty("Content-type", "application/json");
//        // 7. 통신 응답 코드 확인.
//        System.out.println("Response code: " + conn.getResponseCode());
//        //8. 전달받은 데이터를 BufferedReader 객체로 저장.
//        BufferedReader rd;
//        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//        }
//        // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            sb.append(line);
//        }
//        // 10. 객체 해제.
//        rd.close();
//        conn.disconnect();
        // 11. 전달받은 데이터 확인.
//        System.out.println(sb.toString());
    }
}

