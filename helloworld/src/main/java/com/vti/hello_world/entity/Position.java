package com.vti.hello_world.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "POSITION")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "POSITION_NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private PositionName PositionName;

    public static enum PositionName{
        DEV,
        TEST,
        SCRUM_MASTER,
        PM
    }

}
