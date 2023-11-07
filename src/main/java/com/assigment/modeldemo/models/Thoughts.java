package com.assigment.modeldemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Thoughts extends  BaseModel{
    @Column(nullable = false)
    private  String thought;
}
