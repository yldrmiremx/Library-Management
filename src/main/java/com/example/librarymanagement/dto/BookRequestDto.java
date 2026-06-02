package com.example.librarymanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {

    @NotBlank(message = "Kitap adı boş olamaz")
    private String title;

    @NotBlank(message = "Yazar adı boş olamaz")
    private String author;

    @Min(value = 1, message = "Sayfa sayısı en az 1 olmalıdır")
    private int pageCount;

    private boolean available;
}
