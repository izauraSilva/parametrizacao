package br.com.original.bimo.param.aptidao.credito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ParameterCnaeRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max=9, message="Code - maximum 9 characters allowed")
    @NotNull(message = "code is required")
    private String code;

    @NotNull(message = "description is required")
    private String description;

}
