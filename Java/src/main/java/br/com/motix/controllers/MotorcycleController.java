package br.com.motix.controllers;


import br.com.motix.dto.MotorcycleDTO;
import br.com.motix.models.Motorcycle;
import br.com.motix.services.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/bikes")
@Tag(name = "Motorcycle", description = "Operações CRUD para motocicletas")
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping
    @Operation(summary = "Listar todas as motocicletas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Motocicletas listadas com sucesso")
            })
    public List<Motorcycle> findAll() {
        return motorcycleService.findAll();
    }

    @GetMapping("/plate-error")
    @Operation(summary = "Listar motocicletas com falha na leitura da placa",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Motocicletas com erro de placa listadas com sucesso")
            })
    public List<Motorcycle> findAllPlateErrors() {
        return motorcycleService.findAllReadPlatesFalse();
    }

    @GetMapping("/{id:[0-9a-fA-F\\-]{36}}")
    @Operation(summary = "Buscar motocicleta por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Motocicleta encontrada"),
                    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
            })
    public Motorcycle findById(
            @Parameter(description = "UUID da motocicleta") @PathVariable UUID id) {
        return motorcycleService.findById(id);
    }

    @GetMapping("/{plate}")
    @Operation(summary = "Buscar motocicleta por placa",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Motocicleta encontrada"),
                    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
            })
    public Motorcycle findByPlate(
            @Parameter(description = "Placa da motocicleta") @PathVariable String plate) {
        return motorcycleService.findByPlate(plate);
    }

    @PutMapping("/plate")
    @Operation(summary = "Atualizar apenas a placa de uma motocicleta",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Placa atualizada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
            })
    public Motorcycle updatePlate(@RequestBody Motorcycle motorcycle) {
        return motorcycleService.updatePlate(motorcycle.getId(), motorcycle.getPlate());
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova motocicleta",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Motocicleta criada com sucesso")
            })
    public Motorcycle postMotocycle(@RequestBody MotorcycleDTO motorcycle){
        return motorcycleService.postMotorcycle(motorcycle.toEntity());
    }

    @PutMapping
    @Operation(summary = "Atualizar uma motocicleta existente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Motocicleta atualizada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
            })
    public Motorcycle updateMotocycle(@RequestBody Motorcycle motorcycle){
        return motorcycleService.updateMotorcycle(motorcycle);
    }

    @DeleteMapping("/{id:[0-9a-fA-F\\-]{36}}")
    @Operation(summary = "Deletar motocicleta por ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Motocicleta deletada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
            })
    public void deleteMotocycleById(@PathVariable UUID id) {
        motorcycleService.deleteMotorcycleById(id);
    }

    @DeleteMapping("/{plate}")
    @Operation(summary = "Deletar motocicleta por placa",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Motocicleta deletada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Motocicleta não encontrada")
            })
    public void deleteMotocycleByPlate(@PathVariable String plate) {
        motorcycleService.deleteMotorcycleByPlate(plate);
    }
}

