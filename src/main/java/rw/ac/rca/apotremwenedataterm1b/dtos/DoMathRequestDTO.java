package rw.ac.rca.apotremwenedataterm1b.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoMathRequestDTO {
    
    private double operand1;
    private double operand2;
    private String operation;
}
