package br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.model.entities.Category;

public class SuggestionDTO {

    private Integer id;

    @NotBlank
    private String description;
    private LocalDate data;

    private Category category;
}
