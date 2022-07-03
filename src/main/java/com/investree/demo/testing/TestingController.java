package com.investree.demo.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestingController {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void save() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "    \"id_meminjam\":1,\n" +
                "    \"id_peminjam\":2,\n" +
                "    \"tenor\":1\n" +
                "    \"total_pinjaman\":1000000\n" +
                "    \"bunga_persen\":10\n" +
                "    \"status\":\"belum lunas\"\n" +
                "    \n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        ResponseEntity<String> exchange = restTemplate.exchange
                ("http://localhost:8080/api/v1/transaksi", HttpMethod.POST, entity, String.class);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response =" + exchange.getBody());
    }

    @Test
    public void updateStatus() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{   \n" +
                "    \"id\":1,\n" +
                "    \"id_meminjam\":1,\n" +
                "    \"id_peminjam\":2,\n" +
                "    \"tenor\":1\n" +
                "    \"total_pinjaman\":1000000\n" +
                "    \"bunga_persen\":10\n" +
                "    \n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080/api/v1/transaksi", HttpMethod.PUT, entity, String.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response =" + exchange.getBody());
    }
}
