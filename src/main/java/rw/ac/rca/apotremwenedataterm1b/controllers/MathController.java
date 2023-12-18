package rw.ac.rca.apotremwenedataterm1b.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.apotremwenedataterm1b.dtos.DoMathRequestDTO;
import rw.ac.rca.apotremwenedataterm1b.exceptions.InvalidOperationException;
import rw.ac.rca.apotremwenedataterm1b.services.MathOperator;

@RestController
@AllArgsConstructor
@RequestMapping("/ap1/v1/math")
public class MathController {
    private MathOperator mathService;
    @PostMapping
    public ResponseEntity doMath(@RequestBody DoMathRequestDTO request) throws InvalidOperationException{
        System.out.println("Receiving response");
       return ResponseEntity.ok(mathService.doMath(request.getOperand1(), request.getOperand2(), request.getOperation()));
    }
}
