package br.com.motix.controllers;

import br.com.motix.dto.UserDTO;
import br.com.motix.models.User;
import br.com.motix.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Operações CRUD para usuários")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Listar todos os usuários",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso")
            }
    )
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @Operation(summary = "Buscar usuário por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    @GetMapping("/{id:[0-9a-fA-F\\-]{36}}")
    public User findById(
            @Parameter(description = "ID do usuário", required = true)
            @PathVariable UUID id) {
        return userService.findById(id);
    }

    @Operation(summary = "Buscar usuário por RM",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    @GetMapping("/rm/{rm}")
    public User findByRm(
            @Parameter(description = "RM do usuário", required = true)
            @PathVariable String rm) {
        return userService.findByRm(rm);
    }

    @Operation(summary = "Buscar usuários por nome",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuários encontrados")
            }
    )
    @GetMapping("/{name}")
    public List<User> findByName(
            @Parameter(description = "Nome do usuário", required = true)
            @PathVariable String name) {
        return userService.findByName(name);
    }

    @Operation(summary = "Atualizar usuário por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    @PutMapping
    public User updateUser(
            @Parameter(description = "ID do usuário", required = true)
            @RequestBody UserDTO user) {
        return userService.updateUser(user.toEntity());
    }

    @Operation(summary = "Cadastrar novo usuário",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
            }
    )
    @PostMapping
    public User postUser(@RequestBody UserDTO user) {
        return userService.postUser(user.toEntity());
    }

    @Operation(summary = "Deletar usuário por ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public void deleteUserById(
            @Parameter(description = "ID do usuário", required = true)
            @PathVariable UUID id) {
        userService.deleteUserById(id);
    }

    @Operation(summary = "Deletar usuário por RM",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    @DeleteMapping("/rm/{rm}")
    public void deleteUserByRm(
            @Parameter(description = "RM do usuário", required = true)
            @PathVariable String rm) {
        userService.deleteUserByRm(rm);
    }
}
