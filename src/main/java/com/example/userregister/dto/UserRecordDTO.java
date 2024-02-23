package com.example.userregister.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDTO(@NotBlank String username, @NotBlank String name, @NotBlank String password, @NotBlank String email) {

}
