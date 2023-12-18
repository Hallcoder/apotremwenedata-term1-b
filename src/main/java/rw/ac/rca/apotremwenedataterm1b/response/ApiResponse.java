package rw.ac.rca.apotremwenedataterm1b.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private double calcResponse;
}
