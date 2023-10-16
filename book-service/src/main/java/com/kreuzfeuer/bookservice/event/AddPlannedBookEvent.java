package com.kreuzfeuer.bookservice.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPlannedBookEvent {
    private String email;
    private String message;
}
