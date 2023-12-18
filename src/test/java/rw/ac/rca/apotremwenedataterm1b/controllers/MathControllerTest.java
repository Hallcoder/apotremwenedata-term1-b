package rw.ac.rca.apotremwenedataterm1b.controllers;

import com.devopsclass.exam.payload.ApiResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import rw.ac.rca.apotremwenedataterm1b.dtos.DoMathRequestDTO;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void doMathOperation_Success() {
        DoMathRequestDTO dto = new DoMathRequestDTO(4, 9, "+");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/math/doMath", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCode().value());
    }
}